package org.universities.organization_educational_process.core.security.bruteforce;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.UsersInfoRepository;
import org.universities.organization_educational_process.persistence.model.UsersInfo;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

@Service("bruteForceProtectionService")
public class BruteForceProtectionServiceImpl implements BruteForceProtectionService {
    @Getter
    @Value("${jdj.security.failedlogin.count}")
    private int maxFailedLogins;

    @Autowired
    private UsersInfoRepository userRepository;

    @Value("${jdj.brute.force.cache.max}")
    private int cacheMaxLimit;

    private final ConcurrentHashMap<String, FailedLogin> cache;

    public BruteForceProtectionServiceImpl() {
        this.cache = new ConcurrentHashMap<>(cacheMaxLimit);
    }

    @Override
    public void registerLoginFailure(String username) {
        UsersInfo user = getUser(username);
        if(user!=null && !user.isLoginDisabled()){
            int failedCounter = user.getFailedLoginAttempts();
            if(maxFailedLogins < failedCounter+1){
                user.setLoginDisabled(true);
            }
            else{
                user.setFailedLoginAttempts(failedCounter+1);
            }
            userRepository.save(user);
        }
    }

    @Override
    public void resetBruteForceCounter(String username) {
        UsersInfo user =getUser(username);
        if(user!=null) {
            user.setFailedLoginAttempts(0);
            user.setLoginDisabled(false);
            userRepository.save(user);
        }
    }

    @Override
    public boolean isBruteForceAttack(String username) {
        UsersInfo user =getUser(username);
        if(user !=null){
            return user.getFailedLoginAttempts() >= maxFailedLogins;
        }
        return false;
    }

    protected FailedLogin getFailedLogin(final String username){
        FailedLogin failedLogin = cache.get(username.toLowerCase());

        if(failedLogin == null){
            failedLogin = new FailedLogin(0, LocalDateTime.now());
            cache.put(username.toLowerCase(), failedLogin);
            if(cache.size() > cacheMaxLimit){

                // add the logic to remve the key based by timestamp
            }
        }
        return failedLogin;
    }


    private UsersInfo getUser(final String username){
        return  userRepository.findByUserEmail(username);
    }

    public void setMaxFailedLogins(int maxFailedLogins) {
        this.maxFailedLogins = maxFailedLogins;
    }

    @Getter
    @Setter
    public static class FailedLogin{

        private int count;
        private LocalDateTime date;

        public FailedLogin() {
            this.count = 0;
            this.date = LocalDateTime.now();
        }

        public FailedLogin(int count, LocalDateTime date) {
            this.count = count;
            this.date = date;
        }
    }
}

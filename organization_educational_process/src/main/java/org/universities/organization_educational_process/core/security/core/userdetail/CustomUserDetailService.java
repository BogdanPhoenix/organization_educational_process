package org.universities.organization_educational_process.core.security.core.userdetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.UsersInfoRepository;
import org.universities.organization_educational_process.persistence.model.UsersInfo;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UsersInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UsersInfo customer = repository.findByUserEmail(username);

        if(customer == null){
            throw new UsernameNotFoundException(username);
        }

        return CustomUser.CustomUserBuilder.aCustomUser()
                .withUsername(customer.getUserEmail())
                .withPassword(customer.getPasswordUser())
                .withEnabled(customer.isLoginDisabled())
                .withAuthorities(customer.getRole())
                .withSecret(customer.getSecret())
                .withAccountNonLocked(false)
                .build();
    }
}

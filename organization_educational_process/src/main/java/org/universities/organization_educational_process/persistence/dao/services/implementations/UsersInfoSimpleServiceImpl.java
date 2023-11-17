package org.universities.organization_educational_process.persistence.dao.services.implementations;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.UsersInfoRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.UsersInfoSimpleService;
import org.universities.organization_educational_process.persistence.model.UsersInfo;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsersInfoSimpleServiceImpl implements UsersInfoSimpleService {
    private final UsersInfoRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean isExistUser(@NonNull UsersInfo user) {
        return isExistUser(user.getUserEmail());
    }

    @Override
    public boolean isExistUser(String userEmail) {
        return repository
                .findByUserEmail(userEmail)
                .isPresent();
    }

    @Override
    public UsersInfo createUser(UsersInfo user) {
        String email = user.getUserEmail();
        user.setPasswordUser(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new User with email: {}", email);
        return repository.save(user);
    }

    @Override
    public List<UsersInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteAllUsers() {
        repository.deleteAll();
    }
}

package org.universities.organization_educational_process.persistence.dao.services.implementations;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.UsersInfoRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.UsersInfoSimpleService;
import org.universities.organization_educational_process.persistence.model.UsersInfo;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsersInfoSimpleServiceImpl implements UsersInfoSimpleService {
    private final UsersInfoRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean isExistUser(@NonNull UsersInfo user) {
        String email = user.getUserEmail();
        return repository.findByUserEmail(email) == null;
    }

    @Override
    public void createUser(UsersInfo user) {
        String email = user.getUserEmail();
        user.setPasswordUser(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new User with email: {}", email);
        repository.save(user);
    }
}
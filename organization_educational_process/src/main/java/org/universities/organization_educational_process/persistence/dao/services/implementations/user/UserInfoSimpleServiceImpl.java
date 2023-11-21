package org.universities.organization_educational_process.persistence.dao.services.implementations.user;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.requests.user.ChangePasswordRequest;
import org.universities.organization_educational_process.persistence.dao.repositories.user.UserInfoRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.user.UserInfoSimpleService;
import org.universities.organization_educational_process.persistence.model.user.UserInfo;

import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserInfoSimpleServiceImpl implements UserInfoSimpleService {
    private final UserInfoRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void changePassword(
            @NonNull ChangePasswordRequest request,
            @NonNull Principal connectedUser
    ){
        var user = (UserInfo)((UsernamePasswordAuthenticationToken)connectedUser).getPrincipal();

        if(!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())){
            throw new IllegalStateException("Wrong password");
        }

        if(!request.getNewPassword().equals(request.getConfirmationPassword())){
            throw new IllegalStateException("Password are not the same");
        }

        user.setPasswordUser(passwordEncoder.encode(request.getNewPassword()));
        repository.save(user);
    }

    @Override
    public List<UserInfo> findAll() {
        return repository.findAll();
    }
}

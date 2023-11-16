package org.universities.organization_educational_process.persistence.dao.services.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.UsersInfoRepository;
import org.universities.organization_educational_process.persistence.model.UsersInfo;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UsersInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsersInfo user = repository.findByUserEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

//        return new User(
//                user.getUsername(),
//                user.getPassword(),
//                user.getAuthorities()
//        );
//        return User.withUsername(user.getUserEmail())
//                .password(user.getPassword())
//                .disabled(!user.isCurrentData())
//                .authorities(user.getAuthorities())
//                .build();
        return null;
    }
}

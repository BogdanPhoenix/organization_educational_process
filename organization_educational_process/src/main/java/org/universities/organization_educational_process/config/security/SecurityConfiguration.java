package org.universities.organization_educational_process.config.security;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {
    private static final String URI_PATTERN = "/%s/%s/**";
    private static final String MAIN = "organization-educational-process";
    private static final String AUTHORIZATION = "auth";
    private static final String REFERENCE_BOOK = "reference-book";
    private static final String USER = "user";

    private final String[] whiteListUri = {
            String.format(URI_PATTERN, MAIN, AUTHORIZATION),
            String.format(URI_PATTERN, MAIN, REFERENCE_BOOK),
            String.format(URI_PATTERN, MAIN, USER)
    };
    private final String[] adminListUri = {
            String.format(URI_PATTERN, MAIN, REFERENCE_BOOK)
    };

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(@NonNull HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers(whiteListUri).permitAll()
//                        .requestMatchers("/admin_page").hasAuthority(Role.ADMIN.name())
//                        .requestMatchers(POST, adminListUri).hasAnyAuthority(Role.ADMIN.name(), Role.UNIVERSITY_ADMIN.name())
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.logoutUrl(String.format("/%s/%s/logout", MAIN, AUTHORIZATION))
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler(((request, response, authentication) -> SecurityContextHolder.clearContext()))
                );

        return http.build();
    }
}

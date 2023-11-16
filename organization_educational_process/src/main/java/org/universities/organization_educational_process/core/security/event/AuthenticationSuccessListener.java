package org.universities.organization_educational_process.core.security.event;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.universities.organization_educational_process.core.security.bruteforce.BruteForceProtectionService;

@Component
@Slf4j
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {
    @Resource(name = "bruteForceProtectionService")
    private BruteForceProtectionService bruteForceProtectionService;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        String userName = event.getAuthentication().getName();
        log.info("********* login successful for user {} ", userName);
        bruteForceProtectionService.resetBruteForceCounter(userName);
    }
}

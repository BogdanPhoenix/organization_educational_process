package org.universities.organization_educational_process.core.email;

import org.springframework.web.util.UriComponentsBuilder;
import org.universities.organization_educational_process.persistence.model.UsersInfo;

public class ForgotPasswordEmailContext extends AbstractEmailContext{
    @Override
    public <T extends UsersInfo> void init(T context) {
        put("firstName", context.getFirstName());
        setTemplateLocation("emails/forgot-password");
        setSubject("Forgotten Password");
        setFrom("no-reply@javadevjournal.com");
        setTo(context.getUserEmail());
    }

    @Override
    public void buildVerificationUrl(final String baseURL, final String token){
        final String url= UriComponentsBuilder.fromHttpUrl(baseURL)
                .path("/password/change").queryParam("token", token).toUriString();
        put("verificationURL", url);
    }
}

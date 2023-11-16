package org.universities.organization_educational_process.core.email;

import org.springframework.web.util.UriComponentsBuilder;
import org.universities.organization_educational_process.persistence.model.UsersInfo;

public class AccountVerificationEmailContext extends AbstractEmailContext {
    @Override
    public <T extends UsersInfo> void init(T context){
        put("firstName", context.getFirstName());
        setTemplateLocation("emails/email-verification");
        setSubject("Complete your registration");
        setFrom("no-reply@javadevjournal.com");
        setTo(context.getUserEmail());
    }

    @Override
    public void buildVerificationUrl(final String baseURL, final String token){
        final String url= UriComponentsBuilder.fromHttpUrl(baseURL)
                .path("/registration/verify").queryParam("token", token).toUriString();
        put("verificationURL", url);
    }
}

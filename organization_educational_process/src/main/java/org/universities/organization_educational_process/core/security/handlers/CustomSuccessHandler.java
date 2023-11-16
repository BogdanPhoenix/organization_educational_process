package org.universities.organization_educational_process.core.security.handlers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.thymeleaf.util.StringUtils;
import org.apache.commons

import java.io.IOException;

public class CustomSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final GrantedAuthority adminAuthority = new SimpleGrantedAuthority(
            "ROLE_ADMIN");

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        if(isAdminAuthority(authentication)){
            String targetUrl="home/admin";
            clearAuthenticationAttributes(request);
            getRedirectStrategy().sendRedirect(request, response, targetUrl);
        }
        else{
            String targetUrl= determineTargetUrl(request, response); // using the super class to do this work for us

            // this logic is only for demo purpose, please do not use it on production application.
            if(StringUtils.isEmpty(targetUrl) || StringUtils.equals(targetUrl, "/")){
                targetUrl= "/account/home";
            }
            clearAuthenticationAttributes(request);
            getRedirectStrategy().sendRedirect(request, response, targetUrl);

            //You can let Spring security handle it for you.
            // super.onAuthenticationSuccess(request, response, authentication);
        }
    }



    protected boolean isAdminAuthority(final Authentication authentication)
    {
        return CollectionUtils.isNotEmpty(authentication.getAuthorities())
                && authentication.getAuthorities().contains(adminAuthority);
    }
}

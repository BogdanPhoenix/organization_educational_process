package org.universities.organization_educational_process.core.security.authentication;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.universities.organization_educational_process.core.security.core.userdetail.CustomUser;
import org.universities.organization_educational_process.core.security.mfa.MFATokenManager;
import org.universities.organization_educational_process.core.web.authentication.CustomWebAuthenticationDetails;

@Controller
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {
    @Resource
    private MFATokenManager mfaTokenManager;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Autowired
    public CustomAuthenticationProvider(UserDetailsService userDetailsService){
        super.setUserDetailsService(userDetailsService);
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException{
        super.additionalAuthenticationChecks(userDetails, authentication);

        CustomWebAuthenticationDetails authenticationDetails = (CustomWebAuthenticationDetails) authentication.getDetails();
        CustomUser user = (CustomUser) userDetails;
        String mfaToken = authenticationDetails.getToken();

        if(!mfaTokenManager.verifyTotp(mfaToken,user.getSecret())){
            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }
    }
}

package org.universities.organization_educational_process.core.web.authentication;

import jakarta.servlet.http.HttpServletRequest;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
    private String token;

    public CustomWebAuthenticationDetails(HttpServletRequest request){
        super(request);
        this.token = request.getParameter("jdjCustomToken");
    }

    @Override
    public String toString() {
        return "CustomWebAuthenticationDetails{" +
                "token='" + token + '\'' +
                '}';
    }
}

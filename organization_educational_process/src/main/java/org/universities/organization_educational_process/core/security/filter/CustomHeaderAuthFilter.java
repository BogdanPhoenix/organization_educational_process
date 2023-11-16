package org.universities.organization_educational_process.core.security.filter;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class CustomHeaderAuthFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var request = (HttpServletRequest) servletRequest;
        var response = (HttpServletResponse)servletResponse;
        filterChain.doFilter(servletRequest, servletResponse);

        String authHeader = request.getHeader("X-HEADER");
        if(StringUtils.isEmpty(authHeader)){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}

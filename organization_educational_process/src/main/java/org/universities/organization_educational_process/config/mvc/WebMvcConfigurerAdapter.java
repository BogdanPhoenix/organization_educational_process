package org.universities.organization_educational_process.config.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration(proxyBeanMethods = false)
@EnableWebMvc
public class WebMvcConfigurerAdapter implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/admin-page").setViewName("admin-page");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/api/v1/auth/registration").setViewName("registration");
        registry.addViewController("/api/v1/auth/authentication").setViewName("authentication");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/role").setViewName("role");
        registry.addViewController("/user").setViewName("user");
    }
}

package org.universities.organization_educational_process.config.mvc;

import lombok.NonNull;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration(proxyBeanMethods = false)
@EnableWebMvc
public class WebMvcConfigurerAdapter implements WebMvcConfigurer {
    @Override
    public void addViewControllers(@NonNull ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/user").setViewName("user");

        addViewControllerAdmin(registry);
        addViewControllerReferenceBook(registry);
    }

    private void addViewControllerAdmin(@NonNull ViewControllerRegistry registry){
        registry.addViewController("/admin-page").setViewName("admin-page");
    }

    private void addViewControllerReferenceBook(@NonNull ViewControllerRegistry registry){
        registry.addViewController("/academic-degree").setViewName("reference-book/academic-degree");
    }
}

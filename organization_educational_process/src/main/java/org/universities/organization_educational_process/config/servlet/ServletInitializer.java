package org.universities.organization_educational_process.config.servlet;

import lombok.NonNull;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.universities.organization_educational_process.OrganizationEducationalProcessApplication;

public class ServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(@NonNull SpringApplicationBuilder application) {
		return application.sources(OrganizationEducationalProcessApplication.class);
	}
}

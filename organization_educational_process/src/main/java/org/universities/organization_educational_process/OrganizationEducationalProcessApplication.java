package org.universities.organization_educational_process;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableJpaRepositories(basePackages = "org.universities.organization_educational_process.persistence.dao.repositories")
public class OrganizationEducationalProcessApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrganizationEducationalProcessApplication.class, args);
	}
}

package com.example.novalearn;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.novalearn.dao.SiteOwnerDao;
import com.example.novalearn.entity.Role;
import com.example.novalearn.entity.SiteOwner;

@SpringBootApplication
public class NovalearnApplication {

	@Autowired
	private SiteOwnerDao siteOwnerDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean  @Profile("dev")
	public ApplicationRunner runner() {
		return args -> {
			SiteOwner siteOwner = new SiteOwner("John", "Doe", "2Hs2G@example.com", "johndoe", passwordEncoder.encode("12345"), BigDecimal.valueOf(0.5));
			
			Role role = new Role();
			role.setRoleName("ROLE_SITE_OWNER");
			siteOwner.addRole(role);
			siteOwnerDao.save(siteOwner);
			// siteOwnerDao.findAll().forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(NovalearnApplication.class, args);
	}

}

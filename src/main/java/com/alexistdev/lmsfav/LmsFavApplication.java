package com.alexistdev.lmsfav;

import com.alexistdev.lmsfav.dto.RoleRequest;
import com.alexistdev.lmsfav.entity.Role;
import com.alexistdev.lmsfav.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class LmsFavApplication {

	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(LmsFavApplication.class, args);
	}

	@Bean
	CommandLineRunner seedUser() {
		return args -> {
			RoleRequest role = new RoleRequest();
//			role.builder()
//					.name("admin")
//					.description("administrator")
//					.status("1")
//					.createdBy("system")
//					.modifiedBy("system")
//					.build();
			role.setName("admin");
			role.setDescription("Admin");
			role.setStatus("1");
			roleService.add(role);
		};
	}

}

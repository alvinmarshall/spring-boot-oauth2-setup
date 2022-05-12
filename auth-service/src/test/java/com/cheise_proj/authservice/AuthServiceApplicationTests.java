package com.cheise_proj.authservice;

import com.cheise_proj.authservice.domain.model.AppClient;
import com.cheise_proj.authservice.domain.model.Permission;
import com.cheise_proj.authservice.domain.model.Role;
import com.cheise_proj.authservice.domain.model.User;
import com.cheise_proj.authservice.domain.repository.ClientRepository;
import com.cheise_proj.authservice.domain.repository.RoleRepository;
import com.cheise_proj.authservice.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootTest
@Slf4j
class AuthServiceApplicationTests {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private ClientRepository clientRepository;
	private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	@Test
	void contextLoads() {
		Role role = Role.builder()
				.name("admin")
				.permissions(Set.of(Permission.builder().name("read_user").build()))
				.build();
		Role saveRole = roleRepository.save(role);

		User user = User.builder()
				.email("admin@me.com")
				.businessUnit("NY-BU")
				.username("admin")
				.role(role)
				.password(passwordEncoder.encode("admin"))
				.build();

		User saveUser = userRepository.save(user);
		log.info("user: {}",saveUser);
		log.info("role: {}",saveRole);
	}

	@Test
	void sefff() {
		AppClient client = AppClient.builder()
				.clientId("user-service")
				.clientSecret(passwordEncoder.encode("123456"))
				.scope("read,write")
				.authorizedGrantTypes("password,authorization_code,refresh_token,client_credentials")
				.webServerRedirectUri("http://localhost:8082/login")
				.authorities("ROLE_CLIENT")
				.accessTokenValidity(36000)
				.refreshTokenValidity(36000)
				.resourceIds("user-resource")
				.addInfo(null)
				.autoApprove("true")
				.build();
		AppClient save = clientRepository.save(client);
		log.info("save: {}",save);
	}
}

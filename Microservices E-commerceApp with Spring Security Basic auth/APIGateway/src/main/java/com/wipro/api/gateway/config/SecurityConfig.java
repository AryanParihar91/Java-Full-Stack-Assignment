package com.wipro.api.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public MapReactiveUserDetailsService userDetailsService() {
		UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("admin123").roles("ADMIN")
				.build();

		UserDetails user = User.withDefaultPasswordEncoder().username("aryan").password("aryan123").roles("USER")
				.build();

		return new MapReactiveUserDetailsService(admin, user);
	}

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		return  http
				.csrf(csrf -> csrf.disable())
				.authorizeExchange(exchange -> exchange
						.pathMatchers("/fallback/**").permitAll()
                        .pathMatchers("/actuator/health").permitAll()
                        .pathMatchers("api/customers/**").authenticated()
                        .pathMatchers("api/products/**").authenticated()
                        .pathMatchers("api/orders/**").authenticated()
                        .anyExchange().authenticated()
						)
				.httpBasic(Customizer.withDefaults())
				.formLogin(form -> form.disable())
				.build();
	}

}

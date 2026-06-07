package com.wipro.api.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.wipro.api.gateway.util.JwtUtil;

import reactor.core.publisher.Mono;

@Component
public class JwtFilter implements GlobalFilter, Ordered {

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		String path = exchange.getRequest().getURI().getPath();

		System.out.println("JWT FILTER PATH: " + path);

		if (path.startsWith("/users/login") || 
			path.startsWith("/users/registration") ||
			path.startsWith("/oauth2") || 
			path.startsWith("/login/oauth2")) {

			return chain.filter(exchange);
		}

		if (path.startsWith("/fallback")) {
			return chain.filter(exchange);
		}

		if (path.startsWith("/api/")) {

			String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

			System.out.println("AUTH HEADER: " + authHeader);

			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
				return exchange.getResponse().setComplete();
			}

			String token = authHeader.substring(7);

			if (!jwtUtil.validateToken(token)) {
				exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
				return exchange.getResponse().setComplete();
			}

			System.out.println("JWT TOKEN VALID");
		}

		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return -1;
	}
}
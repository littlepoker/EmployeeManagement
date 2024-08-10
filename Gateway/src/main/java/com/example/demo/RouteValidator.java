package com.example.demo;

import java.util.List;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import com.google.common.base.Predicate;


@Component
public class RouteValidator {
	List<String> openApiEndPoints = List.of("/auth/register", "/auth/login", "/auth/validate", "auth/logout");

	public Predicate<ServerHttpRequest> isSecured = request -> openApiEndPoints.stream()
			.noneMatch(uri -> request.getURI()
					.getPath()
					.contains(uri));
	
	List<String> adminEndPoints = List.of("/admin/");
	
	public Predicate<ServerHttpRequest> isAdmin = request -> adminEndPoints.stream()
			.anyMatch(uri -> request.getURI()
					.getPath()
					.contains(uri));
}

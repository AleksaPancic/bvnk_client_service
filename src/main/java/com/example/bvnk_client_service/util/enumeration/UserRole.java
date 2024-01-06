package com.example.bvnk_client_service.util.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum UserRole {
	GUEST("GUEST_ROLE"),
	USER("USER_ROLE"),
	ADMIN("ADMIN_ROLE");

	private String description;
}

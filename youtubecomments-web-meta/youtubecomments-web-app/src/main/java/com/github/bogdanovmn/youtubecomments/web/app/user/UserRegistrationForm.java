package com.github.bogdanovmn.youtubecomments.web.app.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

class UserRegistrationForm {
	@NotNull
	@Size(min=3, max=20)
	private String name;

	@NotNull
	@Size(min=1, max=32)
	private String password;

	@NotNull
	@Size(min=1, max=32)
	private String passwordConfirm;

	@NotNull
	private String email;


	String getName() {
		return name;
	}

	UserRegistrationForm setName(String name) {
		this.name = name;
		return this;
	}

	String getPassword() {
		return password;
	}

	UserRegistrationForm setPassword(String password) {
		this.password = password;
		return this;
	}

	String getPasswordConfirm() {
		return passwordConfirm;
	}

	UserRegistrationForm setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
		return this;
	}

	String getEmail() {
		return email;
	}

	UserRegistrationForm setEmail(String email) {
		this.email = email;
		return this;
	}
}

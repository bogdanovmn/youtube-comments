package com.github.bogdanovmn.youtubecomments.web.app.user;

import javax.validation.constraints.Size;

class UserSettingsForm {
	@Size(min=1, max=32)
	private String currentPassword;

	@Size(min=1, max=32)
	private String newPassword;

	@Size(min=1, max=32)
	private String newPasswordConfirm;

	String getNewPassword() {
		return newPassword;
	}

	UserSettingsForm setNewPassword(String newPassword) {
		this.newPassword = newPassword;
		return this;
	}

	String getNewPasswordConfirm() {
		return newPasswordConfirm;
	}

	UserSettingsForm setNewPasswordConfirm(String newPasswordConfirm) {
		this.newPasswordConfirm = newPasswordConfirm;
		return this;
	}

	String getCurrentPassword() {
		return currentPassword;
	}

	UserSettingsForm setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
		return this;
	}
}

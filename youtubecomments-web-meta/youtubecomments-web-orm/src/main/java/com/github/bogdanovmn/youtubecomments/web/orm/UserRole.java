package com.github.bogdanovmn.youtubecomments.web.orm;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class UserRole extends BaseEntityWithUniqueName {
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	public UserRole() {
	}

	public UserRole(String name) {
		super(name);
	}

	public Set<User> getUsers() {
		return users;
	}

	public UserRole setUsers(Set<User> users) {
		this.users = users;
		return this;
	}
}

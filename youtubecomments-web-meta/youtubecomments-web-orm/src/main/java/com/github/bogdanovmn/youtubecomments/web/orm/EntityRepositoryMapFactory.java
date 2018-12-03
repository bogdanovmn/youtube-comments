package com.github.bogdanovmn.youtubecomments.web.orm;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class EntityRepositoryMapFactory {
	private Map<Class<? extends BaseEntityWithUniqueName>, BaseEntityWithUniqueNameRepository> map;

	@Autowired
	private UserRoleRepository userRoleRepository;

	public EntityRepositoryMapFactory() {
	}

	private void init() {
		this.map = new HashMap<Class<? extends BaseEntityWithUniqueName>, BaseEntityWithUniqueNameRepository>()
		{{
			put(UserRole.class,          userRoleRepository);
		}};
	}

	public BaseEntityWithUniqueNameRepository getRepository(Class<? extends BaseEntityWithUniqueName> aClass) {
		return this.map.get(aClass);
	}
}

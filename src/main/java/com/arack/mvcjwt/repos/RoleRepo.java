package com.arack.mvcjwt.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.arack.mvcjwt.domain.Role;

public interface RoleRepo extends MongoRepository<Role, String> {

	Role findRoleByName(String name);

}

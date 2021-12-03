package com.arack.mvcjwt.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.arack.mvcjwt.domain.User;

public interface UserRepo extends MongoRepository<User, String> {
	Optional<User> findById(String id);

	User findUserById(String id);

	Optional<User> findByUsername(String username);

	User findUserByUsername(String username);

	Optional<User> findByUsernameAndPassword(String username, String password);

	User findUserByUsernameAndPassword(String username, String password);

	List<User> findByUsernameContaining(String name);

}

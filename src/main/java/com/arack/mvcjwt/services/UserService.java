package com.arack.mvcjwt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arack.mvcjwt.domain.User;
import com.arack.mvcjwt.repos.UserRepo;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;

	public void insertUser(User user) {
		userRepo.insert(user);
	}

	public void updateUser(User user) {
		userRepo.save(user);
	}

	public User getUserFromId(String id) {
		return userRepo.findUserById(id);
	}

	public Optional<User> findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	public User findUserByUsername(String username) {
		return userRepo.findUserByUsername(username);
	}

	public List<User> ListUserByLoginNameContaining(String name) {
		return userRepo.findByUsernameContaining(name);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户不存在");
		}
		return user;
	}

}
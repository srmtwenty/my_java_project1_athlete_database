package com.scott.b_springData2_self_project2022a.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.scott.b_springData2_self_project2022a.models.User;
import com.scott.b_springData2_self_project2022a.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	public List<User> allUsers(){	
		return userRepository.findAll();
	}
	public User findUser(Long id) {
		Optional<User> optional=userRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	public Long countByCompetitionsId(Long id) {
		return userRepository.countByCompetitions_Id(id);
	}
	public Long countByAttendeesByCompetitions_Id(Long id) {
		return userRepository.countAttendeesByCompetitions_Id(id);
	}
	public User createUser(User u) {
		String hashed=BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
		u.setPassword(hashed);
		return userRepository.save(u);
	}
	public boolean authenticationUser(String email, String password) {
		User user=userRepository.findByEmail(email);
		if(user==null) {
			return false;
		}else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
	}
	
}

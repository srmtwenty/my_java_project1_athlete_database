package com.scott.b_springData2_self_project2022a.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.scott.b_springData2_self_project2022a.models.User;

@Component
public class UserValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	public void validate(Object target, Errors errors) {
		User user=(User) target;
		if(!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
		}
	}
	
}

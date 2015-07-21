package com.mercury.rtsapp.viewmodel;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.Email;

public class UserViewModel {
	private static final Logger logger = Logger.getLogger(UserViewModel.class);

	@Email
	private String email;
	@NotNull
	@Size(min = 1, max = 50)
	private String firstName;
	@NotNull
	@Size(min = 1, max = 50)
	private String lastName;
	@NotNull
	@Pattern(regexp = "((?=.*[a-z])(?=.*[A-Z]).{6,20})")
	private String password;
	@NotNull
	@Pattern(regexp = "((?=.*[a-z])(?=.*[A-Z]).{6,20})")
	private String repassword;

	@AssertTrue(message = "password and confirm password mismatch")
	private boolean isValid() {
		logger.info("confirm password result: "
				+ this.password.equals(this.repassword));
		return this.password.equals(this.repassword);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

}

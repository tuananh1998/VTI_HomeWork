//

package com.vti.template.entity;

/**
 * This class is class User
 * 
 * @Description: .
 * @author: CTAnh
 * @create_date: Dec 17, 2019
 * @version: 1.0
 * @modifer: CTAnh
 * @modifer_date: Dec 17, 2019
 */

public class User {
	private String firstname;
	private String lastname;
	private String email;

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public User(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public User(String firstname) {
		this.firstname = firstname;

	}
}

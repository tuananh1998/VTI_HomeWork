
package com.vti.template.dto;

import com.vti.template.entity.User;

/**
 * This class is .
 * 
 * @Description: .
 * @author: CTAnh
 * @create_date: Dec 18, 2019
 * @version: 1.0
 * @modifer: CTAnh
 * @modifer_date: Dec 18, 2019
 */

public class Userdto {
	private String fname, lname;
	private String email;

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getEmail() {
		return email;
	}

	/**
	 * Constructor for class Userdto.
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Dec 18, 2019
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Dec 18, 2019
	 * @param fname
	 * @param lname
	 * @param email
	 */
	public Userdto(String fname, String lname, String email) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}

	public Userdto(String fname) {
		this.fname = fname;

	}

	/**
	 * Constructor for class Userdto.
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Dec 18, 2019
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Dec 18, 2019
	 * @param user
	 */
	public Userdto(User user) {
		this.fname = user.getFirstname();
		this.lname = user.getLastname();
		this.email = user.getEmail();
	}

	public User toEntity() {
		return new User(getFname(), getLname(), getEmail());
	}
	/*
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "First name: " + getFname() + " " + "Last name: " + getLname() + "Email: " + getEmail() + "\n";
	}

}

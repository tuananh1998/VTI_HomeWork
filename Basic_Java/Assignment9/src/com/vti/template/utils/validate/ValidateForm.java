package com.vti.template.utils.validate;

import com.vti.template.entity.User;

/**
 * This class is validate form.
 * 
 * @Description: .
 * @author: CTA
 * @create_date: Dec 24, 2019
 * @version: 1.0
 * @modifer: CTA
 * @modifer_date: Dec 24, 2019
 */
public class ValidateForm {

	/**
	 * This method is validate addUser form.
	 * 
	 * @Description: .
	 * @author: CTA
	 * @create_date: Dec 24, 2019
	 * @version: 1.0
	 * @modifer: CTA
	 * @modifer_date: Dec 24, 2019
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean isValidateUserForm(User input) {

		if (null == input) {
			return false;
		}

		if (!Validate.isEmail(input.getEmail())) {
			return false;
		}

		if (!Validate.isfName(input.getFirstname())) {
			return false;
		}
		if (!Validate.islName(input.getLastname())) {
			return false;
		}
		return true;
	}

}

package com.vti.template.utils.validate;

import com.mysql.cj.util.StringUtils;
import com.vti.template.utils.Constant;
import com.vti.template.utils.MessageUtil;
import com.vti.template.utils.MethodUtil;

/**
 * This class is validate .
 * 
 * @Description: .
 * @author: CTA
 * @create_date: Dec 6, 2019
 * @version: 1.0
 * @modifer: CTA
 * @modifer_date: Dec 6, 2019
 */
public class Validate {

	/**
	 * This method is check validate email.
	 * 
	 * @Description: .
	 * @author: CTA
	 * @create_date: Dec 6, 2019
	 * @version: 1.0
	 * @modifer: CTA
	 * @modifer_date: Dec 6, 2019
	 * @param input - input from user
	 * @return boolean
	 */
	public static boolean isEmail(final String input) {
		// empty
		if (StringUtils.isNullOrEmpty(input)) {
			showError(MessageUtil.VALIDATE_EMAIL_EMPTY);
			return false;
		}

		// max length, min length
		if (!isSatisfyMaxLength(input, 30) || !isSatisfyMinLength(input, 6)) {
			showError(MessageUtil.VALIDATE_EMAIL_MAX_AND_MIN_LENGTH);
			return false;
		}

		// regular expression
		boolean result = MethodUtil.checkRegularExpression(input, Constant.PATTERN_EMAIL);
		if (!result) {
			showError(MessageUtil.VALIDATE_EMAIL_RULE);
		}
		return result;
	}

	/**
	 * This method is validate First Name. 
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Jan 7, 2020
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Jan 7, 2020
	 * @param input
	 * @return
	 */
	public static boolean isfName(final String input) {
		// empty
		if (StringUtils.isNullOrEmpty(input)) {
			showError(MessageUtil.VALIDATE_FIRSTNAME_EMPTY);
			return false;
		}
		return true;

	}
	/**
	 * This method is validate Last Name. 
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Jan 7, 2020
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Jan 7, 2020
	 * @param input
	 * @return
	 */
	public static boolean islName(final String input) {
		// empty
		if (StringUtils.isNullOrEmpty(input)) {
			showError(MessageUtil.VALIDATE_LASTNAME_EMPTY);
			return false;
		}
		return true;

	}

	/**
	 * This method validate max length of String .
	 * 
	 * @Description: .
	 * @author: CTA
	 * @create_date: Dec 24, 2019
	 * @version: 1.0
	 * @modifer: CTA
	 * @modifer_date: Dec 24, 2019
	 * @param input     - input String
	 * @param maxLength - Max length of String
	 * @return boolean
	 */
	public static boolean isSatisfyMaxLength(String input, int maxLength) {
		if (!StringUtils.isNullOrEmpty(input) && input.length() <= maxLength) {
			return true;
		}
		return false;
	}

	/**
	 * This method validate min length of String .
	 * 
	 * @Description: .
	 * @author: CTA
	 * @create_date: Dec 24, 2019
	 * @version: 1.0
	 * @modifer: CTA
	 * @modifer_date: Dec 24, 2019
	 * @param input     - input String
	 * @param minLength - Min length of String
	 * @return boolean
	 */
	public static boolean isSatisfyMinLength(String input, int minLength) {
		if (!StringUtils.isNullOrEmpty(input) && input.length() >= minLength) {
			return true;
		}
		return false;
	}

	/**
	 * This method show error message when validating.
	 * 
	 * @Description: .
	 * @author: CTA
	 * @create_date: Dec 24, 2019
	 * @version: 1.0
	 * @modifer: CTA
	 * @modifer_date: Dec 24, 2019
	 * @param message - Error message
	 */
	public static void showError(String message) {
		System.out.println("Error: " + message);
	}

	/**
	 * This method show success when validating.
	 * 
	 * @Description: .
	 * @author: CTA
	 * @create_date: Dec 24, 2019
	 * @version: 1.0
	 * @modifer: CTA
	 * @modifer_date: Dec 24, 2019
	 * @param message - success message
	 */
	public static void showSuccess(String message) {
		System.out.println("Success: " + message);
	}

}

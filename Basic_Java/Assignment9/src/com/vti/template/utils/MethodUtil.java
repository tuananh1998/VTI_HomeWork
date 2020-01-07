//
package com.vti.template.utils;

import java.util.regex.Pattern;

/**
 * This class is method.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Dec 6, 2019
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Dec 6, 2019
 */
public class MethodUtil {

	/**
	 * check object is null.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 6, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 6, 2019
	 * @param object
	 * @return boolean
	 */
	public static boolean isNull(Object object) {
		return object == null || "".equals(object);
	}

	/**
	 * This method is check regular.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 6, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 6, 2019
	 * @param input
	 *            - input string.
	 * @param regular
	 *            - Regular Expression.
	 * @return boolean
	 */
	public static boolean checkRegularExpression(String input, String regular) {
		// validate input
		if (isNull(input)) {
			return false;
		}
		// validate success
		return Pattern.compile(regular).matcher(input).matches();
	}
}

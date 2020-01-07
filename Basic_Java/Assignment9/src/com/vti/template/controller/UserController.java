//

package com.vti.template.controller;

import java.util.List;

import com.vti.template.dto.Userdto;
import com.vti.template.service.Userservice;
import com.vti.template.service.UserserviceImpl;
import com.vti.template.utils.validate.ValidateForm;

/**
 * This class is class UserController
 * 
 * @Description: .
 * @author: CTAnh
 * @create_date: Dec 18, 2019
 * @version: 1.0
 * @modifer: CTAnh
 * @modifer_date: Dec 18, 2019
 */

public class UserController {
	private Userservice service;
	private ValidateForm validate;
	/**
	 * Constructor for class UserController.
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Dec 18, 2019
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Dec 18, 2019
	 */
	public UserController() {
		service = new UserserviceImpl();
		validate=new ValidateForm();
	}

	/**
	 * This method is get all user 
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Dec 18, 2019
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Dec 18, 2019
	 * @return List<Userdto>
	 */
	public List<Userdto> getAll() {
		return service.getAll();
	}

	/**
	 * This method is add user
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Dec 18, 2019
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Dec 18, 2019
	 * @param userdto
	 * @return true if add success and else return false
	 */
	public boolean addUser(Userdto userdto) {
		if (!validate.isValidateUserForm(userdto.toEntity())) {
			return false;
		}
		return service.add(userdto);
	}

	/**
	 * This method is update user
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Dec 18, 2019
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Dec 18, 2019
	 * @param userdto
	 * @return true if update success and else return false
	 */
	public boolean updateUser(Userdto userdto) {
		if (!validate.isValidateUserForm(userdto.toEntity())) {
			return false;
		}
		return service.update(userdto);
	}

	/**
	 * This method is delete user
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Dec 18, 2019
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Dec 18, 2019
	 * @param userdto
	 * @return true if delete success and else return false
	 */
	public boolean delUser(Userdto userdto) {
		if (!validate.isValidateUserForm(userdto.toEntity())) {
			return false;
		}
		return service.del(userdto);
	}
}

//

package com.vti.template.repository;

import com.vti.template.entity.User;

/**
 * This class is interface UserRepository
 * 
 * @Description: .
 * @author: CTAnh
 * @create_date: Dec 17, 2019
 * @version: 1.0
 * @modifer: CTAnh
 * @modifer_date: Dec 17, 2019
 */

public interface UserRepository extends Repository<User> {
	public boolean exist(String fName);

}


package com.vti.template.service;

import java.util.List;

import com.vti.template.dto.Userdto;

/**
 * This class is interface Userservice
 * 
 * @Description: .
 * @author: CTAnh
 * @create_date: Dec 18, 2019
 * @version: 1.0
 * @modifer: CTAnh
 * @modifer_date: Dec 18, 2019
 */

public interface Userservice {
	public boolean exist(String fname);

	public List<Userdto> getAll();

	public Userdto getByfname(String fname);

	public boolean add(Userdto userdto);

	public boolean update(Userdto userdto);

	public boolean del(Userdto userdto);
}

//

package com.vti.template.service;

import java.util.ArrayList;
import java.util.List;

import com.vti.template.dto.Userdto;
import com.vti.template.entity.User;
import com.vti.template.repository.UserRepository;
import com.vti.template.repository.UserRepositoryImpl;

/**
 * This class is class UserserviceImpl
 * 
 * @Description: .
 * @author: CTAnh
 * @create_date: Dec 18, 2019
 * @version: 1.0
 * @modifer: CTAnh
 * @modifer_date: Dec 18, 2019
 */

public class UserserviceImpl implements Userservice {
	private UserRepository repository;

	public UserserviceImpl() {
		repository = new UserRepositoryImpl();
	}
	/*
	 * @see com.vti.template.service.Userservice#exist(java.lang.String)
	 */

	@Override
	public boolean exist(String fname) {
		return repository.exist(fname);
	}

	/*
	 * @see com.vti.template.service.Userservice#getAll()
	 */

	@Override
	public List<Userdto> getAll() {
		List<User> users = new ArrayList<User>();
		List<Userdto> userdtos = new ArrayList<Userdto>();

		// get data
		users.addAll(repository.getAll());

		// convert from entity to dto
		for (User user : users) {
			userdtos.add(new Userdto(user));
		}
		return userdtos;
	}

	/*
	 * @see com.vti.template.service.Userservice#getByfname(java.lang.String)
	 */

	@Override
	public Userdto getByfname(String fname) {

		return new Userdto(repository.getbyfName(fname));

	}

	/*
	 * @see com.vti.template.service.Userservice#add(com.vti.template.dto.Userdto)
	 */

	@Override
	public boolean add(Userdto userdto) {
		// check user exist
		if (repository.exist(userdto.getEmail())) {
			return false;
			
		}
		// check add success
		if (repository.add(userdto.toEntity())) {
			return true;
		}
		return false;
	}

	/*
	 * @see
	 * com.vti.template.service.Userservice#update(com.vti.template.dto.Userdto)
	 */

	@Override
	public boolean update(Userdto userdto) {
		// check user exist
		if (!repository.exist(userdto.getEmail())) {
			return false;
		}
		// check add success
		if (repository.update(userdto.toEntity())) {
			return true;
		}
		return false;
	}

	/*
	 * @see com.vti.template.service.Userservice#del(com.vti.template.dto.Userdto)
	 */

	@Override
	public boolean del(Userdto userdto) {
		// check user exist
		if (!repository.exist(userdto.getFname())) {
			return false;
		}
		// check add success
		if (repository.del(userdto.toEntity())) {
			return true;
		}
		return false;
	}

}

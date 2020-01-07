
package com.vti.template.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.template.entity.User;
import com.vti.template.utils.jdbc.SqlParameter;
import com.vti.template.utils.jdbc.SqlStatement;

/**
 * This class is UserRepositoryImpl
 * 
 * @Description: .
 * @author: CTAnh
 * @create_date: Dec 17, 2019
 * @version: 1.0
 * @modifer: CTAnh
 * @modifer_date: Dec 17, 2019
 */

public class UserRepositoryImpl extends RepositoryImpl<User> implements UserRepository {

	
	/*
	 * @see com.vti.template.repository.Repository#getAll()
	 */

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<User>();

		// excute query
		ResultSet resultSet = getJdbc().selectStatement(SqlStatement.SELECT_ALL_USER);

		// check resultset not null
		if (resultSet == null) {
			getJdbc().disconnect();
			return null;
		}

		// get data
		try {
			while (resultSet.next()) {
				users.add(new User(
						resultSet.getString("firstname"), 
						resultSet.getString("lastname"),
						resultSet.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			getJdbc().disconnect();
		}
		return users;
	}

	/*
	 * @see com.vti.template.repository.Repository#getbyId(java.lang.String)
	 */

	@Override
	public User getbyfName(String fName) {
		List<SqlParameter> parameters = new ArrayList<SqlParameter>();
		parameters.add(new SqlParameter(1, fName));

		// excute query
		ResultSet resultSet = getJdbc().selectPreparationStatement(SqlStatement.SQL_GET_BY_FNAME_USER, parameters);

		// check result not null
		if (resultSet == null) {
			getJdbc().disconnect();
			return null;
		}
		try {
			while (resultSet.next()) {
				User user = new User(
						resultSet.getString("firstname"), 
						resultSet.getString("lastname"),
						resultSet.getString("email"));
				getJdbc().disconnect();
				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			getJdbc().disconnect();
		}
		return null;
	}

	/*
	 * @see com.vti.template.repository.Repository#add(java.lang.Object)
	 */

	@Override
	public boolean add(User entity) {
		List<SqlParameter> parameters=new ArrayList<SqlParameter>();
		parameters.add(new SqlParameter(1, entity.getFirstname()));
		parameters.add(new SqlParameter(2, entity.getLastname()));
		parameters.add(new SqlParameter(3, entity.getEmail()));
		
		//excute query
		int result=getJdbc().updatePreparationStatement(SqlStatement.SQL_INSERT_USER, parameters);
		if (result!=0) {
			getJdbc().disconnect();
			return true;
		}
		//close connect
		getJdbc().disconnect();
		return false;
	}

	/*
	 * @see com.vti.template.repository.Repository#update(java.lang.Object)
	 */

	@Override
	public boolean update(User entity) {

		List<SqlParameter> parameters=new ArrayList<SqlParameter>();
		parameters.add(new SqlParameter(2, entity.getFirstname()));
		parameters.add(new SqlParameter(1, entity.getLastname()));
		parameters.add(new SqlParameter(3, entity.getEmail()));
		
		//excute query
		int result=getJdbc().updatePreparationStatement(SqlStatement.SQL_UPDATE_USER, parameters);
		if (result!=0) {
			getJdbc().disconnect();
			return true;
		}
		//close connect
		getJdbc().disconnect();
		return false;

	}

	/*
	 * @see com.vti.template.repository.Repository#del(java.lang.Object)
	 */

	@Override
	public boolean del(User entity) {
		//Set parameter
		List<SqlParameter> parameters=new ArrayList<SqlParameter>();
		parameters.add(new SqlParameter(1, entity.getFirstname()));
		
		//excute query
		int result=getJdbc().updatePreparationStatement(SqlStatement.SQL_DELETE_USER, parameters);
		if (result!=0) {
			getJdbc().disconnect();
			return true;
		}
		//close connect
		getJdbc().disconnect();
		return false;

	}

	/*
	 * @see com.vti.template.repository.Repository#exist(java.lang.String)
	 */

	@Override
	public boolean exist(String email) {
				//Set parameter
				List<SqlParameter> parameters=new ArrayList<SqlParameter>();
				parameters.add(new SqlParameter(1, email));
				
				//excute query
				ResultSet result=getJdbc().selectPreparationStatement(SqlStatement.SQL_EXITS_USER_BY_EMAIL, parameters);
				try {
					while (result.next()) {
					getJdbc().disconnect();
					return true;
					}
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
				//close connect
				getJdbc().disconnect();
				return false;


		
	}

}

//

package com.vti.template.repository;

import com.vti.template.utils.jdbc.JdbcUtil;

/**
 * This class is class RepositoryImpl
 * 
 * @Description: .
 * @author: CTAnh
 * @create_date: Dec 17, 2019
 * @version: 1.0
 * @param <T>
 * @modifer: CTAnh
 * @modifer_date: Dec 17, 2019
 */

public abstract class RepositoryImpl<T> implements Repository<T> {
	private JdbcUtil jdbc;

	public JdbcUtil getJdbc() {
		return jdbc;
	}

	/**
	 * Constructor for class RepositoryImpl.
	 * 
	 * @Description: .
	 * @author: CTAnh
	 * @create_date: Dec 17, 2019
	 * @version: 1.0
	 * @modifer: CTAnh
	 * @modifer_date: Dec 17, 2019
	 */
	public RepositoryImpl() {
		this.jdbc = JdbcUtil.getInstance();
	}

}

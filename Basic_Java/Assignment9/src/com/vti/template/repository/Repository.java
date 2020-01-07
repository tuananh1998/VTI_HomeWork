//

package com.vti.template.repository;

import java.util.List;

/**
 * This class is interface Repository
 * 
 * @Description: .
 * @author: CTAnh
 * @create_date: Dec 17, 2019
 * @version: 1.0
 * @modifer: CTAnh
 * @modifer_date: Dec 17, 2019
 */

public interface Repository<T> {
	public boolean exist(String fName);

	public List<T> getAll();

	public T getbyfName(String fName);

	public boolean add(T entity);

	public boolean update(T entity);

	public boolean del(T entity);
}

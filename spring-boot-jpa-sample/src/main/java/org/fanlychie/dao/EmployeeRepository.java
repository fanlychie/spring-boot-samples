package org.fanlychie.dao;

import org.fanlychie.entity.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by fanlychie on 2017/6/30.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findByName(String name);

}
package org.fanlychie.dao;

import org.fanlychie.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fanlychie on 2017/6/30.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
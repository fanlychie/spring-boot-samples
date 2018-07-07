package org.fanlychie.mapper;

import org.fanlychie.entity.Employee;

import java.util.List;

/**
 * Created by fanlychie on 2018/7/7.
 */
public interface EmployeeMapper {

    Long save(Employee employee);

    List<Employee> selectAll();

}
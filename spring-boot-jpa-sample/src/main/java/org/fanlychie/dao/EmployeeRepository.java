package org.fanlychie.dao;

import org.fanlychie.entity.Employee;
import org.fanlychie.enums.Sex;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by fanlychie on 2017/6/30.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // 根据姓名查询
    Employee findByName(String name);

    // 根据姓名查询, 返回第一条记录
    Employee findFirstByName(String name);

    // 根据姓名和性别查询
    Employee findByNameAndSex(String name, Sex sex);

    // 根据性别查询, 返回前3条记录
    List<Employee> findTop3BySex(Sex sex);

    // 根据性别分页查询
    Page<Employee> findBySex(Sex sex, Pageable pageable);

    List<Employee> selectBySex(Sex sex);

    Employee selectByName(String name);

    List<Employee> searchBySex(String sex);

    Employee searchByName(String name);

}
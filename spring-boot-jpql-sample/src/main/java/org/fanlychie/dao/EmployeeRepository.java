package org.fanlychie.dao;

import org.fanlychie.entity.Employee;
import org.fanlychie.enums.Sex;
import org.fanlychie.model.SimpleEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by fanlychie on 2017/7/2.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT E FROM Employee E")
    List<Employee> selectAll();

    @Query("SELECT E FROM Employee E WHERE E.sex = :sex AND E.salary > :salary")
    List<Employee> selectByNamedParams(@Param("sex") Sex sex, @Param("salary") Double salary);

    @Query("SELECT E FROM Employee E WHERE E.sex = ?1 AND E.salary > ?2")
    List<Employee> selectByPositionalParams(Sex sex, Double salary);

    @Query("SELECT E FROM Employee E JOIN E.department D WHERE D.name = ?1")
    List<Employee> selectByDeptName(String deptName);

    @Query("SELECT E FROM Employee E WHERE E.name = '张三'")
    Employee selectByLiteralString();

    @Query("SELECT E FROM Employee E WHERE E.name = 'Li''Si'")
    Employee selectByLiteralStringWithQuote();

    @Query("SELECT E FROM Employee E WHERE E.salary > 10000.0")
    List<Employee> selectByLiteralNumber();

    @Query("SELECT E FROM Employee E WHERE E.married = TRUE")
    List<Employee> selectByLiteralBool();

    @Query("SELECT E FROM Employee E WHERE E.sex = org.fanlychie.enums.Sex.FEMALE")
    List<Employee> selectByLiteralEnum();

    @Query("SELECT E FROM Employee E WHERE E.name LIKE '张%'")
    List<Employee> selectByLikeLiteralString();

    @Query("SELECT NEW org.fanlychie.model.SimpleEmployee(E.name, E.sex) FROM Employee E")
    List<SimpleEmployee> selectSimpleEmployees();

    @Modifying
    @Transactional
    @Query("UPDATE Employee SET married = ?2, salary = ?3 WHERE id = ?1")
    int update(Long id, Boolean married, Double salary);

}
package org.fanlychie.dao;

import org.fanlychie.entity.Employee;
import org.fanlychie.enums.Sex;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

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

    // 根据给定的年龄查找小于且未婚的记录并按年龄升序排序
    List<Employee> findByAgeLessThanAndMarriedIsFalseOrderByAge(int age);

    List<Employee> selectBySex(Sex sex);

    Employee selectByName(String name);

    List<Employee> searchBySex(String sex);

    Employee searchByName(String name);

    @Query("SELECT E FROM Employee E WHERE E.name = ?1")
    Employee queryOneByName(String name);

    @Query(value = "SELECT * FROM EMPLOYEE WHERE NAME = ?1", nativeQuery = true)
    Employee queryOneByNameNative(String name);

    @Query("SELECT E FROM Employee E WHERE E.name LIKE %?1")
    List<Employee> queryNameLike(String suffixName);

    @Query("SELECT E FROM Employee E WHERE E.sex = ?1")
    Page<Employee> queryBySexPagination(Sex sex, Pageable pageable);

    /*
    @Query(value = "SELECT * FROM EMPLOYEE WHERE SEX = ?1",
            countQuery = "SELECT COUNT(*) FROM EMPLOYEE WHERE SEX = ?1 ",
            nativeQuery = true)
    Page<Employee> queryBySexPaginationNative(Sex sex, Pageable pageable);
    */

    @Query("SELECT E FROM Employee E WHERE E.sex = ?1")
    List<Employee> queryBySexAndSort(Sex sex, Sort sort);

    @Query("SELECT E FROM #{#entityName} E WHERE E.name = ?1")
    Employee queryByNameSpEL(String name);

    @Modifying
    @Query("UPDATE Employee E SET E.salary = ?2 WHERE E.name = ?1")
    int updateSalaryForName(String name, Double salary);

    @Modifying
    @Query("DELETE FROM Employee E WHERE E.name = ?1")
    int deleteByName(String name);

}
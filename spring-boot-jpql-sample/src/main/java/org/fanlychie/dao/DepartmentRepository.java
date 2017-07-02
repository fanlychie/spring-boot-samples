package org.fanlychie.dao;

import org.fanlychie.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by fanlychie on 2017/7/2.
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT D FROM Department D JOIN D.employees E WHERE E.salary > 10000")
    List<Department> selectByMultRelatedField();

    @Query("SELECT D FROM Department D, IN(D.employees) E WHERE E.salary > 10000")
    List<Department> selectByMultRelatedCollection();

    @Query("SELECT DISTINCT D FROM Department D JOIN D.employees E WHERE E.salary > 10000")
    List<Department> selectByMultRelatedFieldDistinct();

    @Query("SELECT D FROM Department D WHERE D.employees IS EMPTY")
    List<Department> selectByEmpty();

    @Modifying
    @Transactional
    @Query("DELETE FROM Department D WHERE D.employees IS EMPTY")
    int delete();

}
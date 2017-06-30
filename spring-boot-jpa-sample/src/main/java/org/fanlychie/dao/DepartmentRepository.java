package org.fanlychie.dao;

import org.fanlychie.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fanlychie on 2017/6/30.
 */
public interface DepartmentRepository extends JpaRepository<Department, String> {

}
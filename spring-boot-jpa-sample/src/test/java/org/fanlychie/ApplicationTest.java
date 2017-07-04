package org.fanlychie;

import org.fanlychie.dao.EmployeeRepository;
import org.fanlychie.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by fanlychie on 2017/6/30.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ApplicationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setName("张三丰");
        employee.setAge(24);
        employeeRepository.save(employee);
    }

    @Test
    public void testUpdate() {
        Employee employee = employeeRepository.findByName("张三丰");
        employee.setAge(25);
        employeeRepository.save(employee);
    }

    @Test
    public void testUpdateById() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setAge(26);
        employeeRepository.save(employee);
    }

    @Test
    public void testDeleteNonExistentEntity() {
        Employee employee = new Employee();
        employee.setId(1001L);
        employeeRepository.delete(employee);
    }

}
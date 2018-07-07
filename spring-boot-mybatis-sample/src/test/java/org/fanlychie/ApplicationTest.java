package org.fanlychie;

import org.fanlychie.entity.Employee;
import org.fanlychie.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by fanlychie on 2018/7/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setName("fanlychie");
        employee.setAge(23);
        employeeMapper.save(employee);
    }

    @Test
    public void testSelectAll() {
        List<Employee> employees = employeeMapper.selectAll();
        employees.forEach(System.out::println);
    }

}
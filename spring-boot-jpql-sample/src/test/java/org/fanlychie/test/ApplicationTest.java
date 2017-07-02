package org.fanlychie.test;

import org.fanlychie.dao.DepartmentRepository;
import org.fanlychie.dao.EmployeeRepository;
import org.fanlychie.entity.Department;
import org.fanlychie.entity.Employee;
import org.fanlychie.enums.Sex;
import org.fanlychie.model.SimpleEmployee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by fanlychie on 2017/7/1.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ApplicationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void init() {
        departmentRepository.save(Arrays.asList(
                department("开发部", Arrays.asList(
                        employee("张三", Sex.MALE, 28, true, 11000.D),
                        employee("Li'Si", Sex.FEMALE, 26, true, 18000.D),
                        employee("王五", Sex.MALE, 32, true, 15000.D)
                )),
                department("人事部", Arrays.asList(
                        employee("赵六", Sex.FEMALE, 25, false, 8500.D),
                        employee("钱七", Sex.FEMALE, 31, true, 12000.D)
                )),
                department("销售部", new ArrayList<>())
        ));
    }

    @Test
    public void testBasicSelect() {
        List<Employee> employees = employeeRepository.selectAll();
        print(employees);
    }

    @Test
    public void testSelectByNamedParams() {
        List<Employee> employees = employeeRepository.selectByNamedParams(Sex.FEMALE, 10000.D);
        print(employees);
    }

    @Test
    public void testSelectByPositionalParams() {
        List<Employee> employees = employeeRepository.selectByPositionalParams(Sex.FEMALE, 10000.D);
        print(employees);
    }

    @Test
    public void testSelectByDeptName() {
        List<Employee> employees = employeeRepository.selectByDeptName("开发部");
        print(employees);
    }

    @Test
    public void testSelectByMultRelatedField() {
        List<Department> departments = departmentRepository.selectByMultRelatedField();
        print(departments);
    }

    @Test
    public void testSelectByMultRelatedCollection() {
        List<Department> departments = departmentRepository.selectByMultRelatedCollection();
        print(departments);
    }

    @Test
    public void testSelectByMultRelatedFieldDistinct() {
        List<Department> departments = departmentRepository.selectByMultRelatedFieldDistinct();
        print(departments);
    }

    @Test
    public void testSelectByLiteralString() {
        Employee employee = employeeRepository.selectByLiteralString();
        print(employee);
    }

    @Test
    public void testSelectByLiteralStringWithQuote() {
        Employee employee = employeeRepository.selectByLiteralStringWithQuote();
        print(employee);
    }

    @Test
    public void testSelectByLiteralNumber() {
        List<Employee> employees = employeeRepository.selectByLiteralNumber();
        print(employees);
    }

    @Test
    public void testSelectByLiteralBool() {
        List<Employee> employees = employeeRepository.selectByLiteralBool();
        print(employees);
    }

    @Test
    public void testSelectByLiteralEnum() {
        List<Employee> employees = employeeRepository.selectByLiteralEnum();
        print(employees);
    }

    @Test
    public void testSelectByLikeLiteralString() {
        List<Employee> employees = employeeRepository.selectByLikeLiteralString();
        print(employees);
    }

    @Test
    public void testSelectSimpleEmployees() {
        List<SimpleEmployee> simpleEmployees = employeeRepository.selectSimpleEmployees();
        print(simpleEmployees);
    }

    @Test
    public void testSelectByEmpty() {
        List<Department> departments = departmentRepository.selectByEmpty();
        print(departments);
    }

    @Test
    public void testUpdate() {
        int result = employeeRepository.update(1L, true, 13000.D);
        print(result);
    }

    @Test
    public void testDelete() {
        int result = departmentRepository.delete();
        print(result);
    }

    private Department department(String name, List<Employee> employees) {
        Department d = new Department();
        d.setName(name);
        d.setEmployees(new HashSet<>(employees));
        return d;
    }

    private Employee employee(String name, Sex sex, Integer age, boolean married, Double salary) {
        Employee e = new Employee();
        e.setAge(age);
        e.setHireDate(new Date());
        e.setMarried(married);
        e.setName(name);
        e.setSalary(salary);
        e.setSex(sex);
        return e;
    }

    private void print(Object message) {
        System.out.println("=============================================");
        System.out.println(message);
        System.out.println("=============================================");
    }

}
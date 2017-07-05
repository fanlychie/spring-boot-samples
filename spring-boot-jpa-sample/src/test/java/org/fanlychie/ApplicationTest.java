package org.fanlychie;

import org.fanlychie.dao.EmployeeRepository;
import org.fanlychie.entity.Employee;
import org.fanlychie.enums.Sex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
    public void testInsert() {
        Employee employee = new Employee();
        employee.setId(100L);
        employee.setAge(26);
        employeeRepository.save(employee);
    }

    @Test
    public void testDeleteById() {
        employeeRepository.delete(7L);
    }

    @Test
    public void testDeleteByEntity() {
        Employee employee = new Employee();
        employee.setId(2L); // 此 ID 在数据库中存在
        employeeRepository.delete(employee); // 产生 SELECT 和 DELETE
    }

    @Test
    public void testDeleteByNonExistentEntity() {
        Employee employee = new Employee();
        employee.setId(20L); // 此 ID 在数据库中不存在
        employeeRepository.delete(employee); // 产生 SELECT 和 INSERT 及 DELETE
    }

    @Test
    public void testSelectAndOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Direction.DESC, "salary")); // 薪资降序
        orders.add(new Order("age")); // 薪资相同则按年龄升序
        orders.add(new Order("hireDate").with(Direction.ASC)); // 薪资和年龄都相同则按入职时间升序
        employeeRepository.findAll(new Sort(orders))
                .forEach(System.out::println);
    }

    @Test
    public void testSelectAndSort() {
        Sort sort = new Sort(Direction.DESC, "salary") // 薪资降序
                .and(new Sort("age")) // 薪资相同则按年龄升序
                .and(new Sort(Direction.DESC, "hireDate")); // 薪资和年龄都相同则按入职时间升序
        employeeRepository.findAll(sort)
                .forEach(System.out::println);
    }

    @Test
    public void testSelectByPagination() {
        // 分页索引从0开始, 表示第一页
        Page<Employee> page = employeeRepository.findAll(new PageRequest(0, 2));
        long totalElements = page.getTotalElements(); // 查询结果总的记录条数
        int totalPages = page.getTotalPages(); // 分页的总页数
        List<Employee> content = page.getContent(); // 当前页的数据内容
        int number = page.getNumber(); // 当前页的页码, 从0开始, 表示第一页
        int numberOfElements = page.getNumberOfElements(); // 每页的记录条数
        int size = page.getSize(); // 每页的记录条数
        Sort sort = page.getSort(); // 分页查询的排序对象
        boolean isFirst = page.isFirst(); // 是否是第一页
        boolean isLast = page.isLast(); // 是否是最后一页
        boolean hasContent = page.hasContent(); // 当前页是否有数据
        boolean hasNext = page.hasNext(); // 是否有下一页
        boolean hasPrevious = page.hasPrevious(); // 是否有上一页
        Pageable nextPageable = page.nextPageable(); // 下一页的分页对象
        Pageable previousPageable = page.previousPageable(); // 上一页的分页对象
        page.forEach(System.out::println);
    }

    @Test
    public void testSelectByPaginationAndSort() {
        Sort sort = new Sort(Direction.DESC, "salary") // 薪资降序
                .and(new Sort("age")); // 薪资相同则按年龄升序
        Page<Employee> page = employeeRepository.findAll(new PageRequest(0, 2, sort));
        page.forEach(System.out::println);
    }

    @Test
    public void testFindFirstByName() {
        Employee employee = employeeRepository.findFirstByName("张三丰");
        System.out.println(employee);
    }

    @Test
    public void testFindByNameAndSex() {
        Employee employee = employeeRepository.findByNameAndSex("张三丰", Sex.MALE);
        System.out.println(employee);
    }

    @Test
    public void testFindTop3BySex() {
        employeeRepository.findTop3BySex(Sex.FEMALE)
                .forEach(System.out::println);
    }

    @Test
    public void testFindBySexPagination() {
        Page<Employee> page = employeeRepository.findBySex(Sex.FEMALE, new PageRequest(0, 2));
        page.forEach(System.out::println);
    }

    @Test
    public void testSelectBySex() {
        employeeRepository.selectBySex(Sex.FEMALE)
                .forEach(System.out::println);
    }

    @Test
    public void testSelectByName() {
        Employee employee = employeeRepository.selectByName("张三丰");
        System.out.println(employee);
    }

    @Test
    public void testSearchBySex() {
        employeeRepository.searchBySex(Sex.FEMALE.name())
                .forEach(System.out::println);
    }

    @Test
    public void testSearchByName() {
        Object employee = employeeRepository.searchByName("张三丰");
        System.out.println(employee);
    }

}
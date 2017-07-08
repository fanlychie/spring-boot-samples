package org.fanlychie;

import org.fanlychie.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fanlychie on 2017/6/30.
 */
@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ApplicationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() {
        Employee employee = new Employee();
        employee.setName("张三丰");
        employee.setAge(24);
        int result = insert(employee);
        System.out.println(result);
    }

    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setName("李四光");
        employee.setAge(25);
        employee = save(employee);
        System.out.println(employee);
    }

    @Test
    public void testFindById() {
        Employee employee = findById(1L);
        System.out.println(employee);
    }

    @Test
    public void testFindNameById() {
        String name = findNameById(1L);
        System.out.println(name);
    }

    @Test
    public void testFindAll() {
        List<Employee> employees = findAll();
        employees.forEach(System.out::println);
    }

    @Test
    public void testUpdate() {
        Employee employee = findById(1L);
        employee.setAge(28);
        int result = update(employee);
        System.out.println(result);
    }

    @Test
    public void testBatchUpdate() {
        List<Employee> employees = findAll();
        employees.forEach(e -> e.setAge(29));
        int[] results = batchUpdate(employees);
        System.out.println(Arrays.toString(results));
    }

    @Test
    public void testDelete() {
        int result = delete(1L);
        System.out.println(result);
    }

    public int insert(Employee employee) {
        return jdbcTemplate.update("INSERT INTO EMPLOYEE(NAME, AGE) VALUE (?, ?)",
                employee.getName(), employee.getAge());
    }

    public Employee save(Employee employee) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO EMPLOYEE(NAME, AGE) VALUE (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getAge());
            return ps;
        }, keyHolder);
        employee.setId(keyHolder.getKey().longValue());
        return employee;
    }

    public int update(Employee employee) {
        return jdbcTemplate.update("UPDATE EMPLOYEE SET NAME = ?, AGE = ? WHERE ID = ?",
                employee.getName(), employee.getAge(), employee.getId());
    }

    public int[] batchUpdate(List<Employee> employees) {
        return jdbcTemplate.batchUpdate("UPDATE EMPLOYEE SET NAME = ?, AGE = ? WHERE ID = ?",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Employee employee = employees.get(i);
                        ps.setString(1, employee.getName());
                        ps.setInt(2, employee.getAge());
                        ps.setLong(3, employee.getId());
                    }
                    @Override
                    public int getBatchSize() {
                        return employees.size();
                    }
                });
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM EMPLOYEE WHERE ID = ?", id);
    }

    public String findNameById(Long id) {
        return jdbcTemplate.queryForObject("SELECT NAME FROM EMPLOYEE WHERE ID = ?",
                new Object[]{id}, String.class);
    }

    public Employee findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM EMPLOYEE WHERE ID = ?",
                new Object[]{id}, (rs, rowNum) -> {
                    Employee employee = new Employee();
                    employee.setId(rs.getLong("id"));
                    employee.setAge(rs.getInt("age"));
                    employee.setName(rs.getString("name"));
                    return employee;
                });
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM EMPLOYEE",
                (rs, rowNum) -> {
                    Employee employee = new Employee();
                    employee.setId(rs.getLong("id"));
                    employee.setAge(rs.getInt("age"));
                    employee.setName(rs.getString("name"));
                    return employee;
                });
    }

}
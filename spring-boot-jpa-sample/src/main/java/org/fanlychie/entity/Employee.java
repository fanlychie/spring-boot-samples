package org.fanlychie.entity;

import org.fanlychie.enums.Sex;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.Date;

/**
 * Created by fanlychie on 2017/6/30.
 */
@Entity(name = "Employee")
@NamedQueries({
        @NamedQuery(
                name = "Employee.selectBySex",
                query = "SELECT E FROM Employee E WHERE E.sex = ?1"
        ),
        @NamedQuery(
                name = "Employee.selectByName",
                query = "SELECT E FROM Employee E WHERE E.name = ?1"
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Employee.searchBySex",
                query = "SELECT * FROM EMPLOYEE WHERE SEX = ?1",
                resultClass = Employee.class
        ),
        @NamedNativeQuery(
                name = "Employee.searchByName",
                query = "SELECT * FROM EMPLOYEE WHERE NAME = ?1",
                resultClass = Employee.class
        )
})
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private Integer age;

    private Boolean married;

    private Double salary;

    private Date hireDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", married=" + married +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }

}
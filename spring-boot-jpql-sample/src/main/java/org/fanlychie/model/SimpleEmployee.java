package org.fanlychie.model;

import org.fanlychie.enums.Sex;

/**
 * Created by fanlychie on 2017/7/2.
 */
public class SimpleEmployee {

    private String name;

    private Sex sex;

    public SimpleEmployee(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
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

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

}
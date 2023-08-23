package com.thoughtworks.springbootemployee.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Employee {

    private long id;
    private long companyId;
    private final String name;
    private Integer age;

    private final String gender;

    private Integer salary;

    public Employee(long id, String name, Integer age, String gender, Integer salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;

    }

}
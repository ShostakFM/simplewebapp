package com.godeltech.mastery.task.dto;

import java.util.Date;

public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String job_title;
    private Long department_id;
    private Gender gender;
    private Date date_of_birth;

    public Employee() {
    }

    public Employee(Long employeeId, String firstName, String lastName, String job_title, Long department_id, Gender gender, Date date_of_birth) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.job_title = job_title;
        this.department_id = department_id;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = Gender.valueOf(gender);
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}

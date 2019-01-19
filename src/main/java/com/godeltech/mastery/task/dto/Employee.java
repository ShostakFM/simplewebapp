package com.godeltech.mastery.task.dto;

import java.util.Date;

public class Employee {
    private Long employee_id;
    private String first_name;
    private String last_name;
    private Long department_id;
    private String job_title;
    private Gender gender;
    private Date date_of_birth;

    public Employee() {
    }

    public Employee(Long employee_id, String first_name, String last_name, String job_title, Long department_id, Gender gender, Date date_of_birth) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.job_title = job_title;
        this.department_id = department_id;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

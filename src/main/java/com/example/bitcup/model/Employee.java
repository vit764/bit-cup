package com.example.bitcup.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee extends SimpleEntity {
    @Column(name = "FIRST_NAME", nullable = false, insertable = true, updatable = true)
    private String firstName;
    @Column(name = "MIDDLE_NAME", nullable = true, insertable = true, updatable = true)
    private String middleName;
    @Column(name = "LAST_NAME", nullable = false, insertable = true, updatable = true)
    private String lastName;

    @Column(name = "MAIL", nullable = false, insertable = true, updatable = true)
    private String mail;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    private JobPosition jobPosition;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

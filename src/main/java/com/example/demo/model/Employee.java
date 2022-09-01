package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employee", schema = "public")
@Entity
public class Employee {
    @Id
    String uuid;
    String name;
    int age;
    String gender;
    String status;
    @Column(name = "department_uuid")
    String departmentUuid;
}

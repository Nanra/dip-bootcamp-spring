package com.dip.bootcamp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    // Declaring Field Objects
    public Integer id;
    public String name;
    public String phone;
    public String address;
    public Timestamp createDate;
    public String createBy;
}

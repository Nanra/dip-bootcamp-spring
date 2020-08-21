package com.dip.bootcamp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    public String id;
    public String name;
    public String quantity;
    public String sku;
    public BigDecimal price;
    public String createBy;
    public Timestamp createDate;
    public String editBy;
    public Timestamp editDate;

}

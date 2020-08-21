package com.dip.bootcamp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    public String id;
    public String invoiceNumber;
    public BigDecimal amount;
    public String userId;
    public String status;
    public String createBy;
    public String payer;
    public Timestamp createDate;
    public String editBy;
    public Timestamp editDate;

}

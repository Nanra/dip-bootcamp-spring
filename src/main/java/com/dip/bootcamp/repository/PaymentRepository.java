package com.dip.bootcamp.repository;

import com.dip.bootcamp.models.Payment;
import com.dip.bootcamp.utilities.InformationConstant;
import com.dip.bootcamp.utilities.JdbcHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PaymentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    SimpleJdbcCall simpleJdbcCall;

    public List<Payment> listPayment(Payment dataParam) {

        // Calling Stored Procedure To Get All User List
        JdbcHelper helper = new JdbcHelper();
        simpleJdbcCall = helper.useTemplate(this.jdbcTemplate)
                .spName("SP_PAYMENT_LIST")
                .mapTo(Payment.class)
                .outParameter(InformationConstant.REF_CURSOR_RECORDSET)
                .build();

        // Set Query Param for Stored Procedure Requirement
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("P_ID", dataParam.getId())
                .addValue("P_INVOICENUMBER", dataParam.getInvoiceNumber())
                .addValue("P_PAYER", dataParam.getPayer());

        // Stored Procedure Execution
        Map<String, Object> resultSp = simpleJdbcCall.execute(parameterSource);

        System.out.println(resultSp);

        // Get Result Value to Object
        List<Payment> paymentList = (List<Payment>) resultSp.get("p_recordset");

        System.out.println(paymentList.get(0).getId());

        return paymentList;

    }

}

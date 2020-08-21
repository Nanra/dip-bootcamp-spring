package com.dip.bootcamp.repository;

import com.dip.bootcamp.controllers.product.ProductController;
import com.dip.bootcamp.models.Product;
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
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    SimpleJdbcCall simpleJdbcCall;

    public List<Product> listProduct(Product dataParam) {

        // Calling Stored Procedure To Get All User List
        JdbcHelper helper = new JdbcHelper();
        simpleJdbcCall = helper.useTemplate(this.jdbcTemplate)
                .spName("SP_PRODUCT_LIST")
                .mapTo(ProductController.class)
                .outParameter(InformationConstant.REF_CURSOR_RECORDSET)
                .build();

        // Set Query Param for Stored Procedure Requirement
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("P_ID", dataParam.getId())
                .addValue("P_NAME", dataParam.getName())
                .addValue("P_SKU", dataParam.getSku());

        // Stored Procedure Execution
        Map<String, Object> resultSp = simpleJdbcCall.execute(parameterSource);

        // Get Result Value to Object
        List<Product> productList = (List<Product>) resultSp.get("p_recordset");

        return productList;

    }

}

package com.dip.bootcamp.repository;

import com.dip.bootcamp.models.Employee;
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
public class EmployeeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    SimpleJdbcCall simpleJdbcCall;


    public List<Employee> listEmployee(Employee dataParam) {

        // Calling Stored Procedure To Get All User List
        JdbcHelper helper = new JdbcHelper();
        simpleJdbcCall = helper.useTemplate(this.jdbcTemplate)
                .spName("SP_EMPLOYEE_LIST")
                .mapTo(Employee.class)
                .outParameter(InformationConstant.REF_CURSOR_RECORDSET)
                .build();

        // Set Query Param for Stored Procedure Requirement
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("P_ID", dataParam.getId())
                .addValue("P_NAME", dataParam.getName());

        // Stored Procedure Execution
        Map<String, Object> resultSp = simpleJdbcCall.execute(parameterSource);

        // Get Result Value to Object
        List<Employee> userLists = (List<Employee>) resultSp.get(InformationConstant.REF_CURSOR_RECORDSET);

        System.out.println("Isi Employee");
        System.out.println(userLists.get(0).getName());


        return userLists;





    }


    public Integer insertEmployee(Employee dataForSave) {
        // Block Code For Transaction with Database
        return null;
    }

}

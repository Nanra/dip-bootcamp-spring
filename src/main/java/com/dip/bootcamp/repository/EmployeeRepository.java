package com.dip.bootcamp.repository;

import com.dip.bootcamp.models.Employee;
import com.dip.bootcamp.utilities.InformationConstant;
import com.dip.bootcamp.utilities.JdbcHelper;
import com.dip.bootcamp.viewmodels.ResponseSave;
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
        List<Employee> employeeList = (List<Employee>) resultSp.get("p_recordset");

        return employeeList;

    }

    public ResponseSave insertEmployee(Employee dataForSave) {

        // Calling Stored Procedure To Get All User List
        JdbcHelper helper = new JdbcHelper();
        simpleJdbcCall = helper.useTemplate(this.jdbcTemplate)
                .spName("SP_EMPLOYEE_INSERT")
                .mapTo(ResponseSave.class)
                .outParameter(InformationConstant.REF_CURSOR_RECORDSET)
                .build();

        // Set Query Param for Stored Procedure Requirement
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("P_NAME", dataForSave.getName())
                .addValue("P_EMAIL", dataForSave.getEmail())
                .addValue("P_PHONE", dataForSave.getPhone())
                .addValue("P_ADDRESS", dataForSave.getAddress())
                .addValue("P_CREATEBY", dataForSave.getCreateBy());

        Map<String, Object> resultSp = simpleJdbcCall.execute(parameterSource);

        // Get Result Value to Object
        List<ResponseSave> responseSave = (List<ResponseSave>) resultSp.get("p_recordset");

        return responseSave.get(0);
    }

    public ResponseSave updateEmployee(Employee dataForUpdate) {

        // Calling Stored Procedure To Get All User List
        JdbcHelper helper = new JdbcHelper();
        simpleJdbcCall = helper.useTemplate(this.jdbcTemplate)
                .spName("SP_EMPLOYEE_UPDATE")
                .mapTo(ResponseSave.class)
                .outParameter(InformationConstant.REF_CURSOR_RECORDSET)
                .build();

        // Set Query Param for Stored Procedure Requirement
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("P_ID", dataForUpdate.getId())
                .addValue("P_NAME", dataForUpdate.getName())
                .addValue("P_EMAIL", dataForUpdate.getEmail())
                .addValue("P_PHONE", dataForUpdate.getPhone())
                .addValue("P_ADDRESS", dataForUpdate.getAddress())
                .addValue("P_EDITBY", dataForUpdate.getEditBy());

        Map<String, Object> resultSp = simpleJdbcCall.execute(parameterSource);

        // Get Result Value to Object
        List<ResponseSave> responseSave = (List<ResponseSave>) resultSp.get("p_recordset");

        return responseSave.get(0);
    }

    public ResponseSave deleteEmployee(Employee dataForDelete) {
        // Calling Stored Procedure To Get All User List
        JdbcHelper helper = new JdbcHelper();
        simpleJdbcCall = helper.useTemplate(this.jdbcTemplate)
                .spName("SP_EMPLOYEE_DELETE")
                .mapTo(ResponseSave.class)
                .outParameter(InformationConstant.REF_CURSOR_RECORDSET)
                .build();

        // Set Query Param for Stored Procedure Requirement
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("P_ID", dataForDelete.getId());

        Map<String, Object> resultSp = simpleJdbcCall.execute(parameterSource);

        // Get Result Value to Object
        List<ResponseSave> responseDelete = (List<ResponseSave>) resultSp.get("p_recordset");

        return responseDelete.get(0);
    }

}

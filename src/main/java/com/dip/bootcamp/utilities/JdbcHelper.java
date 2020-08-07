package com.dip.bootcamp.utilities;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class JdbcHelper {

    private JdbcTemplate jdbcTemplate;

    private String objectName;
    private Class oClass;
    private SqlParameterSource inParam;

    private String outParam;
    private boolean withCompile = false;
    private boolean unsetInParameter = false;

    public JdbcHelper() {
        this.withCompile = false;
        this.unsetInParameter = false;
        this.outParam = "-";
    }

    public JdbcHelper unsetInputParameter() {
        this.withCompile = true;
        return this;
    }

    public JdbcHelper compileFirst(boolean cf) {
        this.withCompile = cf;
        return this;
    }

    public JdbcHelper(JdbcTemplate template, String _op, Class _class) {
        this.jdbcTemplate = template;
        this.outParam = _op;
        this.oClass = _class;
    }

    public JdbcHelper(JdbcTemplate template, String _op) {
        this.jdbcTemplate = template;
        this.outParam = _op;
    }

    public JdbcHelper(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    public JdbcHelper inParameter(SqlParameterSource parameterSource) {
        this.inParam = parameterSource;
        return this;
    }

    public JdbcHelper mapTo(Class _class) {
        this.oClass = _class;
        return this;
    }

    public JdbcHelper outParameter(String _op) {
        this.outParam = _op;
        return this;
    }

    public JdbcHelper useTemplate(JdbcTemplate template) {
        this.jdbcTemplate = template;
        return this;
    }

    public JdbcHelper spName(String _spName) {
        this.objectName = _spName;
        return this;
    }

    public Object getFnValue(String fnName, SqlParameterSource in) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
        simpleJdbcCall.withSchemaName(InformationConstant.DB_SCHEMA_NAME);
        simpleJdbcCall.withFunctionName(fnName);
        Object result = simpleJdbcCall.executeFunction(Object.class, in);
        return result;
    }

    public Object getFnValue(String fnName) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
        simpleJdbcCall.withSchemaName(InformationConstant.DB_SCHEMA_NAME);
        simpleJdbcCall.withFunctionName(fnName);
        Object result = simpleJdbcCall.executeFunction(Object.class);
        return result;
    }

    public SimpleJdbcCall build() {
        this.jdbcTemplate.setResultsMapCaseInsensitive(true);
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate);
        simpleJdbcCall.withSchemaName(InformationConstant.DB_SCHEMA_NAME);
        simpleJdbcCall.withProcedureName(this.objectName);

        if (this.unsetInParameter)
            simpleJdbcCall.withoutProcedureColumnMetaDataAccess();

        if (this.outParam != "-")
            simpleJdbcCall.returningResultSet(this.outParam, BeanPropertyRowMapper.newInstance(this.oClass));


        if (this.withCompile)
            simpleJdbcCall.compile();

        return simpleJdbcCall;
    }
}

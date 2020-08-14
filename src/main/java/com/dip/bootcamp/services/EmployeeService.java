package com.dip.bootcamp.services;

import com.dip.bootcamp.models.Employee;
import com.dip.bootcamp.repository.EmployeeRepository;
import com.dip.bootcamp.utilities.InformationConstant;
import com.dip.bootcamp.viewmodels.ResponseSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public List<Employee> getAllEmployee(Employee dataParam) {
        return repository.listEmployee(dataParam);
    }

    public ResponseSave saveEmployee(Employee dataForSave) {
        return repository.insertEmployee(dataForSave);
    }

    public ResponseSave deleteEmployee(Employee dataForDelete) {
        return repository.deleteEmployee(dataForDelete);
    }

}

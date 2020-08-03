package com.dip.bootcamp.services;

import com.dip.bootcamp.models.Employee;
import com.dip.bootcamp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public Integer saveEmployee(Employee dataForSave) {
        return repository.insertEmployee(dataForSave);
    }

}

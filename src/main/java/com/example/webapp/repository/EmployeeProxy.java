package com.example.webapp.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.webapp.CustomProperties;
import com.example.webapp.model.Employee;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class EmployeeProxy {

   @Autowired
    private CustomProperties props;

    /**
     * Get all employees
     * @return An iterable of all employees
     */

    public Iterable<Employee> getEmployees() {
        String baseApiUrl = props.getApiUrl();
        String getEmployeesUrl = baseApiUrl + "/employees";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Employee>> response = restTemplate.exchange(
                getEmployeesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Employee>>() {}
        );

        log.debug("Get Employees call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Employee getEmployee(final int id) {

        return null;
    }

    public void deleteEmployee(final int id){

    }

    public Employee createEmployee(Employee employee) {
        return null;
    }

    public Employee updateEmployee(Employee employee) {
        return null;
    }
}

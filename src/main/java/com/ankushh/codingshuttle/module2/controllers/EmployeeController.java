package com.ankushh.codingshuttle.module2.controllers;

import com.ankushh.codingshuttle.module2.dto.EmployeeDTO;
import com.ankushh.codingshuttle.module2.entities.EmployeeEntity;
import com.ankushh.codingshuttle.module2.repositories.EmployeeRepository;
import com.ankushh.codingshuttle.module2.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecret")
//    public String getMySecretMessage(){
//        return "Secret Message: afnsjk@$$@141";
//    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String sortBy){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping
    public String updateEmployeeById(){
        return "Hello from PUT";
    }

}

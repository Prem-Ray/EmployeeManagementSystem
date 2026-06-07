package org.premanshuray.EmployeeManagementSystem.controllers;


import jakarta.validation.Valid;
import org.premanshuray.EmployeeManagementSystem.dto.EmployeeDTO;
import org.premanshuray.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDTO);
    }



    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@Valid @RequestBody EmployeeDTO inputEmployee) {
        EmployeeDTO employeeDTO = employeeService.saveEmployee(inputEmployee);
        return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable Long id, @Valid @RequestBody EmployeeDTO inputEmployee) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(id, inputEmployee));
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployee(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployee(id, updates);
        return ResponseEntity.ok(employeeDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }

}
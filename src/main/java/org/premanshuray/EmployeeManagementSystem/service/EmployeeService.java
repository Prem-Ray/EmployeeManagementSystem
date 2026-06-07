package org.premanshuray.EmployeeManagementSystem.service;


import org.modelmapper.ModelMapper;
import org.premanshuray.EmployeeManagementSystem.dto.EmployeeDTO;
import org.premanshuray.EmployeeManagementSystem.entities.EmployeeEntity;
import org.premanshuray.EmployeeManagementSystem.exceptions.ResourceNotFoundException;
import org.premanshuray.EmployeeManagementSystem.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    public EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;


    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {

        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " was not found"));

        EmployeeDTO employeeDTO = modelMapper.map(employeeEntity, EmployeeDTO.class);
        return employeeDTO;
    }



    public List<EmployeeDTO> getAllEmployees(){
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        return employeeEntityList.stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .toList();
    }



    public EmployeeDTO saveEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);

        EmployeeEntity savedEmployee = employeeRepository.save(toSaveEntity);

        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }



    public EmployeeDTO updateEmployeeById(Long id, EmployeeDTO inputEmployee) {
        if (!isExistEmployee(id)) {
            throw new ResourceNotFoundException("Employee with id " + id + " was not found");
        }
        EmployeeEntity employeeEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        employeeEntity.setId(id);
        EmployeeEntity updateEmployee = employeeRepository.save(employeeEntity);
        return modelMapper.map(updateEmployee, EmployeeDTO.class);
    }

    public boolean isExistEmployee(Long id) {
        return employeeRepository.existsById(id);
    }

    public boolean deleteEmployee(Long id) {
        boolean isEmployeeExist = isExistEmployee(id);
        if (!isEmployeeExist) {
            throw new ResourceNotFoundException("Employee with id " + id + " was not found");
        }
        employeeRepository.deleteById(id);
        return true;
    }



    public EmployeeDTO updatePartialEmployee(Long id, Map<String, Object> updates) {
        if (!isExistEmployee(id)) {
            throw new ResourceNotFoundException("Employee with id " + id + " was not found");
        }

        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " was not found"));

        try {
            updates.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(EmployeeEntity.class, key);
                if (field == null) {
                    throw new IllegalArgumentException("Field '" + key + "' does not exist in Employee entity");
                }
                field.setAccessible(true);
                ReflectionUtils.setField(field, employeeEntity, value);
            });
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error updating employee: " + e.getMessage(), e);
        }

        EmployeeEntity updatedEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(updatedEntity, EmployeeDTO.class);
    }
}


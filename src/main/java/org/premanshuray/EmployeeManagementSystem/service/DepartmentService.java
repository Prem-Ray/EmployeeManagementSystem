package org.premanshuray.EmployeeManagementSystem.service;

import org.modelmapper.ModelMapper;
import org.premanshuray.EmployeeManagementSystem.dto.DepartmentDTO;
import org.premanshuray.EmployeeManagementSystem.entities.DepartmentEntity;
import org.premanshuray.EmployeeManagementSystem.exceptions.DepartmentNotFoundException;
import org.premanshuray.EmployeeManagementSystem.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    DepartmentRepository departmentRepository;
    ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public List<DepartmentDTO> getAllDepartments(){
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities.stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .toList();
    }

    public DepartmentDTO getDepartmentById(Long id){
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElseThrow(()-> new DepartmentNotFoundException("Department with id " + id + " not found"));
        return modelMapper.map(departmentEntity, DepartmentDTO.class);
    }

    public DepartmentDTO createDepartment(DepartmentDTO inputDepartmentDTO){
        DepartmentEntity departmentEntity = modelMapper.map(inputDepartmentDTO, DepartmentEntity.class);
        DepartmentEntity savedEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedEntity, DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartment(Long id, DepartmentDTO inputDepartmentDTO){

        boolean isExist = isDepartmentExist(id);
        if(!isExist) throw new DepartmentNotFoundException("Department with id " + id + " not found");

        DepartmentEntity departmentEntity = modelMapper.map(inputDepartmentDTO, DepartmentEntity.class);

        departmentEntity.setId(id);
        departmentRepository.save(departmentEntity);

        return modelMapper.map(departmentEntity, DepartmentDTO.class);
    }

    public void deleteDepartment(Long id){
        boolean isIdExist = isDepartmentExist(id);
        if(!isIdExist) throw new DepartmentNotFoundException("Department with id " + id + " not found");
        departmentRepository.deleteById(id);
    }

    private boolean isDepartmentExist(Long id) {
        return departmentRepository.existsById(id);
    }

}

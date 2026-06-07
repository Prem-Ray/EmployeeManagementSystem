package org.premanshuray.EmployeeManagementSystem.repositories;

import org.premanshuray.EmployeeManagementSystem.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

}

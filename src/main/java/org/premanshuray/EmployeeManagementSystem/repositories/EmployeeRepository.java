package org.premanshuray.EmployeeManagementSystem.repositories;

import org.premanshuray.EmployeeManagementSystem.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}

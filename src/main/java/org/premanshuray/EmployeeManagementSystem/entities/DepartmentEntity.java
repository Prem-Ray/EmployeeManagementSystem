package org.premanshuray.EmployeeManagementSystem.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "departments")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    @JsonProperty("active")
    private boolean isActive;
    private LocalDateTime timeStamp;

    @PrePersist
    public void prePersist() {
        if (this.timeStamp == null) {
            this.timeStamp = LocalDateTime.now();
        }
    }

}

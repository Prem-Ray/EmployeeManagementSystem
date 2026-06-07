package org.premanshuray.EmployeeManagementSystem.advices;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiResponse<T> {

    private T data;
    private ApiError error;
    @JsonFormat(pattern = "hh:mm:ss dd-MM-yyyy")
    private LocalDateTime timeStamp;


    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this.data = data;
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(ApiError error) {
        this.error = error;
        this.timeStamp = LocalDateTime.now();
    }

}

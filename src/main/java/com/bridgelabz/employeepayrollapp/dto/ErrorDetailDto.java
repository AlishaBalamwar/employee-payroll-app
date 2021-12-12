package com.bridgelabz.employeepayrollapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ErrorDetailDto {
    private Date timeStamp;
    private String message;
    private String details;

    public ErrorDetailDto(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }
}

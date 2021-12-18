package com.bridgelabz.employeepayrollapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Purpose: this class is created to show details of errors
 *
 * @author: ALISHA BALAMWAR
 * @since: 2021-12-13
 */
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

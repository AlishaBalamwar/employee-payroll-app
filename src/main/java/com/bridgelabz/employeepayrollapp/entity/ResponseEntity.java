package com.bridgelabz.employeepayrollapp.entity;

import lombok.Data;

/**
 * Purpose: To declare response entity.
 *
 * @author: ALISHA BALAMWAR
 * @since: 2021-12-13
 */
@Data
public class ResponseEntity {
    private String message;
    private Object data;
    private Object status;

    public ResponseEntity(String message, Object data, Object status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }
}

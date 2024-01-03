package com.example.bvnk_client_service.exception;

import lombok.Data;

import java.time.ZonedDateTime;


/**
 * Data class to hold the custom error response.
 */
@Data
public class CustomErrorResponse {

    /**
     * The current time in the ISO-8601 format.
     */
    private ZonedDateTime timestamp;

    /**
     * The HTTP status code.
     */
    private int status;

    /**
     * The error code.
     */
    private String error;

    /**
     * The error message.
     */
    private String message;

}
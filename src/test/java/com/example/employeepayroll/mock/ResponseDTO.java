package com.example.employeepayroll.mock;

public class ResponseDTO {

    private String status;
    private Integer statusCode;
    private String message;
    private Object data;

    public ResponseDTO() {
    }

    public ResponseDTO(String status, Integer statusCode, String message, Object data) {
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public ResponseDTO(Object data, String message) {
        this.statusCode = 200;
        this.message = message;
        this.data = data;
        this.status = "SUCCESS";

    }

    public ResponseDTO(Object data) {
        this.statusCode = 200;
        this.status = "SUCCESS";
        this.data = data;
    }

    public ResponseDTO(String message) {
        this.statusCode = 200;
        this.message = message;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

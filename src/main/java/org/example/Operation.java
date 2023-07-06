package org.example;

public enum Operation {

    ADD("ADD"),
    GET("GET"),
    UPDATE("UPDATE"),
    DELETE("UPDATE");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }
}

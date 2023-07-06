package org.example;

public class DBOperation {

    private Operation operation;
    private String title;
    private String timestamp;

    public DBOperation(Operation operation, String title, String timestamp) {
        this.operation = operation;
        this.title = title;
        this.timestamp = timestamp;
    }


    @Override
    public String toString() {
        return "DBOperation{" +
                "operation='" + operation + '\'' +
                ", title='" + title + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

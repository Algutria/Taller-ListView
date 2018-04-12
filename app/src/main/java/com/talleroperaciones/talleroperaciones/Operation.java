package com.talleroperaciones.talleroperaciones;

public class Operation {
    private String operation;
    private String data;
    private String result;

    public Operation(String operation, String data, String result){
        this.operation = operation;
        this.data = data;
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public String getData() {
        return data;
    }

    public String getResult() {
        return result;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void save(){
        Data.saveOperation(this);
    }
}

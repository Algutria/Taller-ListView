package com.talleroperaciones.talleroperaciones;

import java.util.ArrayList;

public class Data {
    private static ArrayList<Operation> operations = new ArrayList();

    public static void saveOperation(Operation operation){
        operations.add(operation);
    }

    public static ArrayList<Operation> getOperations(){
        return operations;
    }
}

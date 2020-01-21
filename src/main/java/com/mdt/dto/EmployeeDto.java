package com.mdt.dto;


public class EmployeeDto {

    private final String id;
    private final String firstName;
    private final String lastName;

    public EmployeeDto(String id, String firstName, String lastName){

        this.id = id;
        this.firstName= firstName;
        this.lastName = lastName;
    }

    public String getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }
}

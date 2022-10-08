package com.user.model.request;

import lombok.Data;

@Data
public class CreateNewUser {

    private int _id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String gender;

    private String dateOfBirth;

    private String employeeId;

    private String email;

    private String phoneNumber;

    private String address;

    private String password;
}



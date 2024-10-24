package edu.icet.crm.model;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String name;
    private int age;
    private String address;
    private String guardianName;
    private String guardianContact;
}


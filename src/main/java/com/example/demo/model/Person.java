package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Person {

    private String firstname;
    private String lastname;
    private LocalDateTime birthdate;
    private Address address;
    private List<Telephone> telNrs;
}

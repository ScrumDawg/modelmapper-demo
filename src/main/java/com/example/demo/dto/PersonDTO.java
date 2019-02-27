package com.example.demo.dto;

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
public class PersonDTO {
    private String firstname;
    private String lastname;
    private LocalDateTime birthdate;
    private AddressDTO address;
    private List<TelephoneDTO> telNrs;

}

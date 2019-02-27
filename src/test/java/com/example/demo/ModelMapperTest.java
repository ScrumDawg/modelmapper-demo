package com.example.demo;

import com.example.demo.dto.PersonDTO;
import com.example.demo.model.Address;
import com.example.demo.model.Person;
import com.example.demo.model.Telephone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelMapperTest {

    @Autowired
    ModelMapper beanUnderTest;


    @Test
    public void test_ConvertModelToDTO(){

        TypeMap<Person, PersonDTO> personMap = beanUnderTest.createTypeMap(Person.class, PersonDTO.class);
        Person person = createPerson();
        PersonDTO personDTO = beanUnderTest.map(person, PersonDTO.class);

    }


    private Person createPerson(){
        return Person.builder()
                .firstname("Max")
                .lastname("Mustermann")
                .birthdate(LocalDateTime.of(1980, Month.FEBRUARY, 10, 12, 24))
                .address(createAddress())
                .telNrs(createTelephoneList())
                .build();
    }

    private Address createAddress(){
        return Address.builder()
                .country("Deutschland")
                .state("Berlin")
                .city("Berlin")
                .zip("13507")
                .street("Berliner Str.")
                .number("1")
                .build();

    }

    private List<Telephone> createTelephoneList(){
        return new ArrayList(Arrays.asList(
                createTelephoneNr("privat", "123"),
                createTelephoneNr("mobil", "456"),
                createTelephoneNr("büro", "789")));
    }

    private Telephone createTelephoneNr(String designation, String number){
        return Telephone.builder()
                .designation(designation)
                .number(number)
                .build();
    }

}

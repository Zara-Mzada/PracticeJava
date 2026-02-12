package com.student.controller;

import com.student.dto.CountriesWithSalariesDto;
import com.student.dto.PersonCreateDto;
import com.student.dto.PersonGroupByCountryDto;
import com.student.dto.PersonNameAndAgeDto;
import com.student.service.Impl.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/person/")
public class PersonController {
    private final PersonServiceImpl personService;

    @PostMapping("create")
    public PersonCreateDto createPerson(@RequestBody PersonCreateDto personCreateDto){
        return personService.createPerson(personCreateDto);
    }

    @GetMapping
    public List<PersonCreateDto> getPersons(){
        return personService.getPersons();
    }

    @GetMapping("{id}")
    public PersonCreateDto getPersonById(@PathVariable Long id){
        return personService.getPerson(id);
    }

    @GetMapping("name/{name}")
    public List<PersonCreateDto> getPersonByName(@PathVariable String name){
        return personService.getPersonByName(name);
    }

    @GetMapping("n&a")
    public List<PersonNameAndAgeDto> getPersonSameNameAge(){
        return personService.getData();
    }

    @GetMapping("groupByCountry")
    public List<PersonGroupByCountryDto> getGroupByCountry(){
        return personService.getCountries();
    }

    @GetMapping("salariesByCountry")
    public List<CountriesWithSalariesDto> getSalariesByCountry(){
        return personService.getSalariesByCountries();
    }

    @PutMapping("update")
    public void updateFirstName(@RequestBody PersonNameAndAgeDto personNameAndAgeDto){
        personService.updateFirstName(personNameAndAgeDto.getFirstName(), personNameAndAgeDto.getAge());
    }

    @DeleteMapping("delete/{age}")
    public void deletePerson(@PathVariable Integer age){
        personService.deletePerson(age);
    }
}

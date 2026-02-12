package com.student.service;

import com.student.dto.CountriesWithSalariesDto;
import com.student.dto.PersonCreateDto;
import com.student.dto.PersonGroupByCountryDto;
import com.student.dto.PersonNameAndAgeDto;

import java.util.List;

public interface PersonService {
    PersonCreateDto createPerson(PersonCreateDto personCreateDto);
    List<PersonCreateDto> getPersons();
    PersonCreateDto getPerson(Long id);
    List<PersonNameAndAgeDto> getData();

    void updateFirstName(String name, Integer age);
    void deletePerson(Integer age);
    List<PersonCreateDto> getPersonByName(String name);
    List<PersonGroupByCountryDto> getCountries();
    List<CountriesWithSalariesDto> getSalariesByCountries();
}

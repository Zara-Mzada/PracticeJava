package com.student.service.Impl;

import com.student.dao.repository.PersonRepository;
import com.student.dto.PersonCreateDto;
import com.student.dto.PersonNameAndAgeDto;
import com.student.mapper.PersonMapper;
import com.student.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public PersonCreateDto createPerson( PersonCreateDto personCreateDto) {
        personRepository.savePersons(personCreateDto.getFirstName(),
                personCreateDto.getLastName(),
                personCreateDto.getAge());

        return personCreateDto;
    }

    @Override
    public List<PersonCreateDto> getPersons() {
        return personRepository.getPersons();
    }

    @Override
    public PersonCreateDto getPerson(Long id) {
        return personRepository.getPerson(id);
    }

    @Override
    public List<PersonNameAndAgeDto> getData() {
        return personRepository.getData();
    }

    @Override
    public void updateFirstName(String name, Integer age) {
        personRepository.updateFirstName(name, age);
    }

    @Override
    public void deletePerson(Integer age) {
        personRepository.deletePerson(age);
    }

    @Override
    public List<PersonCreateDto> getPersonByName(String name) {
        return personRepository.getPersonByName(name);
    }
}

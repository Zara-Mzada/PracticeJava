package com.student.dao.repository;

import com.student.dao.entity.PersonEntity;
import com.student.dto.CountriesWithSalariesDto;
import com.student.dto.PersonCreateDto;
import com.student.dto.PersonGroupByCountryDto;
import com.student.dto.PersonNameAndAgeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    @Query(
            value = "INSERT INTO person (first_name, last_name, age)\n" +
                    "VALUES ( :firstName, :lastName, :age)",
            nativeQuery = true
    )
    @Transactional
    @Modifying
    void savePersons(@Param("firstName") String firstName,
                            @Param("lastName") String lastName,
                            @Param("age") Integer age);


    @Query(
            value = "SELECT person.first_name, person.last_name, person.age FROM person",
            nativeQuery = true
    )
    List<PersonCreateDto> getPersons();

    @Query(
            value = "SELECT person.first_name, person.last_name, person.age FROM person\n" +
                    "WHERE person.id = :id",
            nativeQuery = true
    )
    PersonCreateDto getPerson(@Param("id") Long id);

    @Query(
            value = "SELECT p.first_name, p.age, count(*) FROM person as p\n" +
                    "GROUP BY p.first_name, p.age\n" +
                    "HAVING count(*)>1",
            nativeQuery = true
    )
    List<PersonNameAndAgeDto> getData();


    @Query(
            value = "UPDATE person\n" +
                    "SET first_name = :name\n" +
                    "WHERE age > :age",
            nativeQuery = true
    )
    @Transactional
    @Modifying
    void updateFirstName(@Param("name") String name,
                         @Param("age") Integer age);

    @Query(
            value = "DELETE FROM person WHERE age < :age",
            nativeQuery = true
    )
    @Transactional
    @Modifying
    void deletePerson(@Param("age") Integer age);


    @Query(
            value = "SELECT p.first_name, p.last_name, p.age FROM person as p\n" +
                    "WHERE first_name = :name",
            nativeQuery = true
    )
    List<PersonCreateDto> getPersonByName(@Param("name") String name);


    @Query(
            value = "SELECT p.country, count(p.country)\n" +
                    "FROM person as p\n" +
                    "GROUP BY p.country",
            nativeQuery = true
    )
    List<PersonGroupByCountryDto> getGroupCountry();


    @Query(
            value = "SELECT p.country, SUM(p.salary)\n" +
                    "FROM person as p\n" +
                    "GROUP BY p.country ",
            nativeQuery = true
    )
    List<CountriesWithSalariesDto> getSalariesByCounrtries();
}

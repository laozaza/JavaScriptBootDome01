package com.example.javascriptbootdome01.SQL.Redis;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Person1Repository extends CrudRepository<Person1, String> {
    List<Person1> findByLastname(String lastname);
    Page<Person1> findPersonByLastname(String lastname, Pageable page);
    List<Person1> findByFirstnameAndLastname(String firstname, String lastname);
    List<Person1> findByAddress_City(String city);
    List<Person1> findByFamilyList_Username(String username);
}


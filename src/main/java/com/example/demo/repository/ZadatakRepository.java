package com.example.demo.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Zadatak;

@Repository
public interface ZadatakRepository extends JpaRepository<Zadatak, Long> {

     Zadatak findOneById(Long id);
     
     Zadatak findBySprintId(Long id);
     
     Zadatak findByStanjeId(Long id);

     Page<Zadatak> findByImeIgnoreCaseContains(String ime, org.springframework.data.domain.Pageable pageable);
     
     Page<Zadatak> findByImeIgnoreCaseContainsAndSprintId(String ime, Long sprintId, org.springframework.data.domain.Pageable pageable);

     
}

package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Zadatak;

public interface ZadatakService {

	Zadatak findOne(Long id);

    List<Zadatak> findAll();

    Zadatak FindByStanjeId(Long id);
    
    Zadatak FindBySprintId(Long id);

    Zadatak save(Zadatak zadatak);

    Zadatak update(Zadatak zadatak);

    Zadatak delete(Long id);
    
    Page<Zadatak> findBYime(String ime, int pageNo);

    Page<Zadatak> findAll(int pageNo);
    
    Page<Zadatak> find(String ime, Long sprintId, int pageNo);
}

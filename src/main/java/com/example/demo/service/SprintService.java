package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Sprint;
import com.example.demo.model.Zadatak;

public interface SprintService {

	Sprint findOne(Long id);

    List<Sprint> findAll();

//    List<Sprint> findByZadatak(List<Long>ids);

    Sprint save(Sprint sprint);

    Sprint update(Sprint sprint);

    Sprint delete(Long id);
}

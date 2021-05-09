package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Stanje;
import com.example.demo.model.Zadatak;

public interface StanjeService {

	
	Stanje findOne(Long id);

    List<Stanje> findAll();

    List<Stanje> findByZadatak(List<Long> ids);

    Stanje save(Stanje stanje);

    Stanje update(Stanje stanje);

    Stanje delete(Long id);
}

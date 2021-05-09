package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Sprint;
import com.example.demo.model.Stanje;
import com.example.demo.repository.StanjeRepository;
import com.example.demo.service.SprintService;
import com.example.demo.service.StanjeService;

@Service
public class JpaStanjeService implements StanjeService{

	@Autowired
	private StanjeRepository stanjeRepository;

	@Override
	public Stanje findOne(Long id) {
		return stanjeRepository.findOneById(id);
	}

	@Override
	public List<Stanje> findAll() {
		return stanjeRepository.findAll();
	}

	@Override
	public List<Stanje> findByZadatak(List<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stanje save(Stanje stanje) {
		return stanjeRepository.save(stanje);
	}

	@Override
	public Stanje update(Stanje stanje) {
		return stanjeRepository.save(stanje);
	}

	@Override
	public Stanje delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	
}

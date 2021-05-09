package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Zadatak;
import com.example.demo.repository.ZadatakRepository;
import com.example.demo.service.ZadatakService;


@Service
public class JpaZadatakService implements ZadatakService{
	
	@Autowired
	private ZadatakRepository zadatakRepositoy;
	
	@Override
	public Zadatak findOne(Long id) {
		return zadatakRepositoy.findOneById(id);
	}

	@Override
	public List<Zadatak> findAll() {
		return zadatakRepositoy.findAll();
	}

	@Override
	public Zadatak save(Zadatak zadatak) {
		return zadatakRepositoy.save(zadatak);
	}

	@Override
	public Zadatak update(Zadatak zadatak) {
		return zadatakRepositoy.save(zadatak);

	}

	@Override
	public Zadatak delete(Long id) {
	Optional<Zadatak> zadatak=  zadatakRepositoy.findById(id);
		
	if (zadatak.isPresent()){
	//zadatakRepositoy.deleteById(id);
	zadatakRepositoy.delete(zadatak.get());
		
		
		return zadatak.get();
	}
	return null;
	}
	

	@Override
	public Zadatak FindByStanjeId(Long id) {
		return zadatakRepositoy.findByStanjeId(id);
	}

	@Override
	public Zadatak FindBySprintId(Long id) {
	return zadatakRepositoy.findBySprintId(id);
	}

	@Override
	public Page<Zadatak> findBYime(String ime,int pageNo ) {
		return zadatakRepositoy.findByImeIgnoreCaseContains(ime,PageRequest.of(pageNo, 3));
	}

	@Override
	public Page<Zadatak> findAll(int pageNo) {
		return zadatakRepositoy.findAll(PageRequest.of(pageNo, 2));
	}

	@Override
	public Page<Zadatak> find(String ime, Long sprintId, int pageNo) {
		if(ime==null) {
			ime="";
		}
		if(sprintId<=0) {
		
			return zadatakRepositoy.findByImeIgnoreCaseContains(ime, PageRequest.of(pageNo, 3));
		}
		else {
		
		return zadatakRepositoy.findByImeIgnoreCaseContainsAndSprintId(ime, sprintId, PageRequest.of(pageNo, 3));
		}
	}

	
	
	

}

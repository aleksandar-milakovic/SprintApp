package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Stanje;

@Repository
public interface StanjeRepository extends JpaRepository<Stanje, Long>{

	Stanje findOneById(Long id);
	
	List<Stanje> findByZadaciId(Long zadatakId);
	
}

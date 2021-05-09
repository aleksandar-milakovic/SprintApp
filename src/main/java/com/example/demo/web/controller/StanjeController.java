package com.example.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Sprint;
import com.example.demo.model.Stanje;
import com.example.demo.service.StanjeService;
import com.example.demo.support.StanjeDtotoStanje;
import com.example.demo.support.StanjetoStanjeDto;
import com.example.demo.web.dto.SprintDto;
import com.example.demo.web.dto.StanjeDto;

@RestController
@RequestMapping(value = "/api/stanja", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class StanjeController {

	@Autowired
	private StanjeService stanjeService;
	
	@Autowired 
	private StanjeDtotoStanje toStanje;
	
	@Autowired
	private StanjetoStanjeDto toStanjeDto;
	

		@GetMapping
	    public ResponseEntity<List<StanjeDto>> getAll(){

	        List<Stanje> stanje = stanjeService.findAll();

	        return new ResponseEntity<>(toStanjeDto.convert(stanje), HttpStatus.OK);
	    }
	

	
}

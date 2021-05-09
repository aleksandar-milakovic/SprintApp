package com.example.demo.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Sprint;
import com.example.demo.model.Stanje;
import com.example.demo.model.Zadatak;
import com.example.demo.service.SprintService;
import com.example.demo.service.StanjeService;
import com.example.demo.service.ZadatakService;
import com.example.demo.support.ZadatakDtotoZadatak;
import com.example.demo.support.ZadataktToZadatakDto;
import com.example.demo.web.dto.ZadatakDto;






@RestController
@RequestMapping(value = "/api/zadaci", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class ZadatakController {

@Autowired
private ZadatakService zadatakService;

@Autowired
private SprintService sprintService;
@Autowired
private StanjeService stanjeService;

@Autowired
private ZadatakDtotoZadatak toZadatak;

@Autowired
private ZadataktToZadatakDto toZadatakDto;

@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<ZadatakDto> create(@Valid @RequestBody ZadatakDto zadatakDTO){
	
	System.out.println("bodovi su"+zadatakDTO.getBodovi());
//    if(!id.equals(zadatakDTO.getId())) {
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
    Integer s= 0;
    Sprint sprint = sprintService.findOne(zadatakDTO.getSprintId());
    System.out.println("Ukupni bodovi su"+sprint.getUkupnoBodova());
    s= zadatakDTO.getBodovi() + Integer.parseInt(sprint.getUkupnoBodova());
    
    sprint.setUkupnoBodova(s.toString());
  

	
	
	
	
	Zadatak zadatak = toZadatak.convert(zadatakDTO);
    Zadatak sacuvanFilm = zadatakService.save(zadatak);

    return new ResponseEntity<>(toZadatakDto.convert(sacuvanFilm), HttpStatus.CREATED);
}


@GetMapping
public ResponseEntity<List<ZadatakDto>> getAll(
        @RequestParam(required=false) String ime,
        @RequestParam(required=false) Long sprintId,
        @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
        @RequestParam(value = "totalPages", defaultValue = "0") int totalPages)
      {

		
		Page<Zadatak> page=null;
		
		   
	
	if(sprintId>=0) {
		page = zadatakService.find(ime, sprintId, pageNo);		   
	}else {
		page = zadatakService.findAll(pageNo);
	}
   
    
   HttpHeaders headers = new HttpHeaders();
   headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
   System.out.println(page.getTotalPages());
   totalPages= page.getTotalPages();

    return new ResponseEntity<>(toZadatakDto.convert(page.getContent()),headers, HttpStatus.OK);
}
@GetMapping("/{id}")
public ResponseEntity<ZadatakDto> getOne(@PathVariable Long id){
    Zadatak zadatak = zadatakService.findOne(id);

    if(zadatak != null) {
        return new ResponseEntity<>(toZadatakDto.convert(zadatak), HttpStatus.OK);
    }else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id){
  
	
     
	Zadatak zadatak = zadatakService.findOne(id);
  
    int s= zadatak.getBodovi();
    Sprint sprint = sprintService.findOne(zadatak.getSprint().getId());
    List<Zadatak>zadaci=sprint.getZadaci();
   Integer rez=0;
    for (Zadatak zadatak2 : zadaci) {
		if(zadatak2.getId()==id) {
		 System.out.println("ovo je to"+zadatak2.getBodovi());  
		rez = Integer.parseInt(sprint.getUkupnoBodova())-zadatak2.getBodovi();
		}
		sprint.setUkupnoBodova(rez.toString());
		System.out.println(rez);
	}
	
	
	
  Zadatak obrisanZadatak = zadatakService.delete(id);
//   Zadatak sacuvaniZadatak = zadatakService.save(obrisanZadatak);
    if(obrisanZadatak != null) { 
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
@PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<ZadatakDto> update(@PathVariable Long id, @Valid @RequestBody ZadatakDto zadatakDTO){

	System.out.println(zadatakDTO.getBodovi());
    if(!id.equals(zadatakDTO.getId())) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    int s= zadatakDTO.getBodovi();
    Sprint sprint = sprintService.findOne(zadatakDTO.getSprintId());
    List<Zadatak>zadaci=sprint.getZadaci();
   int rez=0;
    for (Zadatak zadatak2 : zadaci) {
		if(zadatak2.getId()==id) {
		 System.out.println(zadatak2.getBodovi());  
		rez = Integer.parseInt(sprint.getUkupnoBodova())-zadatak2.getBodovi();
		}
	}
    System.out.println("rez je"+rez);
    Zadatak zadatak = toZadatak.convert(zadatakDTO);
    Integer broj = 0;
  //  broj += Integer.parseInt(zadatak.getSprint().getUkupnoBodova());
   
   
    broj= rez+s;
    sprint.setUkupnoBodova(broj.toString());
    zadatak.setSprint(sprint);
    Zadatak sacuvanFilm = zadatakService.update(zadatak);

    return new ResponseEntity<>(toZadatakDto.convert(sacuvanFilm),HttpStatus.OK);
}
@PutMapping(value = "/stanje/{id}")
public ResponseEntity<ZadatakDto> updateState(@PathVariable Long id ){
	  
	
	Zadatak zadatak = zadatakService.findOne(id);
	System.out.println(zadatak.getZaduzeni());
	Stanje stanje=null;
	if(zadatak.getStanje().getIme().equals("u toku")) {
		zadatak.setStanje(stanjeService.findOne(1L));
	}
	
	
	if(zadatak.getStanje().getIme().equalsIgnoreCase("nov")) {
		zadatak.setStanje(stanjeService.findOne(2L));
	}
	
	
	
  //  broj += Integer.parseInt(zadatak.getSprint().getUkupnoBodova());
   
   
   
   
    Zadatak sacuvanFilm = zadatakService.update(zadatak);

    return new ResponseEntity<>(toZadatakDto.convert(sacuvanFilm),HttpStatus.OK);
}

}

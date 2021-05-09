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
import com.example.demo.service.SprintService;
import com.example.demo.support.SprintDtotoSprint;
import com.example.demo.support.SprintToSprintDto;
import com.example.demo.web.dto.SprintDto;


@RestController
@RequestMapping(value = "/api/sprintovi", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class SprintController {

	@Autowired
	private SprintService sprintService;
	
	@Autowired
	private SprintDtotoSprint toSprint;
	
	@Autowired
	private SprintToSprintDto toSprintDto;

	
	 @GetMapping
	    public ResponseEntity<List<SprintDto>> getAll(){

	        List<Sprint> sprint = sprintService.findAll();

	        return new ResponseEntity<>(toSprintDto.convert(sprint), HttpStatus.OK);
	    }

}

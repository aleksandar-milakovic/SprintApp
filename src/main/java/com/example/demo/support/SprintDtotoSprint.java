package com.example.demo.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Sprint;
import com.example.demo.service.SprintService;
import com.example.demo.web.dto.SprintDto;

@Component
public class SprintDtotoSprint implements Converter<SprintDto, Sprint> {

	@Autowired
	private SprintService sprintService;
	
	
	@Override
	public Sprint convert(SprintDto sprintDto) {
		Sprint sprint;
		
		if(sprintDto.getId()==null) {
			sprint= new Sprint();
		}else {
			sprint = sprintService.findOne(sprintDto.getId());
			
		}
		if(sprint!= null) {
			sprint.setIme(sprintDto.getIme());
			sprint.setUkupnoBodova(sprintDto.getUkupniBodovi().toString());
		}
		return sprint;
	}

}

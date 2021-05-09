package com.example.demo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Sprint;
import com.example.demo.web.dto.SprintDto;

@Component
public class SprintToSprintDto implements Converter<Sprint, SprintDto>  {

	@Override
	public SprintDto convert(Sprint sprint) {
		SprintDto sprintDto = new SprintDto();
		sprintDto.setId(sprint.getId());
		sprintDto.setIme(sprint.getIme());
		sprintDto.setUkupniBodovi(Integer.parseInt(sprint.getUkupnoBodova()));
	return sprintDto;
	}
	public List<SprintDto> convert (List<Sprint> sprintevi){
		
		List<SprintDto> sprintDto = new ArrayList<>();
		
		for(Sprint sprint : sprintevi) {
			sprintDto.add(convert(sprint));
		}
		return sprintDto;
		
		
	}



}

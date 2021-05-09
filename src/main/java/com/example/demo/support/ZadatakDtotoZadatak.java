package com.example.demo.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Zadatak;
import com.example.demo.service.SprintService;
import com.example.demo.service.StanjeService;
import com.example.demo.service.ZadatakService;
import com.example.demo.web.dto.ZadatakDto;

@Component
public class ZadatakDtotoZadatak implements Converter<ZadatakDto, Zadatak> {

	@Autowired 
	private ZadatakService zadService;
	
	@Autowired
	private SprintService sprintS;
	
	@Autowired
	private StanjeService stanjeS;
	
	@Override
	public Zadatak convert (ZadatakDto zadatakDto) {
		Zadatak zadatak;
		
		if(zadatakDto.getId()==null) {
			zadatak = new Zadatak();
		}else {
			zadatak = zadService.findOne(zadatakDto.getId());
		}
		if(zadatak!=null) {
			zadatak.setBodovi(zadatakDto.getBodovi());
			zadatak.setIme(zadatakDto.getIme());
			zadatak.setSprint(sprintS.findOne(zadatakDto.getSprintId()));
			zadatak.setZaduzeni(zadatakDto.getZaduzeni());
			zadatak.setStanje(stanjeS.findOne(zadatakDto.getStanjeId()));
			
		
			
		}
		return zadatak;
	}
}

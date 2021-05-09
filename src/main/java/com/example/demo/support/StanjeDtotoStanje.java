package com.example.demo.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Sprint;
import com.example.demo.model.Stanje;
import com.example.demo.service.SprintService;
import com.example.demo.service.StanjeService;
import com.example.demo.web.dto.SprintDto;
import com.example.demo.web.dto.StanjeDto;
@Component
public class StanjeDtotoStanje implements Converter<StanjeDto, Stanje> {
	@Autowired
	private StanjeService stanjeService;
	
	
	@Override
	public Stanje convert(StanjeDto stanjeDto) {
		Stanje stanje;
		
		if(stanjeDto.getId()==null) {
			stanje= new Stanje();
		}else {
			stanje = stanjeService.findOne(stanjeDto.getId());
			
		}
		if(stanje!= null) {
			stanje.setIme(stanjeDto.getIme());
		
		}
		return stanje;
	}

}

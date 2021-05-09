package com.example.demo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Sprint;
import com.example.demo.model.Stanje;
import com.example.demo.web.dto.SprintDto;
import com.example.demo.web.dto.StanjeDto;
@Component
public class StanjetoStanjeDto implements Converter<Stanje, StanjeDto> {

	@Override
	public StanjeDto convert(Stanje stanje) {
		StanjeDto stanjeDto = new StanjeDto();
		stanjeDto.setId(stanje.getId());
		stanjeDto.setIme(stanje.getIme());
	
	return stanjeDto;
	}
	public List<StanjeDto> convert (List<Stanje> stanja){
		
		List<StanjeDto> stanjeDto = new ArrayList<>();
		
		for(Stanje stanje : stanja) {
			stanjeDto.add(convert(stanje));
		}
		return stanjeDto;
		
		
	}


}

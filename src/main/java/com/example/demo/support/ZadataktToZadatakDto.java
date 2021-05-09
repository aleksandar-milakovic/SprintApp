package com.example.demo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Zadatak;
import com.example.demo.web.dto.SprintDto;
import com.example.demo.web.dto.ZadatakDto;

@Component
public class ZadataktToZadatakDto implements Converter<Zadatak, ZadatakDto>{

	@Override
	public ZadatakDto convert(Zadatak zadatak) {
		
		ZadatakDto zadatakDto = new ZadatakDto();
		zadatakDto.setId(zadatak.getId());
		zadatakDto.setBodovi(zadatak.getBodovi());
		zadatakDto.setIme(zadatak.getIme());
		zadatakDto.setSprintId(zadatak.getSprint().getId());
		zadatakDto.setStanjeId(zadatak.getStanje().getId());
		zadatakDto.setZaduzeni(zadatak.getZaduzeni());
		zadatakDto.setSprintIme(zadatak.getSprint().getIme());
		zadatakDto.setStanjeIme(zadatak.getStanje().getIme());
		return zadatakDto;
	}
	public List<ZadatakDto> convert (List<Zadatak> zadaci){
		List<ZadatakDto> zadatakDto = new ArrayList<>();
		
		for(Zadatak zadatak : zadaci) {
			zadatakDto.add(convert(zadatak));
			
		}
	return zadatakDto;
	}
}

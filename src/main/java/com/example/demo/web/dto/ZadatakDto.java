package com.example.demo.web.dto;

import javax.management.MXBean;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

public class ZadatakDto {

	private Long id;
	@NotBlank(message = "Ime nije uneto")
	@NotNull
	@Size(min=1, max=40)
	private String ime;
	
	private String zaduzeni;
	
	@Min(value =0 )
	@Max(value = 20, message = "Maksimalno bodova je do 20")
	private Integer bodovi;
	
	private Long SprintId;
	
	private Long StanjeId;

	private String StanjeIme;
	
	private String SprintIme;
	
	public String getStanjeIme() {
		return StanjeIme;
	}

	public void setStanjeIme(String stanjeIme) {
		StanjeIme = stanjeIme;
	}

	public String getSprintIme() {
		return SprintIme;
	}

	public void setSprintIme(String sprintIme) {
		SprintIme = sprintIme;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getZaduzeni() {
		return zaduzeni;
	}

	public void setZaduzeni(String zaduzeni) {
		this.zaduzeni = zaduzeni;
	}

	public Integer getBodovi() {
		return bodovi;
	}

	public void setBodovi(Integer bodovi) {
		this.bodovi = bodovi;
	}

	public Long getSprintId() {
		return SprintId;
	}

	public void setSprintId(Long sprintId) {
		SprintId = sprintId;
	}

	public Long getStanjeId() {
		return StanjeId;
	}

	public void setStanjeId(Long stanjeId) {
		StanjeId = stanjeId;
	}

	public ZadatakDto() {
		super();
	}
	
	
	
	
}

package com.example.demo.web.dto;

public class SprintDto {
	
	
	private Long id;
	
	
	private String ime;

	private Integer ukupniBodovi;

	public Integer getUkupniBodovi() {
		return ukupniBodovi;
	}


	public void setUkupniBodovi(Integer ukupniBodovi) {
		this.ukupniBodovi = ukupniBodovi;
	}


	public SprintDto() {
		super();
	}


	public SprintDto(Long id, String ime) {
		super();
		this.id = id;
		this.ime = ime;
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



}

package com.example.demo.web.dto;

public class StanjeDto {
	
private Long id;
	
	
	private String ime;

	

	


	


	public StanjeDto() {
		super();
	}


	public StanjeDto(Long id, String ime) {
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

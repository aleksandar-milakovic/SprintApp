package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;
import org.springframework.data.annotation.Id;



@Entity
public class Sprint {

@javax.persistence.Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;


@Column
private String ime;


@Column 
private String ukupnoBodova;

@OneToMany(mappedBy = "sprint", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
private List<Zadatak> zadaci = new ArrayList<>();

public Sprint() {
	super();
}


public List<Zadatak> getZadaci() {
	return zadaci;
}


public void setZadaci(List<Zadatak> zadaci) {
	this.zadaci = zadaci;
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


public String getUkupnoBodova() {
	return ukupnoBodova;
}


public void setUkupnoBodova(String ukupnoBodova) {
	this.ukupnoBodova = ukupnoBodova;
}


@Override
public String toString() {
	return "Sprint [id=" + id + ", ime=" + ime + ", ukupnoBodova=" + ukupnoBodova + "]";
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Sprint other = (Sprint) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}



}

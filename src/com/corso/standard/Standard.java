package com.corso.standard;


import javax.persistence.Column;
import javax.persistence.Entity;

@Entity

public class Standard {
	@Column(name="Code", unique = true)
	private String code;
	@Column(name="Code", unique = true)
	private String value;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public Standard(String code, String value) {
	
		this.code = code;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Standard [code=" + code + ", value=" + value + "]";
	}

}

package com.corso.standard;

public class Standard {

	private String code;
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

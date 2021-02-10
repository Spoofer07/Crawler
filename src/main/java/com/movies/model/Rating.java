package com.movies.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating {

	@JsonProperty("Value")
	private String value;
	@JsonProperty("Source")
	private String source;
	
	public Rating () {}

	public Rating(String value, String source) {
		super();
		this.value = value;
		this.source = source;
	}

	public String getValue() {
		return value;
	}

	public String getSource() {
		return source;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setSource(String source) {
		this.source = source;
	};
	
	
}

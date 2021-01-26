package com.sezayir.demo.model;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode(exclude = {"price","ageRange","start","end"})

public class Tour {
	
	private String name;

	private BigDecimal price;

	private AgeRange ageRange;

	private LocalTime start;

	private LocalTime end;

	static Map<String, Tour> tours = new HashMap<>();

	public static Map<String, Tour> getTours() {
		return tours;
	}


}

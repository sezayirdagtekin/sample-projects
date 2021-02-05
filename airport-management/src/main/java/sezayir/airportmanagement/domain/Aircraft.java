package sezayir.airportmanagement.domain;

import lombok.Data;

@Data
public class Aircraft {
	private String model;
	private int nbSeats;
	private String code;
	private int capacity;
}

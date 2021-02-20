package sezayir.airportmanagement.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Season {
	
	@Id
	private String id;
	
	private String name;
	
	private String[] months;

}

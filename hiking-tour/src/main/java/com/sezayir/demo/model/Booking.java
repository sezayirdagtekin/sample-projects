package com.sezayir.demo.model;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@EqualsAndHashCode(exclude = {"refrenceName"})
@ToString
public class Booking {
	@NonNull
	private LocalDate date;
	
	@NonNull
	private Hiker hiker;
	
	@NonNull
	private Tour tour;
	
	private String refrenceName; //creator of booking for other hikers
}
package com.sezayir.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.sezayir.demo.model.AgeRange;
import com.sezayir.demo.model.Tour;

@Service
public class TourServiceImpl implements TourService {

	@Override
	public Map<String, Tour> getTours() {
		Tour shire = new Tour();
		shire.setName("Shire");
		shire.setPrice(new BigDecimal(29.90).setScale(2, RoundingMode.DOWN));
		shire.setAgeRange(new AgeRange(5, 100));
		shire.setStart(LocalTime.parse("07:00"));
		shire.setEnd(LocalTime.parse("09:00"));

		Tour gondor = new Tour();
		gondor.setName("Gondor");
		gondor.setPrice(new BigDecimal(59.90).setScale(2, RoundingMode.DOWN));
		gondor.setAgeRange(new AgeRange(11, 50));
		gondor.setStart(LocalTime.parse("10:00"));
		gondor.setEnd(LocalTime.parse("13:00"));

		Tour mordor = new Tour();
		mordor.setName("Mordor");
		mordor.setPrice(new BigDecimal(99.90).setScale(2, RoundingMode.DOWN));
		mordor.setAgeRange(new AgeRange(18, 40));
		mordor.setStart(LocalTime.parse("14:00"));
		mordor.setEnd(LocalTime.parse("19:00"));

		Map<String, Tour> mapTour = Tour.getTours();
		mapTour.put(shire.getName(), shire);
		mapTour.put(gondor.getName(), gondor);
		mapTour.put(mordor.getName(), mordor);
		return mapTour;
	}

}

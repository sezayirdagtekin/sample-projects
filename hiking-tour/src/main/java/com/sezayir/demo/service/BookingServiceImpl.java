package com.sezayir.demo.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sezayir.demo.model.Booking;
import com.sezayir.demo.model.Tour;
import static com.sezayir.demo.util.Constants.NO_RECORD_FOUND;

@Service
public class BookingServiceImpl implements BookingService {

	static Map<LocalDate, Set<Booking>> bookings = new HashMap<>();

	Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Override
	public void createBooking(Booking booking) {

		Set<Booking> bookset = bookings.get(booking.getDate());
		if (bookset == null) {
			bookset = new HashSet<>();
		}
		bookset.add(booking);

		bookings.put(booking.getDate(), bookset);
		logger.info("Hiker created booking:" + booking.toString());
	}

	@Override
	public Set<Booking> getBookings(LocalDate date) {
		return bookings.get(date);
	}

	@Override
	public void cancelBooking(LocalDate date, Tour tour, String name) {
		Set<Booking> bookset = bookings.get(date);
		if (!CollectionUtils.isEmpty(bookset)) {
			Booking booking = bookset.stream().filter(t -> t.getTour().equals(tour))
					.filter(n -> n.getHiker().getName().equalsIgnoreCase(name)).findAny().orElse(null);

			bookset.remove(booking);
			logger.info("Hiker removed booking:" + booking.toString());
			return;
		}
		logger.info(NO_RECORD_FOUND);
	}

	@Override
	public Map<LocalDate, Set<Booking>> getHikerBookings(String name, int age) {
		Map<LocalDate, Set<Booking>> hikersBooking = bookings.entrySet().stream().filter(s -> {
			for (Booking b : s.getValue()) {
				if (name.equalsIgnoreCase(b.getRefrenceName())
						|| (b.getHiker().getName().equalsIgnoreCase(name) && b.getHiker().getAge() == age)) {
					return true;
				}
			}
			return false;
		}).collect(Collectors.toMap(t -> t.getKey(), t -> t.getValue()));

		return hikersBooking;
	}

}

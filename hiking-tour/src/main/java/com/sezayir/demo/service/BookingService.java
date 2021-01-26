package com.sezayir.demo.service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import com.sezayir.demo.model.Booking;
import com.sezayir.demo.model.Tour;

public interface BookingService {
	
	public void createBooking(Booking booking);
	public Map<LocalDate, Set<Booking>>  getHikerBookings(String name, int age);
	public Set<Booking> getBookings(LocalDate date);
	void cancelBooking(LocalDate date, Tour tour, String name);

}

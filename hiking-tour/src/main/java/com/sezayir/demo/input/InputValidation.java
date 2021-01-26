package com.sezayir.demo.input;

import static com.sezayir.demo.util.Utils.isValidDate;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sezayir.demo.model.Tour;
import com.sezayir.demo.service.TourService;

@Component
public class InputValidation {

	@Autowired
	TourService tourService;

	public String getValidDate(Scanner scanner) {
		String date;
		boolean isCorrect = false;
		do {
			System.out.print("Please enter day(eg:2021-02-02) :");
			date = scanner.next();
			isCorrect = isValidDate(date);
			if (!isCorrect) {
				System.out.println("Invalid Date!!!");
			}
		} while (!isCorrect);
		return date;
	}

	public Tour validateTourWithAge(Scanner scanner,int age) {
		String input;
		boolean isValidInput = false;
		Tour tour;
		do {
			System.out.println("Please enter tour name(Shire,Mordor or Gondor): ");
			input = scanner.next();
			tour = tourService.getTours().get(input);
			 if(tour==null) {
				System.out.println("Invalid tour!");
				isValidInput = false;
			}
			 else if (tour!=null && !ageApproved(tour, age)) {
				  System.out.println("Invalid age! Allowable age  for this  tour "+tour.getAgeRange());
					isValidInput = false;
				}	
			 else {
				 isValidInput = true; 
			 }
			 
		} while (!isValidInput);
		return tour;
	}

	public Tour validateTour(Scanner scanner) {

		boolean isValidInput = false;
		Tour tour = null;
		do {
			System.out.println("Please enter tour(Shire,Mordor or Gondor): ");
			tour = tourService.getTours().get(scanner.next());
			if (tour != null) {
				isValidInput = true;
			} else {
				isValidInput = false;
				System.out.println("Invalid tour!");
			}
		} while (!isValidInput);

		return tour;
	}

	
	public int validateAge(Scanner scanner) {

		int age;
		boolean isCorrect = false;
		do {
			System.out.println("Please enter age: ");
			age = scanner.nextInt();

			if (!(age >= 5 && age <= 100)) {
				System.out.println("Invalid age! Age should be in range [5-100]");
			} else {
				isCorrect = true;
			}
		} while (!isCorrect);
		return age;
	}
	
	private  boolean ageApproved(Tour tour,int age) {
			return tour.getAgeRange().contains(age);
	}

}
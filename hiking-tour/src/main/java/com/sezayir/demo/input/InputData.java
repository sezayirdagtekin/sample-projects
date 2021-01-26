package com.sezayir.demo.input;

import static com.sezayir.demo.input.InputMenu.displayCreationMenu;
import static com.sezayir.demo.input.InputMenu.displayMainMenu;
import static com.sezayir.demo.util.Constants.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import com.sezayir.demo.model.Booking;
import com.sezayir.demo.model.Hiker;
import com.sezayir.demo.model.Tour;
import com.sezayir.demo.service.BookingServiceImpl;
import com.sezayir.demo.service.TourService;

@Component
public class InputData {

	@Autowired
	private BookingServiceImpl bookingService;

	@Autowired
	TourService tourService;

	@Autowired
	InputValidation inputValidation;

	Logger logger = LoggerFactory.getLogger(InputData.class);

	public void InputMenu() {

		try (Scanner scanner = new Scanner(System.in)) {

			displayMainMenu();
			String input = "";

			while (!(input = scanner.next()).equalsIgnoreCase(EXIT)) {

				switch (input) {
				case ONE:
					getAllActiveTours();
					break;
				case TWO:
					createBooking(scanner);
					break;

				case THREE:
					cancelBooking(scanner);
					break;

				case FOUR:
					getHikerBookings(scanner);
					break;

				case FIVE:
					getDailyBooking(scanner);
					break;
				default:
					logger.info(INVALID_INPUT);
					break;
				}

			}

		}

		catch (InputMismatchException e) {
			logger.error("Error:!" + e.getStackTrace());
		}
		logger.info("Bye!");
	}

	private void createBooking(Scanner scanner) {

		displayCreationMenu();
		String input = "";

		while (!(input = scanner.next()).equalsIgnoreCase(MAIN_MENU)) {
			switch (input) {
			case ONE:
				createBookYourSelf(scanner);
				break;
			case TWO:
				createBookForOthers(scanner);
				break;

			default:
				logger.info(INVALID_INPUT);
				break;
			}
		}
		displayMainMenu();
	}

	private void getHikerBookings(Scanner scanner) {
		String name = getInputName(scanner);
		System.out.println("Please enter your age: ");
		int age = scanner.nextInt();
		Map<LocalDate, Set<Booking>> bookingMap = bookingService.getHikerBookings(name, age);
		if (!CollectionUtils.isEmpty(bookingMap)) {
			bookingMap.keySet().stream().forEach(key -> System.out.println(key + "=" + bookingMap.get(key)));
		} else {
			System.out.println(NO_RECORD_FOUND);
		}
		displayMainMenu();
	}

	private void getAllActiveTours() {
		System.out.println("All available tours:");
		tourService.getTours().forEach((key, value) -> System.out.println(key + " : " + value));

		displayMainMenu();
	}

	private Hiker collectHikerData(Scanner scanner) {
		Hiker hiker = new Hiker();
		String name = getInputName(scanner);
		int age = inputValidation.validateAge(scanner);
		hiker.setName(name);
		hiker.setAge(age);
		return hiker;
	}

	private void createBookForOthers(Scanner scanner) {
		String condition = "Y";
		System.out.println("Firstly,We will get your information!");
		String hikerCreator = getInputName(scanner);
		while (condition.equalsIgnoreCase("Y")) {
			String date = inputValidation.getValidDate(scanner);
			System.out.println("Next step needs friend's name and age");
			Hiker firend = collectHikerData(scanner);
			Tour tour = inputValidation.validateTourWithAge(scanner, firend.getAge());

			Booking booking = new Booking();
			booking.setTour(tour);
			booking.setHiker(firend);
			booking.setRefrenceName(hikerCreator);
			booking.setDate(LocalDate.parse(date));
			bookingService.createBooking(booking);

			System.out.println("Do you want to make another reservation for your friend?[Y]/[N]");
			condition = scanner.next();
		}
		displayCreationMenu();
	}

	private void createBookYourSelf(Scanner scanner) {
		String condition = "Y";
		Hiker hiker = collectHikerData(scanner);
		while (condition.equalsIgnoreCase("Y")) {
			String date = inputValidation.getValidDate(scanner);
			Tour tour = inputValidation.validateTourWithAge(scanner, hiker.getAge());

			Booking booking = new Booking();
			booking.setTour(tour);
			booking.setHiker(hiker);
			booking.setDate(LocalDate.parse(date));

			bookingService.createBooking(booking);
			System.out.println("Do you want to make another reservation for your self?[Y]/[N]");
			condition = scanner.next();
		}
		displayCreationMenu();
	}

	private void cancelBooking(Scanner scanner) {
		String name = getInputName(scanner);
		String date = inputValidation.getValidDate(scanner);
		Tour tour = inputValidation.validateTour(scanner);
		bookingService.cancelBooking(LocalDate.parse(date), tour, name);
		displayMainMenu();
	}

	private String getInputName(Scanner scanner) {
		System.out.println("please enter name:");
		return scanner.next();
	}

	private void getDailyBooking(Scanner scanner) {
		String date = inputValidation.getValidDate(scanner);
		Set<Booking> bookings = bookingService.getBookings(LocalDate.parse(date));
		if (!CollectionUtils.isEmpty(bookings)) {
			logger.info("List of bookings in date:" + date.toString());
			bookings.stream().forEach(System.out::println);
		} else {
			logger.info(NO_RECORD_FOUND);
		}

		displayMainMenu();
	}

}
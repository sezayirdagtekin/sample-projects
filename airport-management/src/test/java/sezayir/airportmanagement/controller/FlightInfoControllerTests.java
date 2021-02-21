package sezayir.airportmanagement.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import sezayir.airportmanagement.dao.FlightInfoDao;
import sezayir.airportmanagement.domain.FlightInformation;
import sezayir.airportmanagement.domain.FlightType;
import sezayir.airportmanagement.service.FlightInfoService;
import sezayir.airportmanagement.service.SeasonService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = FlightInfoController.class)
class FlightInfoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	FlightInfoService flightInfoService;

	@MockBean
	SeasonService seasonService;

	@MockBean
	FlightInfoDao flightInfoDaof;

	private List<FlightInformation> flights;

	@BeforeEach
	public void setUp() {
		FlightInformation flight = new FlightInformation();
		flight.setId("601a5520bbdd3c32c4a8d6d9");
		flight.setDepartureCity("Istanbul");
		flight.setDestinationCity("Madrid");
		flight.setDelayed(false);
		flight.setType(FlightType.International);
		flights = new ArrayList<>();
		flights.add(flight);
	}

	@Test
	public void findAllWithTemplateTest() throws Exception {

		when(flightInfoService.findAll()).thenReturn(flights);

		mockMvc.perform(get("/flight-info/template/all")).andExpect(status().isOk());

		verify(flightInfoService, times(1)).findAll();

	}
	
	@Test
	public void findByModelUsingRepostioryTest() throws Exception {

		when(flightInfoService.findByType(FlightType.International.toString())).thenReturn(flights);

		mockMvc.perform(get("/flight-info/repository/type/International")).andExpect(status().isOk());

		verify(flightInfoService, times(1)).findByType(FlightType.International.toString());

	}

}

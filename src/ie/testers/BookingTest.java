package ie.lyit.testers;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ie.lyit.flight.*;

public class BookingTest {

	private Passenger passenger1, passenger2;
	private Booking bookingTest;
	private ArrayList<Passenger> passengers = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		passenger1 = new Passenger("Mr", "John", "Smith", 19, 05, 1972, 1, true);
		passenger2 = new Passenger("Mrs", "Alice", "Smith", 02, 03, 1969, 6, true);
		passengers.add(passenger1);
		passengers.add(passenger2);
		bookingTest = new Booking(new Flight ("SD939", "Paris", "Copenhagen", 20, 12, 2018, 10, 50, 39.49),
				new Flight("BR418", "Copenhagen", "Paris", 03, 01, 2019, 13, 45, 19.99), passengers);

	}

	@Test
	public void toStringTest() {
		assertThat (bookingTest.toString(), containsString(
				"Booking{outbound=FLIGHT SD3948, ==> Amsterdam to Miami 26/10/2018 @ 19:45,"
				+ " inbound=FLIGHT SD3949  ==> Miami to Amsterdam 08/12/2018 23:30, "
				+ "passengers=[Mr John Smith, 19/05/1972 ==> 1 bag(s), Priority Boarding is true, "
				+ "Mrs Alice Smith, 02/03/1969  ==> 3 bag(s), Priority Boarding is true], totalPrice=0.0}"));;
	}


	@Test
	public void setOutbound() {
		Flight flight1 = new Flight("SD843", "Berlin", "Germany", 25, 11, 2018, 17, 45, 35.00);
		bookingTest.setOutbound(flight1);
		assertEquals(flight1, bookingTest.getOutbound());
	}

	@Test
	public void setInbound() {
		Flight flight1 = new Flight("SD844", "Berlin", "Germany", 27, 11, 2018, 16, 25, 35.00);
		bookingTest.setInbound(flight1);
		assertEquals(flight1, bookingTest.getInbound());
	}

	@Test
	public void setPassengers() {
		Passenger passenger3 = new Passenger("Mr", "Alexander", "Jones", 13, 04, 1996, 1, true);
		Passenger passenger4 = new Passenger("Ms", "Victoria", "Jones", 21, 06, 1994, 6, true);
		passengers.add(passenger3);
		passengers.add(passenger4);
		assertEquals(passengers, bookingTest.getPassengers());

	}

	@Test
	public void setTotalPrice() {
		bookingTest.setTotalPrice();
		assertEquals(70.00, bookingTest.getTotalPrice(), 0.0001);
	}

	@Test
	public void findPassenger() {
		assertTrue(bookingTest.findPassenger(passenger1));
		assertTrue(!bookingTest.findPassenger(new Passenger("Ms", "Victoria", "Jones", 21, 06, 1994, 1, true)));
	}

	@Test
	public void calculatePrice() {
		assertEquals(70.00, bookingTest.calculatePrice(), .011);
	}
}
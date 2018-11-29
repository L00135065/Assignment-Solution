package ie.lyit.flight;

import java.util.ArrayList;
import java.util.Objects;

public class Booking {

	private Flight inbound;
	private Flight outbound;
	private double totalPrice;
	public static int count;
	private double inboundPrice;
	private double outboundPrice;
	
	private ArrayList<Passenger> passengers = new ArrayList<>();

	public Booking() {
		outbound = null;
		inbound = null;
		totalPrice = 0.0;
		count++;
	}

	public Booking(Flight outbound, Flight inbound, ArrayList<Passenger> passengers) {
		this.outbound = outbound;
		this.inbound = inbound;
		this.passengers = passengers;
		totalPrice = 0.0;
		count++;

	}

	@Override
	public String toString() {
		return "Booking{" + "Outbound=" + outbound + ", Inbound=" + inbound + ", Passengers=" + passengers
				+ ", Total Price=" + totalPrice;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Booking booking = (Booking) obj;
		return Double.compare(booking.totalPrice, totalPrice) == 0 && Objects.equals(outbound, booking.outbound)
				&& Objects.equals(inbound, booking.inbound) && Objects.equals(passengers, booking.passengers);
	}

	
	public Flight getOutbound() {
		return outbound;
	}

	public void setOutbound(Flight outbound) {
		this.outbound = outbound;
	}

	public Flight getInbound() {
		return inbound;
	}

	public void setInbound(Flight inbound) {
		this.inbound = inbound;
	}

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice() {
		this.totalPrice = calculatePrice();
	}

	public boolean findPassenger(Person p) {
		return passengers.contains(p);
	}

	public double calculatePrice() {
		inboundPrice = this.passengers.size() * this.inbound.getPrice();
		outboundPrice = this.passengers.size() * this.outbound.getPrice();
		return inboundPrice + outboundPrice;
	}
}
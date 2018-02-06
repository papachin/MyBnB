
public class Car extends Vehicle {
	private Integer PassengersNumber;
	
	Car () {}
	Car (Integer i, String o, Integer t, Integer r, Integer p) {
		super(i, o, t, r);
		PassengersNumber = p;
	}
	
	// Passenger Numbers
	public Integer getPassengersNumber () {
		return PassengersNumber;
	}
	public void setPassengerNumber (Integer NUM) {
		PassengersNumber = NUM;
	}

	// to string
	public String carData_toString () {
		return ""+this.getVehicleID()+", "
				+this.getOwner()+", "
				+this.getRentalCost()+", "
				+this.getTotalRentalDays()+", "
				+getPassengersNumber()+".";
	}
}

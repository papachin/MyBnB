
public class Truck extends Vehicle {
	private Integer CargoWeight;
	
	Truck () {}
	Truck (Integer i, String o, Integer t, Integer r, Integer c) {
		super(i,o,t,r);
		CargoWeight = c;
	}
	
	// CargoWeight
	public Integer getCargoWeight () {
		return CargoWeight;
	}
	public void setCargoWeight (Integer NUM) {
		CargoWeight = NUM;
	}
	
	// to string
	public String truckData_toString () {
		return ""+this.getVehicleID()+", "
				+this.getOwner()+", "
				+this.getRentalCost()+", "
				+this.getTotalRentalDays()+", "
				+getCargoWeight()+".";
	}
}

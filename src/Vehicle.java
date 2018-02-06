
public class Vehicle implements RentItem {
	private Integer Vehicle_ID;
	private String Owner;
	private Integer TotalRentalDays;
	private Integer RentalCostPerDay;
	
	Vehicle(){}
	Vehicle(Integer i, String O, Integer TC, Integer RC){
		Vehicle_ID = i;
		Owner = O;
		TotalRentalDays = TC;
		RentalCostPerDay = RC;
	}
	
	// vehicle id
	public Integer getVehicleID() {
		return Vehicle_ID;
	}
	public void setVehicleID(Integer NUM) {
		Vehicle_ID = NUM;
	}
	
	// owner
	public String getOwner() {
		return Owner;
	}
	public void setOwner(String STR) {
		Owner = STR;
	}
	
	// rental cost per day
	public Integer getRentalCost() {
		return RentalCostPerDay;
	}
	public void setRentalCost(Integer NUM) {
		RentalCostPerDay = NUM;
	}
	
	// rental days
	public void RentalItem(int RentalDays) {
		TotalRentalDays = RentalDays;
	}
	public Integer getTotalRentalDays () {
		return TotalRentalDays;
	}
}//END
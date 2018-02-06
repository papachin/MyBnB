
public class House_Property extends Property {
	// object variables
	private Integer number_of_storeys;
	private Double clearing_fee;
	
	// object method
	public House_Property () {}
	
	// constructor method
	public House_Property (Integer regNum, String ownerName, String address, Double cost_day, Integer season_days, Integer storeyNum, Double fee) {
		// super the parent class
		super (regNum, ownerName, address, cost_day, season_days);
		
		// child variables
		number_of_storeys = storeyNum;
		clearing_fee = fee;
	}
	
	// data string
	public String housesData_toString () {
		return ""+this.getRegisterNumber()+", "
				+this.getOwner()+", "
				+this.getPostalAddress()+", "
				+this.getRentalCostPerDay()+", "
				+this.getRentalItem()+", "
				+number_of_storeys+", "
				+clearing_fee+".";
	}
	
	// getters and setters
	// Number of Storeys
	public Integer getNumberOfStoreys () {
		return number_of_storeys;
	}
	public String NumberOfStoreys_toString() {
		return ""+number_of_storeys+"";
	}
	public void setNumberOfStoreys (Integer NUM) {
		number_of_storeys = NUM;
	}
	
	// Clearing Fee
	public Double getClearingFee () {
		return clearing_fee;
	}
	public String ClearingFee_toString() {
		return ""+clearing_fee+"";
	}
	public void setClearingFee (Double DBL) {
		clearing_fee = DBL;
	}
}

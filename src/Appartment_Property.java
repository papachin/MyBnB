
public class Appartment_Property extends Property {
	private Integer storey_number;
	private Integer number_of_beds;
	
	// object method
	public Appartment_Property () {}
	
	// constructor method
	public Appartment_Property (Integer regNum, String ownerName, String address, Double cost_day, Integer season_days, Integer storeyNum, Integer numBeds) {
		// super the parent variables
		super (regNum, ownerName, address, cost_day, season_days);
		
		// create child variables
		storey_number = storeyNum;
		number_of_beds = numBeds;
	}
	
	// data string
	public String apartmentData_toString () {
		return ""+this.getRegisterNumber()+", "
				+this.getOwner()+", "
				+this.getPostalAddress()+", "
				+this.getRentalCostPerDay()+", "
				+this.getRentalItem()+", "
				+storey_number+", "
				+number_of_beds+".";
	}
	
	// getters and setters
	// Storey Numbers
	public Integer getStoreyNumber () {
		return storey_number;
	}
	public String StoreyNumber_toString() {
		return ""+storey_number+"";
	}
	public void setStoreyNumber (Integer NUM) {
		storey_number = NUM;
	}
	
	// Number Of Beds
	public Integer getNumberOfBeds () {
		return number_of_beds;
	}
	public String NumberOfBeds_toString() {
		return ""+number_of_beds+"";
	}
	public void setNumberOfBeds (Integer NUM) {
		number_of_beds = NUM;
	}
	
}

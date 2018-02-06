
public class Property implements RentItem {
	private Integer unique_register_number; 
	private String owner_name; 
	private String postal_address;
	private Double rental_cost_per_day; 
	private Integer total_number_of_seasons_rental_days;
	
	// object method
	public Property() {}
	
	// Constructor method
	public Property (Integer regNum, String ownerName, String address, Double cost_day, Integer season_days) {
		unique_register_number = regNum;
		owner_name = ownerName;
		postal_address = address;
		rental_cost_per_day = cost_day;
		total_number_of_seasons_rental_days = season_days;
	}
	
	// getter and setters
	// Unique Register Number
	public Integer getRegisterNumber () {
		return unique_register_number;
	}
	public String RegisterNumber_toString() {
		return ""+unique_register_number+"";
	}
	public void setRegisterNumber (Integer NUM) {
		unique_register_number = NUM;
	}
	
	// Owner's Name
	public String getOwner () {
		return owner_name;
	}
	public void setOwner (String STR) {
		owner_name = STR;
	}
	
	// Postal Address
	public String getPostalAddress () {
		return postal_address;
	}
	public void setPostalAddress (String STR) {
		postal_address = STR;
	}
	
	// Rental Cost Per Day
	public Double getRentalCostPerDay () {
		return rental_cost_per_day;
	}
	public String RentalCostPerDay_toString() {
		return ""+rental_cost_per_day+"";
	}
	public void setRentalCostPerDay (Double DBL) {
		rental_cost_per_day = DBL;
	}
	
	// Total Number Of Seasons Rental Days
	public void RentalItem (int RentalDays) {
		total_number_of_seasons_rental_days = RentalDays;
	}
	public Integer getRentalItem () {
		return total_number_of_seasons_rental_days;
	}
}//END

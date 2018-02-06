
public class Luxury_Villa_Property extends Property {
	// object variables
	private Integer total_number_of_rooms;
	private Double room_service_cost_per_day;
	private Double luxury_tax_per_day;
	
	// object method
	public Luxury_Villa_Property () {}
	
	// Constructor method
	public Luxury_Villa_Property (Integer regNum, String ownerName, String address, Double cost_day, Integer season_days, Integer roomsNum, Double cost, Double tax) {
		// super parent variables
		super (regNum, ownerName, address, cost_day, season_days);
		
		// create child variables
		total_number_of_rooms = roomsNum;
		room_service_cost_per_day = cost;
		luxury_tax_per_day = tax;
	}
	
	// data string
	public String villaData_toString () {
		return ""+this.getRegisterNumber()+", "
				+this.getOwner()+", "
				+this.getPostalAddress()+", "
				+this.getRentalCostPerDay()+", "
				+this.getRentalItem()+", "
				+total_number_of_rooms+", "
				+room_service_cost_per_day+", "+
				+luxury_tax_per_day+".";
	}
	
	// getters and setters
	// Number of Rooms
	public Integer getTotalNumberOfRooms () {
		return total_number_of_rooms;
	}
	public String TotalNumberOfRooms_toString() {
		return ""+total_number_of_rooms+"";
	}
	public void setTotalNumberOfRooms (Integer NUM) {
		total_number_of_rooms = NUM;
	}
	
	// Service Cost
	public Double getRoomSeriveCostPerDay () {
		return room_service_cost_per_day;
	}
	public String RoomSeriveCostPerDay_toString() {
		return ""+room_service_cost_per_day+"";
	}
	public void setRoomSeriveCostPerDay (Double DBL) {
		room_service_cost_per_day = DBL;
	}
	
	// Tax
	public Double getLuxuryTaxPerDay () {
		return luxury_tax_per_day;
	}
	public String LuxuryTaxPerDay_toString() {
		return ""+luxury_tax_per_day+"";
	}
	public void setLuxuryTaxPerDay (Double DBL) {
		luxury_tax_per_day = DBL;
	}
	
}

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MyBnB {
	// lists to store data
	private static List<House_Property> houses;
	private static List<Appartment_Property> apartments;
	private static List<Luxury_Villa_Property> villas;
	private static List<Car> cars;
	private static List<Truck> trucks;
	
	// sort printing value
	private static PrintStream printer = System.out;
	
	// data integers
	private static Integer item_ID;
	private static Integer item_Days;
	
	// text files
	private static String file_input = "InputProperty.txt";
	private static String file_output = "OutputProperty.txt";
	private static String file_vehicle_input = "InputVehicle.txt";
	private static String file_vehicle_output = "OutputVehicle.txt";
	private static String FILE_PATH = "C:\\Users\\thego\\Desktop\\MSc\\";
	
	
	// main method
	public static void main (String [] args) {
		// Read input files
		ReadInputPropertyFile();
		ReadInputVehicleFile();
		
		// run user interface
		run_UI();
		
	}
	
	
	// Initiates UI and handles IO
	public static void run_UI () {
        SwingUtilities.invokeLater (new Runnable () {
            public void run () {
            	
            	// Frame and control panel
            	JFrame frame = new JFrame("MyBnB");
            	
            	// Property rent
            	MyBnB_UI property_panel = new MyBnB_UI();
            	frame.getContentPane().add(property_panel, BorderLayout.NORTH);
               
            	// property panel control
            	JButton b1 = property_panel.btn_confirm;
            	JTextField t1 = property_panel.tf_ID;
            	JTextField t2 = property_panel.tf_days;
            	
            	// Vehicle Rent
            	MyVehicle_UI vehicle_panel = new MyVehicle_UI();
            	frame.getContentPane().add(vehicle_panel, BorderLayout.CENTER);
            	// vehicle panel control
            	JButton b2 = vehicle_panel.btn_confirm;
            	JTextField t3 = vehicle_panel.tf_ID;
            	JTextField t4 = vehicle_panel.tf_days;
            	
            	// confirmation button
            	JPanel control_panel = new JPanel();
            	JButton b3 = new JButton("Confirm");
            	control_panel.add(b3);
            	frame.getContentPane().add(control_panel, BorderLayout.SOUTH);
               
	            // rent button for properties
	       		b1.addActionListener(new ActionListener(){
	       			public void actionPerformed(ActionEvent ae){
	       				// gets text values and converts to correct data
	       				item_ID = Integer.valueOf(t1.getText());
	       				item_Days = Integer.valueOf(t2.getText());
	       				
	       				// searches properties for ID
	       				searchPropertyList(item_ID, item_Days);
	       				
	       				
	       			}

	       		});
	       		
	       		// rent button for vehicles
	       		b2.addActionListener(new ActionListener(){
	       			public void actionPerformed(ActionEvent ae){
	       				// gets text values and converts to correct data
	       				item_ID = Integer.valueOf(t3.getText());
	       				item_Days = Integer.valueOf(t4.getText());
	       				
	       				// searches properties for ID
	       				searchVehicleList(item_ID, item_Days);
	       			}
	       		});
	       		
	       		// confirm button
	       		b3.addActionListener(new ActionListener(){
	       			public void actionPerformed(ActionEvent ae){
	       				// calculates total income
	       				CalculateTotalPropertyIncome();
	       				CalculateTotalVehicleIncome();
	       				
	       				// print all rental items
	       				printAllProperties();
	       				printAllVehicles();
	       			}
	       		});
	       		
	                
	            //j frame variables
	       		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       		frame.setLocationRelativeTo(null);
	       		frame.pack();
	       		frame.setVisible(true);
            }
        });
	}
	
	
	// search method
	private static void searchPropertyList(Integer item_ID, Integer item_Days) {
		// searches house array for data
		for (House_Property h: houses) {
			if(h.getRegisterNumber() == item_ID) {
				// gets current number
				Integer old_num = h.getRentalItem();
				// adds days amount and sets it
				Integer new_num = old_num + item_Days;
				h.RentalItem(new_num);
				
				// tester
				printer.println ("new:"+h.housesData_toString());
			}
		}
		
		// searches apartment array for data
		for (Appartment_Property a: apartments) {
			if(a.getRegisterNumber() == item_ID) {
				// gets current number
				Integer old_num = a.getRentalItem();
				// adds days amount and sets it
				Integer new_num = old_num + item_Days;
				a.RentalItem(new_num);
				
				// tester
				printer.println ("new:"+a.apartmentData_toString());
			}
		}
		
		// searches villa array for data
		for (Luxury_Villa_Property v: villas) {
			if(v.getRegisterNumber() == item_ID) {
				// gets current number
				Integer old_num = v.getRentalItem();
				// adds days amount and sets it
				Integer new_num = old_num + item_Days;
				v.RentalItem(new_num);
				
				// tester
				printer.println ("new:"+v.villaData_toString());
			}
		}
	}
	
	
	// reads text file
	@SuppressWarnings("resource")
	public static void ReadInputPropertyFile () {
		// token array
		String[] tokens;
		
		// create lists
		houses = new ArrayList<House_Property>();
		apartments = new ArrayList<Appartment_Property>();
		villas = new ArrayList<Luxury_Villa_Property>();
		
		try {
			// file import reading with utf-8
			BufferedReader input = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(FILE_PATH+""+file_input),"UTF-8"));
			
			// scanner to read file data
			Scanner scan = new Scanner(input);
			
			// process data
			while(scan.hasNextLine()) {
				
				// scans next line
				String wrd = scan.nextLine();
				
				// add data to correct lists
				if(wrd.startsWith("1")) {
					// Houses
					// splits line into tokens
					tokens = wrd.split(" ", 8);
					
					// converts data and adds to list
					houses.add(new House_Property(
					Integer.valueOf(tokens[1]),tokens[2],tokens[3],
					Double.valueOf(tokens[4]),Integer.valueOf(tokens[5]),
					Integer.valueOf(tokens[6]),Double.valueOf(tokens[7]) ) );
					
				} else if (wrd.startsWith("2")) {
					// Apartments
					// splits line into tokens
					tokens = wrd.split(" ", 8);
					
					// converts data and adds to list
					apartments.add(new Appartment_Property(Integer.valueOf(tokens[1]),tokens[2],tokens[3],
					Double.valueOf(tokens[4]),Integer.valueOf(tokens[5]),
					Integer.valueOf(tokens[6]),Integer.valueOf(tokens[7])) );
					
				} else if (wrd.startsWith("3")) {
					// Villas
					// splits line into tokens
					tokens = wrd.split(" ", 9);
					
					// converts data and adds to list
					villas.add(new Luxury_Villa_Property(
					Integer.valueOf(tokens[1]),tokens[2],tokens[3],Double.valueOf(tokens[4]),
					Integer.valueOf(tokens[5]),Integer.valueOf(tokens[6]),Double.valueOf(tokens[7]), 
					Double.valueOf(tokens[8]) ) );
				}
			}
			
			// close file stream
			input.close();
		} catch(Exception ex) {
			// exception handle
			printer.println(ex.getMessage());
		}
	}
	
	
	
	//==================================================
	//ReadInputVehicleFile 
	@SuppressWarnings("resource")
	public static void ReadInputVehicleFile () {
		// token array
		String[] tokens;
		
		// create lists
		cars = new ArrayList<Car>();
		trucks = new ArrayList<Truck>();
		
		try {
			// file import reading with utf-8
			BufferedReader input = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(FILE_PATH+""+file_vehicle_input),"UTF-8"));
			
			// scanner to read file data
			Scanner scan = new Scanner(input);
			
			// process data
			while(scan.hasNextLine()) {
				
				// scans next line
				String wrd = scan.nextLine();
				
				// add data to correct lists
				if(wrd.startsWith("1")) {
					// Cars
					// splits line into tokens
					tokens = wrd.split(" ", 6);
					
					// converts data and adds to list
					cars.add(new Car(Integer.valueOf(tokens[1]), tokens[2],
							Integer.valueOf(tokens[3]),Integer.valueOf(tokens[4]),
							Integer.valueOf(tokens[5]) ));
					
				} else if (wrd.startsWith("2")) {
					// Trucks
					// splits line into tokens
					tokens = wrd.split(" ", 6);
					
					// converts data and adds to list
					trucks.add(new Truck(Integer.valueOf(tokens[1]), tokens[2],
							Integer.valueOf(tokens[3]),Integer.valueOf(tokens[4]),
							Integer.valueOf(tokens[5]) ));
					
				}
			}
			
			// close file stream
			input.close();
		}catch(Exception ex) {printer.println(ex.getMessage());}
	}
	
	//allows Rental of Vehicles
	public static void searchVehicleList (Integer item_ID, Integer item_Days) {
		Integer special_offer = 1;
		// searches car array for data
		for (Car c: cars) {
			if(c.getVehicleID() == item_ID) {
				// gets current number
				Integer old_num = c.getTotalRentalDays();
				
				// special offer
				if (item_Days >= 3) {
					item_Days = item_Days - special_offer;
				}
				
				// adds days amount and sets it
				Integer new_num = old_num + item_Days;
				c.RentalItem(new_num);
				
				// tester
				printer.println ("new:"+c.carData_toString());
			}
		}
		
		// searches truck array for data
		for (Truck t: trucks) {
			if(t.getVehicleID() == item_ID) {
				// gets current number
				Integer old_num = t.getTotalRentalDays();
				// adds days amount and sets it
				Integer new_num = old_num + item_Days;
				t.RentalItem(new_num);
				
				// tester
				printer.println ("new:"+t.truckData_toString());
			}
		}
	}
	
	
	// ============================================================
	// printers
	
	// prints all the properties
	public static void printAllProperties () {
		// array to store printing values
		ArrayList<String> printer_array = new ArrayList<>();
		
		// adds all houses to printing array
		for (House_Property h: houses) {
			printer_array.add(h.housesData_toString());
		}
		// adds all apartments to printing array
		for (Appartment_Property a: apartments) {
			printer_array.add(a.apartmentData_toString());
		}
		// adds all villas to printing array
		for (Luxury_Villa_Property v: villas) {
			printer_array.add(v.villaData_toString());
		}
		
		// create text file
		// writer
		File file;
		FileWriter fw;
			
		// writing try/catch block
		try {
			file = new File(FILE_PATH+""+file_output);
			fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw); 
			   
			// writes data to file
			for(String lst: printer_array) {
			    writer.write(lst);// write string
			    writer.newLine();// new line
			    writer.flush();// flush buffer
			}
			
			// closes writer
			writer.close();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	//PrintAllVehicles
	public static void printAllVehicles () {
		ArrayList<String> printer_array = new ArrayList<>();
		// adds all houses to printing array
		for (Car c: cars) {
			printer_array.add(c.carData_toString());
		}
		// adds all apartments to printing array
		for (Truck t: trucks) {
			printer_array.add(t.truckData_toString());
		}
		
		// create text file
	    // writer
		File file;
		FileWriter fw;
		
		// writing try/catch block
		try {
			file = new File(FILE_PATH+""+file_vehicle_output);
			fw = new FileWriter(file);
		    BufferedWriter writer = new BufferedWriter(fw); 

		    // writes data to file
		    for(String lst: printer_array) {
		    	writer.write(lst);// write string
		    	writer.newLine();// new line
		        writer.flush();// flush buffer
		    }
		    
		    // closes writer
		    writer.close();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	
	//==================================================
	// calculators
	
	// gets income totals
	public static void CalculateTotalPropertyIncome () {
		// totals variables
		Double house_tax = 0.0, house_income = 0.0;
		Double apartment_income = 0.0;
		Double villa_tax = 0.0, villa_income = 0.0;
		Double total_income = 0.0;
		printer.println("\n---------Property Income---------");
		printer.println("-------Houses-------");
		for (House_Property h: houses) {
			house_tax = house_tax + h.getClearingFee();
			house_income = house_income +
					(h.getRentalItem() * h.getRentalCostPerDay());
		}
		printer.println("House Extas = €"+house_tax);
		printer.println("House Total = €"+house_income);
		
		// prints all apartments
		printer.println("-------Apartments-------");
		for (Appartment_Property a: apartments) {
			apartment_income = apartment_income + 
					(a.getRentalItem() * a.getRentalCostPerDay());
		}
		printer.println("Apartment Total = €"+apartment_income);
		
		// prints all villas
		printer.println("-------Villas-------");
		for (Luxury_Villa_Property v: villas) {
			villa_tax = villa_tax + v.getLuxuryTaxPerDay() + v.getRoomSeriveCostPerDay();
			villa_income = villa_income +
					(v.getRentalItem() *
					(v.getRentalCostPerDay() + v.getLuxuryTaxPerDay() + v.getRoomSeriveCostPerDay()) );
		}
		printer.println("Villa Extra = €"+villa_tax);
		printer.println("Villa Total = €"+villa_income);
		
		// totals
		printer.println("-------Total Income-------");
		total_income = house_income+apartment_income+villa_income;
		printer.println("Total = €"+total_income);
		printer.println("-----------------------------");
		
	}
	
	// gets Vehicle income total
	public static void CalculateTotalVehicleIncome () {
		Integer truck_income = 0, car_income = 0, total_income = 0;
		
		printer.println("\n---------Vehicle Income---------");
		printer.println("-------Car Income-------");
		for (Car c: cars) {
			car_income = (c.getRentalCost() * c.getTotalRentalDays());
		}
		printer.println("Car Total = €"+car_income);
		
		printer.println("-------Truck Income-------");
		for (Truck t: trucks) {
			truck_income = ((t.getRentalCost() + t.getCargoWeight()) * t.getTotalRentalDays());
		}
		printer.println("Truck Total = €"+truck_income);
		
		printer.println("-------Total Income-------");
		total_income = car_income + truck_income;
		printer.println("Total = €"+total_income);
		printer.println("---------------------------------");
		
	}
}//END
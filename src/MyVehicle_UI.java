import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MyVehicle_UI extends JPanel{
	
	// data variables
	public Integer rtn_id;
	public Integer rtn_day;
	
	// buttons
	public JButton btn_confirm = new JButton("Rent");
	
	// text fields
	public JTextField tf_ID = new JTextField("",5);
	public JTextField tf_days = new JTextField("",5);
	
	// labels
	private JLabel lbl1 = new JLabel("Vehicle ID: ");
	private JLabel lbl2 = new JLabel("Rental Days: ");
	

	// panel controls
	public MyVehicle_UI () {
		
		// predefine text
		tf_ID.setText("0");
		tf_days.setText("0");
		
		// add items to pane
		// id
		add(lbl1);
		add(tf_ID);
		
		// days
		add(lbl2);
		add(tf_days);
		
		// buttons
		add(btn_confirm);

	}
}//END
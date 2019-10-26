import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WaterTank {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private JButton btnExit;
	private JTextArea txtWaterLevel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaterTank window = new WaterTank();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WaterTank() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(65, 105, 225));
		frame.setBounds(100, 100, 562, 217);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setBounds(7, 7, 322, 40);
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				 if (e.getKeyCode() == KeyEvent.VK_ENTER) solveAdd();
				 if (e.getKeyCode() == KeyEvent.VK_DELETE) solveRemove();
			}
		});
		frame.getContentPane().setLayout(null);
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("Add Water");
		btnAdd.setBounds(333, 7, 97, 40);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				solveAdd();
			}
		});
		frame.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("Remove Water");
		btnRemove.setBounds(434, 7, 105, 40);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				solveRemove();
			}
		});
		frame.getContentPane().add(btnRemove);
		
		textArea = new JTextArea();
		textArea.setBounds(7, 51, 532, 93);
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		frame.getContentPane().add(textArea);
		textArea.setText(display());
		
		txtWaterLevel = new JTextArea();
		txtWaterLevel.setBounds(7, 148, 423, 23);
		txtWaterLevel.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(txtWaterLevel);
		waterPercentage();
		
		

		
		btnExit = new JButton("Exit");
		btnExit.setBounds(434, 148, 105, 23);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnExit);
	}
	
	  float level = (float) 0.00;     
	  public void watertank(){  level = 10000;   }
	  public void addWater(float gallons) {  level = level + gallons;   }
	  public void removeWater(float gallons) { level = level - gallons;  }
	  public float currentLevel() { return level; }
	  public boolean isFull() {  if (level == 10000)   return true;   else return false;   }
	  public boolean isEmpty() {  if (level == 0.00)   return true;   else return false;   }
	  public void solveAdd() {
			 float gallons = Float.parseFloat(textField.getText());
				if (gallons+currentLevel()>10000) {
					textArea.setText("Water tank will overflow. You exceed the limit.");
				}else {
					addWater(gallons);
					textArea.setText(display());
					}
				waterPercentage();
	  }
	  public void solveRemove() {
			  float gallons = Float.parseFloat(textField.getText());
				if (currentLevel() - gallons < 0) {
					 textArea.setText("No more water in the tank.");
				}else {
					removeWater(gallons);
					textArea.setText(display());
					}
				waterPercentage();
	  }
	  public void waterPercentage() {double percent = ((currentLevel()/10000)*100);
	  	txtWaterLevel.setText("Water Level:"+String.format("%.2f", percent)+"%");
	  	if (percent<=100.00) {txtWaterLevel.setBackground(Color.green);}
	  	if (percent<=70.00) {txtWaterLevel.setBackground(new Color(154,205,50));}
	  	if (percent<=50.00) {txtWaterLevel.setBackground(Color.yellow);}
	  	if (percent<=30.00) {txtWaterLevel.setBackground(Color.orange);}
	  	if (percent<=10.00) {txtWaterLevel.setBackground(Color.red);}
	  }
	  public String display() {return "Water Tank Maximum Capacity\t: 10,000 gallons of Water\n"
				+ "Water Tank Current Level\t: "+ currentLevel()+ " gallons of water\n"
				+ "Water Tank Empty\t\t: "+ isEmpty()+"\n"
				+ "Water Tank Full\t\t\t: " + isFull();}

}


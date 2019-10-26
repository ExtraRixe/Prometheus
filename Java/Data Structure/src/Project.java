import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


class $Student{
	$Student(){
		JOptionPane.showMessageDialog(null, "Student has logged in!","Login Confirmation",JOptionPane.WARNING_MESSAGE);
	}
}
class $Faculty{
	$Faculty(){
		JOptionPane.showMessageDialog(null, "Faculty has logged in!","Login Confirmation",JOptionPane.WARNING_MESSAGE);
	}
}
class $Maintenance{
	$Maintenance(){
		JOptionPane.showMessageDialog(null, "Maintenance has logged in!","Login Confirmation",JOptionPane.WARNING_MESSAGE);
	}
}

public class Project {

	private JFrame frmLogInCounter;
	private JLabel lblClock;
	private JLabel lblDate;
	private JTextArea textAreaDisplay;
	private JComboBox<Object> comboBoxHistory;
	private ArrayList<Object> mylist = new ArrayList<Object>();
	private ArrayList<Object> copylist = new ArrayList<Object>();
	private ArrayList<String> dateHistory = new ArrayList<String>();
	private ArrayList<String> dateHistory_copy = new ArrayList<String>();
	private JMenuBar menuBar;
	private JMenu mnEdit;
	private JMenuItem mntmUndo;
	private JMenuItem mntmReset;





	public void clock() {

		Thread clock = new Thread() {

			public void run() {
				try {
					for(;;) {
						Calendar cal = new GregorianCalendar();
						int hour = cal.get(Calendar.HOUR);
						int minute = cal.get(Calendar.MINUTE);
						int second = cal.get(Calendar.SECOND);
						String htemp = "";
						String mtemp = "";
						String stemp = "";

						if (hour<10) {
							htemp = "0"+hour;
						}else htemp = Integer.toString(hour);

						if (hour==00) {
							htemp = "12";
						}else htemp = Integer.toString(hour);

						if (minute<10) {
							mtemp = "0"+minute;
						}else mtemp = Integer.toString(minute);

						if (second<10) {
							stemp = "0"+second;
						}else stemp = Integer.toString(second);


						lblClock.setText(htemp+":"+mtemp+":"+stemp);
						buttonEnable();
						sleep(1000); }
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};

		clock.start();

	}
	public void date() {
		Calendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);


		lblDate.setText((month+1)+"/"+day+"/"+year);

	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project window = new Project();
					window.frmLogInCounter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Project() {
		initialize();
		clock();
		date();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogInCounter = new JFrame();
		frmLogInCounter.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					undo();
				}
			}
		});
		frmLogInCounter.setTitle("Log in Counter");
		frmLogInCounter.setBounds(100, 100, 450, 313);
		frmLogInCounter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogInCounter.setLocationRelativeTo(null);
		frmLogInCounter.getContentPane().setLayout(new MigLayout("", "[116px][4px][119px][4px][57px][4px][61px][4px][51px]", "[31px][4px][14px][81px][95px][23px]"));

		JLabel lblNewLabel = new JLabel("Login Counter");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmLogInCounter.getContentPane().add(lblNewLabel, "cell 0 0 3 3,grow");

		lblClock = new JLabel("##:##");
		lblClock.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblClock.setHorizontalAlignment(SwingConstants.CENTER);
		frmLogInCounter.getContentPane().add(lblClock, "cell 4 0 5 1,grow");

		lblDate = new JLabel("New label");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		frmLogInCounter.getContentPane().add(lblDate, "cell 4 2 5 1,growx,aligny top");

		JButton btnS = new JButton("Student");
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (login()!=null) {
					mylist.add(new $Student());
					dateHistory.add(0,lblClock.getText()+" "+lblDate.getText());
					textAreaDisplay.setText(display(mylist));
					history();

				}
			}
		});
		frmLogInCounter.getContentPane().add(btnS, "cell 0 3,grow");

		JButton btnF = new JButton("Faculty");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (login()!=null) {
					mylist.add(new $Faculty());
					dateHistory.add(0,lblClock.getText()+" "+lblDate.getText());
					textAreaDisplay.setText(display(mylist));
					history();
				}
			}
		});
		frmLogInCounter.getContentPane().add(btnF, "cell 2 3,grow");

		JButton btnM = new JButton("Maintenance");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (login()!=null) {
					mylist.add(new $Maintenance());
					dateHistory.add(0,lblClock.getText()+" "+lblDate.getText());
					textAreaDisplay.setText(display(mylist));
					history();
				}
			}
		});
		frmLogInCounter.getContentPane().add(btnM, "cell 4 3 5 1,grow");

		textAreaDisplay = new JTextArea();
		textAreaDisplay.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaDisplay.setEditable(false);
		frmLogInCounter.getContentPane().add(textAreaDisplay, "cell 0 4 9 1,grow");

		comboBoxHistory = new JComboBox<Object>();
		comboBoxHistory.setModel(new DefaultComboBoxModel(new String[] {"History"}));
		frmLogInCounter.getContentPane().add(comboBoxHistory, "cell 0 5 7 1,growx,aligny bottom");

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frmLogInCounter.getContentPane().add(btnExit, "cell 8 5,alignx left,aligny top");

		menuBar = new JMenuBar();
		frmLogInCounter.setJMenuBar(menuBar);

		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		mntmUndo = new JMenuItem("Undo");
		mntmUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
						JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
					undo();
				} else {
					// no option
				}
			}
		});
		mnEdit.add(mntmUndo);

		mntmReset = new JMenuItem("Reset");
		mntmReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
						JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
					reset();
				} else {
					// no option
				}
			}
		});
		mnEdit.add(mntmReset);
	}


	static String display(ArrayList<Object> mylist){
		int a = 0,b = 0,c = 0;
		for(int i = 0; i < mylist.size(); i++){
			Object element=mylist.get(i);
			if(element instanceof $Student )
				a++;
			if(element instanceof $Faculty)
				b++;
			if(element instanceof $Maintenance)
				c++;
		}
		String ret = "Students: "+Integer.toString(a)+"\nFaculty: "+ Integer.toString(b)+"\nMaintenance: "+ Integer.toString(c);
		return ret;
	}

	void history() {
		ArrayList<String> history = new ArrayList<String>();
		comboBoxHistory.removeAllItems();
		String hold="";
		for (int i = 0; i < mylist.size(); i++) {
			if (mylist.get(i).toString().contains("Student")) {
				hold = "Student";
			}
			if (mylist.get(i).toString().contains("Faculty")) {
				hold = "Faculty";
			}
			if (mylist.get(i).toString().contains("Maintenance")) {
				hold = "Maintenance";
			}
			history.add(0, hold);
		}
		for (int i = 0; i < history.size(); i++) {
			comboBoxHistory.addItem(history.get(i)+"    "+dateHistory.get(i));
		}
	}

	void buttonEnable() {
		if (textAreaDisplay.getText().isEmpty()) {
			mntmUndo.setEnabled(false);
			mntmReset.setEnabled(false);
		}else {
			mntmUndo.setEnabled(true);
			mntmReset.setEnabled(true);
		}
	}

	void undo() {
		if (mylist.size()==0) {
			mylist = copylist;
			dateHistory = dateHistory_copy; 
			textAreaDisplay.setText(display(mylist));
		} else {
			mylist.remove(mylist.size()-1);
			dateHistory.remove(dateHistory.size()-1);

		}
		textAreaDisplay.setText(display(mylist));
		history();
	}

	void reset() {
		if (mylist.isEmpty()) {

		} else {
			copylist = (ArrayList<Object>) mylist.clone();
			dateHistory_copy = (ArrayList<String>) dateHistory.clone();
			mylist.clear();
			dateHistory.clear();
			textAreaDisplay.setText(display(mylist));
			history();
		}
	}

	String login() {
		String r = "";
		String id = (String) JOptionPane.showInputDialog(null, "Enter your ID number", "Login");
		if (id == null) {
			return null;
		} else {
			for (int i = 0; i < id.length(); i++) {
				if (!Character.isDigit(id.charAt(i))||id.length()<=5) {
					JOptionPane.showMessageDialog(null, "Enter a valid ID number","Error",JOptionPane.ERROR_MESSAGE);
					r = null;
					break;
				}else {
					r = id;
				}
			}
		}
		return r;
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ClearCircularQueue {

	private JFrame frmStackarrayImplementtaion;
	private JTextField entryField;
	private JTextPane mainField;
	private JTextPane statusField;
	private JLabel lblStatus;
	private JButton btnExit;
	private JScrollPane scrollPane;
	//
	static int a[];  
	int i,front=0,rear=0;
	static int n;
	int item;
	int count=0;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						n=Integer.parseInt(JOptionPane.showInputDialog("Enter the limit"));  
						a=new int[n];  

					
					ClearCircularQueue window = new ClearCircularQueue();
					window.frmStackarrayImplementtaion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	 
	/**
	 * Create the application.
	 */
	public ClearCircularQueue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
   
	private void initialize() {
		frmStackarrayImplementtaion = new JFrame();
		frmStackarrayImplementtaion.setTitle("Clear Circular Queue");
		frmStackarrayImplementtaion.setBounds(100, 100, 456, 270);
		frmStackarrayImplementtaion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStackarrayImplementtaion.getContentPane().setLayout(null);
		
		entryField = new JTextField();
		entryField.setBounds(10, 13, 68, 30);
		frmStackarrayImplementtaion.getContentPane().add(entryField);
		entryField.setColumns(10);
		
		JButton btnEnqueue = new JButton("Enqueue");
		btnEnqueue.setBounds(88, 13, 108, 30);
		btnEnqueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enqueue();
				display();
				entryField.setText("");
			}
		});
		frmStackarrayImplementtaion.getContentPane().add(btnEnqueue);
		
		JButton btnDequeue = new JButton("Dequeue");
		btnDequeue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dequeue();
				display();
			}
		});
		btnDequeue.setBounds(206, 13, 108, 30);
		frmStackarrayImplementtaion.getContentPane().add(btnDequeue);
		
		mainField = new JTextPane();
		mainField.setBounds(10, 50, 420, 127);
		mainField.setEditable(false);
		frmStackarrayImplementtaion.getContentPane().add(mainField);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 188, 283, 35);
		frmStackarrayImplementtaion.getContentPane().add(scrollPane);
		
		statusField = new JTextPane();
		scrollPane.setViewportView(statusField);
		
		lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 188, 42, 35);
		frmStackarrayImplementtaion.getContentPane().add(lblStatus);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(339, 188, 91, 35);
		frmStackarrayImplementtaion.getContentPane().add(btnExit);
	}
	
	  void enqueue()    {  
	   try     {  
	   if(count<n)     {  
	    item=Integer.parseInt(entryField.getText()); 
	    a[rear]=item;  
	     rear++;  
	    count++;  
	    }  
	   else  
	    statusField.setText("QUEUE IS FULL");  
	   }  
	  catch(Exception e)     {  
	   System.out.println(e.getMessage());  
	   }  
	  }  
	  void dequeue()    {  
	   if(count!=0)      {  
	    statusField.setText("The item deleted is:"+a[front%n]);  
	    front++;  
	    count--;  
	    }  
	   else  
		statusField.setText("QUEUE IS EMPTY");
	   	mainField.setText("");
	  if(rear==n)  
	   rear=rear%n;  
	  }  

	  void display()    {
	   String temp = "";
	   int m=0;  
	   if(count==0)  
	   statusField.setText("QUEUE IS EMPTY");  
	   else     {  
	   for(i=front;m<count;i++,m++) {
		  temp += " "+a[i%n];
	   }
	   mainField.setText(temp); 

	   
	   }  	 
	  }
}

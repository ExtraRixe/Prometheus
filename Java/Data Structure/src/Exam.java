import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exam {

	private JFrame frmStackToBinary;
	private JTextArea textAreaMain;
	private JTextArea textAreaBinary;
	private JTextField textField;
	private JTextField textFieldStatus;
	private static int arr[];
	private static String bin[];
	private static int top;
	private static int capacity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					arr = new int[Integer.parseInt(JOptionPane.showInputDialog("Enter Stack size"))];
					bin = new String[arr.length];
					capacity = arr.length;
					top = -1;
					Exam window = new Exam();
					window.frmStackToBinary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Exam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStackToBinary = new JFrame();
		frmStackToBinary.setTitle("Stack to Binary");
		frmStackToBinary.setBounds(100, 100, 450, 300);
		frmStackToBinary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStackToBinary.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(7, 7, 177, 23);
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		frmStackToBinary.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnPush = new JButton("Push");
		btnPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isFull()) {
					push(Integer.parseInt(textField.getText()));
				} else {
					textFieldStatus.setText("WARNING: Stack Overflow");
				}
				display();
				
			}
		});
		btnPush.setBounds(188, 7, 118, 23);
		frmStackToBinary.getContentPane().add(btnPush);
		
		JButton btnPop = new JButton("Pop");
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isEmpty()) {
					pop();
				} else {
					textFieldStatus.setText("WARNING: Stack Underflow");
				}
				display();
			}
		});
		btnPop.setBounds(314, 7, 113, 23);
		frmStackToBinary.getContentPane().add(btnPop);
		
		textAreaMain = new JTextArea();
		textAreaMain.setBounds(7, 55, 420, 82);
		textAreaMain.setEditable(false);
		frmStackToBinary.getContentPane().add(textAreaMain);
		
		JLabel lblBinaryValue = new JLabel("Binary Value");
		lblBinaryValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblBinaryValue.setBounds(129, 141, 177, 14);
		frmStackToBinary.getContentPane().add(lblBinaryValue);
		
		textAreaBinary = new JTextArea();
		textAreaBinary.setBounds(7, 159, 420, 68);
		textAreaBinary.setEditable(false);
		frmStackToBinary.getContentPane().add(textAreaBinary);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(354, 231, 73, 23);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(7, 236, 51, 14);
		frmStackToBinary.getContentPane().add(lblStatus);
		frmStackToBinary.getContentPane().add(btnExit);
		
		textFieldStatus = new JTextField();
		textFieldStatus.setBounds(53, 233, 291, 20);
		frmStackToBinary.getContentPane().add(textFieldStatus);
		textFieldStatus.setColumns(10);
		
		JLabel lblStackContents = new JLabel("Stack Contents");
		lblStackContents.setHorizontalAlignment(SwingConstants.CENTER);
		lblStackContents.setBounds(129, 41, 177, 14);
		frmStackToBinary.getContentPane().add(lblStackContents);
	}
	
	public void push(int x)
	{
		if (isFull())
		{
			textFieldStatus.setText("OverFlow");
		}else {
			textFieldStatus.setText("Inserting " + x);
			arr[++top] = x;
		}
	}

	// Utility function to pop top element from the stack
	public int pop()
	{
		// check for stack underflow
		if (isEmpty())
		{
			textFieldStatus.setText("UnderFlow");
		}else {
			textFieldStatus.setText("Removing " + peek());
				display();
				textFieldStatus.setText("Pop " + arr[top] + " was remove from the stack.\n");
				arr[top] = 0;
		}
		return arr[top--];
	           
		// decrease stack size by 1 and (optionally) return the popped element
//		return arr[top--];
	}

	// Utility function to return top element in a stack
	public int peek()
	{
		if (!isEmpty())
			return arr[top];
		else
			System.exit(1);

		return -1;
	}

	// Utility function to return the size of the stack
	public int size()
	{
		return top + 1;
	}

	// Utility function to check if the stack is empty or not
	public Boolean isEmpty()
	{
		return top == -1;	// or return size() == 0;
	}

	// Utility function to check if the stack is full or not
	public Boolean isFull()
	{
		return top == capacity - 1;	// or return size() == capacity;
	}
	public void display() {
		decToBin();
		String hold="";
		String temp = "";
		for (int i = 0; i < arr.length; i++) {
			hold+=arr[i]+" | ";
			temp+=bin[i]+" | ";
		}
		textAreaMain.setText(hold);
		textAreaBinary.setText(temp);

	}
	public void decToBin() {
		int n = 0,a = 0;
		bin = new String[arr.length];
		String hold = "";

		for (int i = 0; i < bin.length; i++) {
	        n=arr[i];
	        if (n==0) {
	        	bin[i] = "0";
			}else {
				while(n > 0)
		        {	        	
		            a = n % 2;
		            hold = a + hold;
		            n = n / 2;
		        }
				bin[i] = hold;
				hold="";
			} 
		}
	}
}

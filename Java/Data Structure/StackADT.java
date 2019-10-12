import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class StackADT {

	private JFrame frmStackarrayImplementtaion;
	private JTextField entryField;
	private JTextArea mainField;
	private JTextField topField;
	private static String[] StackArray;
	private static int stackSize;
	private int topofStack = -1;
	private JTextPane statusField;
	private JLabel lblStatus;
	private JButton btnExit;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					int size = Integer.parseInt(JOptionPane.showInputDialog("Enter stack size",10));
					stackSize = size;
			        StackArray = new String[size];
			        Arrays.fill(StackArray,"_");
					
					StackADT window = new StackADT();
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
	public StackADT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
   
	private void initialize() {
		frmStackarrayImplementtaion = new JFrame();
		frmStackarrayImplementtaion.setTitle("Stack (Array Implementation)");
		frmStackarrayImplementtaion.setBounds(100, 100, 456, 270);
		frmStackarrayImplementtaion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStackarrayImplementtaion.getContentPane().setLayout(null);
		
		entryField = new JTextField();
		entryField.setBounds(101, 13, 68, 30);
		frmStackarrayImplementtaion.getContentPane().add(entryField);
		entryField.setColumns(10);
		
		JButton btnPush = new JButton("Push");
		btnPush.setBounds(175, 13, 83, 30);
		btnPush.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (entryField.getText().contains(" ")) {
					pushMany(entryField.getText());
				}
				else if(entryField.getText().isEmpty()) {
					statusField.setText("Entry field is empty!");
				}
				else {
					push(entryField.getText());
				}
				displayStack();
				peek();
			}
		});
		frmStackarrayImplementtaion.getContentPane().add(btnPush);
		
		JButton btnPop = new JButton("Pop");
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pop();
				displayStack();
				peek();


			}
		});
		btnPop.setBounds(258, 13, 77, 30);
		frmStackarrayImplementtaion.getContentPane().add(btnPop);
		
		JButton btnClear = new JButton("Clear Stack");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popAll();
				displayStack();
				peek();


			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnClear.setBounds(339, 13, 91, 30);
		frmStackarrayImplementtaion.getContentPane().add(btnClear);
		
		JLabel lblTop = new JLabel("Top:");
		lblTop.setBounds(10, 11, 42, 32);
		frmStackarrayImplementtaion.getContentPane().add(lblTop);
		
		topField = new JTextField();
		topField.setBounds(37, 13, 54, 30);
		topField.setEditable(false);
		topField.setHorizontalAlignment(SwingConstants.LEFT);
		frmStackarrayImplementtaion.getContentPane().add(topField);
		topField.setColumns(10);
		
		mainField = new JTextArea();
		mainField.setBounds(10, 50, 420, 127);
		mainField.setEditable(false);
		frmStackarrayImplementtaion.getContentPane().add(mainField);
		mainField.setColumns(10);
		displayStack();
		
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
	
    public void displayStack() {     //shows elements of the *
        String x = "";
        for(int i = 0; i <10; i++){
         x+=("| "+StackArray[i]);
   }
        mainField.setText(x);
   }
   public void push(String input){ //add element to a stack *
       if (topofStack< stackSize-1){
           topofStack++;
           StackArray[topofStack]= input;
           statusField.setText("Push " + input + " was added to the stack");
       }
       else {
           displayStack();
           statusField.setText("Sorry but the stack is full.\n"
           					+ "Push " + input + "was not added to the stack");
        }
   }
   public String pop(){   //remove element in a stack
       if (topofStack >= 0){
           displayStack();
           statusField.setText("Pop " + StackArray[topofStack] + " was remove from the stack.\n");
           StackArray[topofStack] = "_";
           return StackArray[topofStack--];
      } else
       {
           displayStack();
           statusField.setText("Sorry but the stack  is empty");
           return "-1";
          }
   }
   public void peek(){   //top element of a stack
       topField.setText(StackArray[topofStack]);
   }

   public void pushMany(String MultipleValues){  //add many elements
       String[] tempString = MultipleValues.split(" ");
       for(int i = 0; i<tempString.length; i++){
           push(tempString[i]);
       }
}
   public void popAll(){  //remove many elements
       for(int i = topofStack; i>=0; i--){
           pop();
       }
       statusField.setText("Stack cleared!");
   }
}

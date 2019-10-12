import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CircularQueue {

	private JFrame frame;
	private JTextField textField;
	
	static int a[];
    static int front;
	static int rear;
    private JTextArea textAreaMain;
    private JTextArea textAreaStatus;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 a = new int [Integer.parseInt(JOptionPane.showInputDialog("Enter queue size"))];
				     front = rear = -1;
					CircularQueue window = new CircularQueue();
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
	public CircularQueue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 397, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textAreaStatus = new JTextArea();
		textAreaStatus.setEditable(false);
		textAreaStatus.setBounds(47, 230, 239, 22);
		frame.getContentPane().add(textAreaStatus);
		
		textField = new JTextField();
		textField.setBounds(7, 7, 115, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(126, 7, 76, 26);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert(Integer.parseInt(textField.getText()));
				display();
				textField.setText("");
				display();
			}
		});
		
		textAreaMain = new JTextArea();
		textAreaMain.setEditable(false);
		textAreaMain.setBounds(7, 37, 367, 190);
		frame.getContentPane().add(textAreaMain);
		frame.getContentPane().add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(empty())
					 textAreaStatus.setText("Queue underflow: ");
			     else {       
			    	 textAreaStatus.setText("The value ["+Integer.toString(delete())+"] is deleted from the queue");
			    	 display();
			     }
			}
		});
		btnDelete.setBounds(206, 7, 80, 26);
		frame.getContentPane().add(btnDelete);
		
		JButton btnDestroy = new JButton("Destroy");
		btnDestroy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Choose YES to DESTROY the queue", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					destroy();
					textAreaMain.setText("");
					textAreaStatus.setText("Queue Destroyed");
				}
			}
		});
		btnDestroy.setBounds(290, 7, 84, 26);
		frame.getContentPane().add(btnDestroy);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(290, 231, 84, 23);
		frame.getContentPane().add(btnExit);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(7, 231, 56, 21);
		frame.getContentPane().add(lblStatus);
	}
	
	void insert(int x)     {
        int p;
        p = (rear+1)% a.length;

        if(p == front)
        	textAreaStatus.setText("Queue Overflow ");
        else         {
            rear = p;
            a[rear] = x;
        	textAreaStatus.setText("The value ["+x+"] is inserted in the queue");

            if(front == -1)
               front = 0;

        }
    }


    boolean empty()     {
        if(front == -1)
            return true;
        else
            return false;
    }


    int delete()     {
        int x = a[front];
        if(front == rear)
            front = rear = -1;
        else
            front =(front+1)% a.length;
        return x;
    }


    void display()     {
    	if(front == -1)
            textAreaMain.setText("");

    	String hold = "";
        int i = front;
        while(i != rear){
        	hold+=a[i]+"|";
            i = (i+1)% a.length;
        }
        hold+=a[i];
        textAreaMain.setText(hold+"\n");
    }

    void destroy()    { 
        front = rear=-1;

    }
}

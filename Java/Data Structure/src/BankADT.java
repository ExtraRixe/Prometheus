
import javax.swing.JOptionPane;

public class BankADT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] menu = { "Deposit Amount","Withdraw Amount","Exit" };

		while (true) {
			
			int input = JOptionPane.showOptionDialog(null,"Account Capacity          :20,000\n"
					+ "Current Balance             :"+ Current_Balance() + "\n"
					+ "Account Empty               :" + zeroBalance() + "\n"
					+ "Accout Full                       :" + equalLimit() + "\n"
					,"BANK",
	                 JOptionPane.YES_NO_CANCEL_OPTION,
	                 JOptionPane.PLAIN_MESSAGE,
	                 null,
	                 menu,
	                 null);
			
			switch (input) {
			
			case 0:
				float deposit =Float.parseFloat(JOptionPane.showInputDialog("Enter amount to deposit"));
				
				if(deposit+Current_Balance() > 20000) {
					JOptionPane.showMessageDialog(null, "Current deposit exceeds your maximum balance!","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "The amount of "+deposit+" has been successfully deposited to your account","Deposit",JOptionPane.PLAIN_MESSAGE);
					Deposit(deposit);
				}
				nTransaction();	
			break;
				
			case 1:
				float withdraw =Float.parseFloat(JOptionPane.showInputDialog("Your available balance is:"+Current_Balance+"\n"
						+ "Enter amount to withdraw"));
				if(Current_Balance()-withdraw < 0) {
					JOptionPane.showMessageDialog(null, "Not enough balance!","Balance Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "The amount of "+withdraw+" has been successfully withdrawn from your account","Withdraw",JOptionPane.PLAIN_MESSAGE);
					Withdraw(withdraw);	
				}
				nTransaction();	
			break;
			
			case 2:
				System.exit(0);
			break;
			}
		}
		
	}
	static float Current_Balance = 0;
    public static void Deposit(float Amount) { Current_Balance = Current_Balance + Amount; }
    public static void Withdraw(float Amount) { Current_Balance = Current_Balance - Amount; }
    public static float Current_Balance() { return Current_Balance; }
	public static boolean equalLimit() { if (Current_Balance == 20000)  return true; else return false;   }
	public static boolean zeroBalance() { if (Current_Balance == 0.00)  return true; else return false;   }
	public static void nTransaction() {if (JOptionPane.showConfirmDialog(null, "Do you have any other transactions?", "=INFORMATION=",
	        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
	} else {
	    System.exit(0);
	}}
}

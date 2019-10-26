import javax.swing.JOptionPane;

public class math {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] shapes = { "Square","Rectangle","Circle" };
		String[] choice = { "Area","Perimeter" };
		float s,l,w,pi,r = (float) 0.0;		
		
		while (true) {
			String input = (String) JOptionPane.showInputDialog(null, "Choose if Area or Perimeter: ","Area&Perimeter",JOptionPane.QUESTION_MESSAGE,null,choice,choice[0]);
			
			switch (input) {
			
			case "Area":
			String area = (String) JOptionPane.showInputDialog(null, "Choose Shape: ","Area&Perimeter",JOptionPane.QUESTION_MESSAGE,null,shapes,shapes[0]);
				
				switch (area) {
				case "Square":
					s = Integer.parseInt(JOptionPane.showInputDialog("Enter Value for side"));
					JOptionPane.showMessageDialog(null, "The area is "+Square_Area(s));
					break;
					
				case "Rectangle":
					l = Integer.parseInt(JOptionPane.showInputDialog("Enter Value for length"));
					w = Integer.parseInt(JOptionPane.showInputDialog("Enter Value for width"));
					JOptionPane.showMessageDialog(null, "The area is "+Rectangle_Area(l, w));
					break;
					
				case "Circle":
					pi = Integer.parseInt(JOptionPane.showInputDialog("Enter Value for Pi"));
					r = Integer.parseInt(JOptionPane.showInputDialog("Enter Value for radius"));
					JOptionPane.showMessageDialog(null, "The area is "+Circle_Area(pi, r));
					break;
				
				
				}
				
				if (JOptionPane.showConfirmDialog(null, "Solve Again?", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					continue;
				} else {
				    System.exit(0);
				}

				break;
				
			case "Perimeter":
			String perimeter = (String) JOptionPane.showInputDialog(null, "Choose Shape: ","Area&Perimeter",JOptionPane.QUESTION_MESSAGE,null,shapes,shapes[0]);

			
			switch (perimeter) {
			case "Square":
				s = Integer.parseInt(JOptionPane.showInputDialog("Enter Value for side"));
				JOptionPane.showMessageDialog(null, "The perimeter is "+Square_Perimeter(s));
				break;
				
			case "Rectangle":
				l = Integer.parseInt(JOptionPane.showInputDialog("Enter Value for length"));
				w = Integer.parseInt(JOptionPane.showInputDialog("Enter Value for width"));
				JOptionPane.showMessageDialog(null, "The perimeter is "+Rectangle_Perimeter(l, w));
				break;
				
			case "Circle":
				pi = Integer.parseInt(JOptionPane.showInputDialog("Enter Value for Pi"));
				r = Integer.parseInt(JOptionPane.showInputDialog("Enter Value for radius"));
				JOptionPane.showMessageDialog(null, "The perimeter is "+Circle_Perimeter(pi, r));
				break;
			
			
			}
			
			if (JOptionPane.showConfirmDialog(null, "Solve Again?", "WARNING",
			        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				continue;
			} else {
			    System.exit(0);
			}
			
			break;
			}
			
		}
		
	}
	//PerimeterFormula
	public static float Square_Perimeter(float S) { return 4* S; }
	public static float Rectangle_Perimeter(float L, float W) { return 2*L + 2*W; }
	public static float Circle_Perimeter(float Pi, float R) { return 2*Pi*R; }
	//AreaFormula
	public static float Square_Area(float S) { return S*S; }
	public static float Rectangle_Area(float L, float W) { return L*W; }
	public static float Circle_Area(float Pi, float R) { return Pi*R*R; }
		
	
}

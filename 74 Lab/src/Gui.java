import javax.swing.*;

public class Gui implements DevMap{
	public static void main(String args[]) {
		JFrame window = new JFrame();
		window.setSize(Width, Height);
		window.setTitle("7.4 Lab");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TableCraft pane;
		
		int months;
		double otf[] = new double[2];
		
		otf[0] = Double.parseDouble(JOptionPane.showInputDialog("total to pay"));
		otf[1] = Double.parseDouble(JOptionPane.showInputDialog("Rate of interest"));
		months = Integer.parseInt(JOptionPane.showInputDialog("Months to pay"));
		pane = new TableCraft(otf[0], otf[1], months);
		window.add(pane);
		window.setVisible(true);
	}
}

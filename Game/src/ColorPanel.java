import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;
public class ColorPanel extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4212434621816917675L;
	public ArrayList<Color> ar, ar2;
	private Rectangle p1, p2;
	private JButton b;
	private static String correct = "hello";
	
	public ColorPanel() {
		p1 = new Rectangle(0,0);
		p2 = new Rectangle(400, 0);
	}
	public ColorPanel(Color in[], Color in2[]) {
		ar = new ArrayList<Color>(Arrays.asList(in));
		ar2 = new ArrayList<Color>(Arrays.asList(in2));
		p1 = new Rectangle(0,0);
		p2 = new Rectangle(500, 0);
		b = new JButton("Check Answer");
		b.setActionCommand("Check");
		b.setEnabled(true);
		b.addActionListener(this);
		add(b, BorderLayout.CENTER);
	}
	public void change(int i){
		super.setBackground(ar.get(i));
		super.repaint();
	}
	
	public void paintComponent(Graphics g) {
		p1.fill(g);
		p2.fill(g);
	}
	public void actionPerformed(ActionEvent e) {
		if("Check".equals(e.getActionCommand())) {
			String it = JOptionPane.showInputDialog("Enter Answer", "");
			if(it.equals(correct)) {
				JOptionPane.showMessageDialog(null, "You Are Correct");
			} else {
				JOptionPane.showMessageDialog(null, "Almost");
			}
		}
	}
	//runs through the color program with an interval of waiting for the intervals
	//seconds between each time
	public void timedRun(int interval) {
		for(int i = 0; i < ar.size(); i++) {
			p1.color = Color.white;
			p2.color = Color.white;
			repaint();
			try{
				Thread.sleep(300);
			} catch(InterruptedException e) {
				System.out.print(e.getMessage());
			}
			
			p1.color = ar.get(i);
			p2.color = ar2.get(i);
			//set a new background color for the panel
			super.repaint();
			//repaint to reset the color
			try {
			Thread.sleep((long)(interval * 1000));
			} catch(InterruptedException e) {
				System.out.print(e.getMessage());
			}
			//try to sleep the thread for designated number of seconds
		}
	}
}

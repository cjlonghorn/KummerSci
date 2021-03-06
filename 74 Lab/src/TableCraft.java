import java.awt.Graphics;

import javax.swing.*;
	
public class TableCraft extends JPanel {
	
	public Payment pay = new Payment();
	private JTable table;
	
	public TableCraft(double total, double rate, int months) {
		pay.total = total;
		pay.rate = rate;
		pay.monthTotal = months;
		
		TabInit();
		//init the table
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		super.add(scrollPane);
	}
	
	
	
	public void TabInit() {
		String column[] = new String[] {"Month", "Principle", "Interest", "Balance"};
		Object data[][] = new Object[pay.monthTotal][4];
		
		for(int i = 0; i < pay.monthTotal; i++) {
			data[i][0] = i + 1;
			data[i][1] = pay.round(pay.principle(i));
			data[i][2] = pay.round(pay.interest(i));
			data[i][3] = pay.round(pay.balance(i));
		}
		
		table = new JTable(data, column);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	

}

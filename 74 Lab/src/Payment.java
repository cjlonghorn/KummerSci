
public class Payment {
	//interface of the payment class for the TableCraft
	protected double total;
	protected double rate;
	protected int monthTotal;
	
	public double interest(int month) {
		double possible = balance(month) * rate/100;
		possible /= monthTotal;
		return possible;
	}
	//returns the interest of the current balance
	public double principle(int month) {
		return monthlyPay() - interest(month) ;
	}
	public double balance(int month) {
		return total - (monthlyPay() * month);
	}
	public double monthlyPay() {
		return total/monthTotal;
	}
	//rounds the number put in
	public String round(double in) {
		int up[] = new int[2];
		up[0] = (int)(in * 100);
		up[1] = (int)(in*1000 - up[0] * 10);
		if(up[1] > 5) up[0]++;
		in = (double)(up[0]/100);
		return String.format("$%.2f", in);
	}
}
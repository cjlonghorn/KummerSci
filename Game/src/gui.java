import javax.swing.*;
import java.awt.*;
/*TODO
 *	Multithread the program to have the switches and checking the box running at the
 * 	same instance
 * 
 * Add in the string format for the message and great the guide for it off screen
*/
public class gui {
	public static void main(String args[]) {
		Color p1Color[] = new Color[] {Color.black, Color.green, Color.pink, Color.blue, Color.blue, Color.pink};
		Color p2Color[] = new Color[] {Color.black, Color.blue, Color.red, Color.green, Color.green, Color.green};
		
		JFrame window = new JFrame();
		window.setTitle("The Mysterious Signal");
		window.setSize(800, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = window.getContentPane();
		ColorPanel panel = new ColorPanel(p1Color, p2Color);
		
		pane.add(panel);
		window.setVisible(true);
		
		while(true) {
			panel.timedRun(5);

		}
		


	}
	
}

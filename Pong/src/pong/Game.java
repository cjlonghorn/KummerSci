package pong;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Game extends JFrame{ 
	public Game() {
		gameInit();
	}
	public void gameInit() {
        add(new Rule());
        setTitle("Breakout");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(JavaMap.Width, JavaMap.Height);
        setLocationRelativeTo(null);
        setResizable(false);
	}
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				Game game = new Game();
				game.setVisible(true);
			}
		});

	}
}

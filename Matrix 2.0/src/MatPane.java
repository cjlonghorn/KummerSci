import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatPane extends JPanel implements ActionListener {

	private JTextField data[][];
	private JComboBox<Integer> field[];
	private Matrix matrix;
	
	/*
	 * This class will be the basis for the graphical view of matrixes
	 * 
	 * something like this:
	 * 
	 * -----Matrix-Dimensions--------
	 * ------------------------------
	 * Matrix Boxes------------------
	 * ---[.....]--[.....]--[.....]--
	 * ---[.....]--[.....]--[.....]--
	 * ---[.....]--[.....]--[.....]--
	 * ---[.....]--[.....]--[.....]--
	 * ------------------------------
	 * -----[Randomize Button]-------
	 */
	
	/*
	 * Functions layout
	 * MatPane()
	 * -creates a new 2x2 matrix filled with zeroes
	 * MatPane(int rows, int columns)
	 * -creates a new rowsxcolumns matrix blank
	 * MatPane(Matrix in)
	 * -Fills
	 * 
	 * Initialize(int rows, int columns)
	 * -used for each of the different initializations and contains that code
	 * Resize(int rows, int columns)
	 * -resizes the full matrix
	 * 
	 * Initialize objects(running continuously
	 * dimensions()
	 * -will create the dimensions dropboxes and set up their ability to change the matrix
	 * random()
	 * -set up the random button to randomly fill everything
	 */
	
	//Constructors ****************
	public MatPane() {
		Initialize(3, 3);
	}
	public MatPane(int rows, int columns) {
		Initialize(rows, columns);
	}
	
	//Initializers ****************
	public void Initialize(int rows, int columns) {
		this.setLayout(new GridLayout(3, 3));
		resize(rows, columns);
		button();
		combBox();
		
	}
	//Objects Initializers ********
	private void combBox() {
		field = new JComboBox[2];
		Integer label[] = new Integer[] {1, 2, 3, 4, 5};
		
		field[0] = new JComboBox<Integer>(label);
		field[1] = new JComboBox<Integer>(label);
		field[0].addActionListener(this);
		field[0].setActionCommand("cr");
		//sets it up to resize to rows
		field[1].addActionListener(this);
		field[1].setActionCommand("cc");
		super.add(field[0], 0, 0);
		super.add(field[1], 0, 1);
	}
	private void button() {
		JButton button = new JButton("Randomize");
		button.setSize(10, 5);
		button.addActionListener(this);
		button.setActionCommand("Rand");
		super.add(button, 1, 1);
		//sets the button up and its command to randomize the matrix
	}
	//Methods**********************
	public void resize(int rows, int columns) {
		data = new JTextField[rows][columns];
		matrix = new Matrix(rows + 2, columns);
		GridLayout gr = new GridLayout(rows, columns+1);
		super.setLayout(gr);
		//create arrays
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				data[i][j] = new JTextField("0", 10);
				//new text fields with a size of 10
				super.add(data[i][j], i+2, j);
			}
		}
	}
	//Handle Actions
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "cr") {
			//change the row value to the value of the current combobox
			int row = (Integer)field[0].getSelectedItem();
			resize(row , matrix.getColumn());
			repaint();
		}
		else if(e.getActionCommand() == "cc") {
			//change column value
			resize(matrix.getRow(), (Integer)field[1].getSelectedItem());
			repaint();
		} else if(e.getActionCommand() == "Rand") {
			matrix.randomize();
			//randomize the data
			repaint();
		}
	}
}

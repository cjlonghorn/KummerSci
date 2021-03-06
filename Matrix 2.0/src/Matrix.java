//Matrix class

public class Matrix {
	
	private int rows;
	private int columns;
	public double data[][];
	
	public Matrix(int rows, int columns) {
		//default constructor
		this.rows = rows;
		this.columns = columns;
		data = new double [rows][columns];
	}
	public Matrix(double in[][]) {
		//fill constructor
		data = in;
	}
	
	//functions
	public void resize(int rows, int columns) {
		/*
		 * TODO resize
		 * - Create diff variables to describe the value of data difference
		 * 		between the original and the new resizing being requested
		 * - use if/else statements to determine the needed operations and how many 
		 * 		times those should be run
		 * - use loops to run a certain number of times
		 * - use the given info to add or remove the needed components
		 */
		this.rows = rows;
		this.columns = columns;
		data = new double[rows][columns];
	}
	
	//sets and gets of data
	public void setDat(int rows, int column, double dataIn) {
		if(this.rows >= rows && this.columns >= column) {
			data[rows][columns] = dataIn;
		}
		//set the data at the specific point
	}
	public double getDat(int rows, int column) {
		if(this.rows >= rows && this.columns >= column) {
			return data[rows][column];
		}
		else {
			return data[0][0];
		}
	}
	public int getRow() {
		return rows;
	}
	public int getColumn() {
		return columns;
	}

	public void randomize() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				double ran = Math.random() * 15;
				setDat(i, j, ran);
			}
		}
	}
	/*
	 * TODO
	 * Divide and Subtract functions as well as a clear data function
	 */
	public boolean checkAS(Matrix other) {
		return (other.getColumn() == this.getColumn() && this.getRow() == other.getRow());
		//returns the boolean that the two exactly match
	}
}

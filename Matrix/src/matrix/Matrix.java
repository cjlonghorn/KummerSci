package matrix;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import java.util.*;


public class Matrix implements TableModelListener {
	
	public JTable table;
	protected ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
	protected ArrayList<Object> blank = new ArrayList<Object>();
	int dim[] = new int[2];
	//this contains a dynamic data array for the table, should only be needed for 
	//operations between the arrays
	public Matrix(int rows, int columns) {
		table = new JTable(new tableModel());
		table.getModel().addTableModelListener(this);
		//add a table model listener for the table
		resize(rows, columns);
		
	}
	class tableModel extends AbstractTableModel {

		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		public int getColumnCount() {
			// TODO Auto-generated method stub
			return data.get(0).size();
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			//ensure data is within bounds
			if(data.size() > rowIndex && data.get(0).size() > columnIndex) {
				return data.get(rowIndex).get(columnIndex);
				//returns piece of data requested
			} else {
				System.out.print("Data not within bounds");
				return null;
			}
		}
		public void setValueAt(int rowIndex, int columnIndex, Object in) {
			//set the data for the table at said area
			data.get(rowIndex).set(columnIndex, in);
			fireTableCellUpdated(rowIndex, columnIndex);
		}
		
	}
	//end abstract table class
	public void resize(int rows, int columns) {
		//resize the array list to find what size they should be at
		while(data.size() != rows) {
			//run when the number of rows are not the same
			if(data.size() > rows) {	//if it is too big
				data.remove(data.size() - 1);
				//removes the last row of the dynamic array
			} else if(data.size() < rows) {
				data.add(blank);
				//adding more rows of data
			}
		}
		//end of column manipulation
		for(int i = 0; i < data.size(); i++) {
			//go through each column
			while(data.get(i).size() != columns) {
				//current columns data is not equal
				if(data.get(i).size() > columns) {
					//data too big
					data.get(i).remove(data.get(i).size() - 1);
						//remove last bit of data
				} else if(data.get(i).size() < columns) {
					//data is too small
					data.get(i).add(0);
					//adds a zero for simplicities sake
				}
			}
		}
	}
	//finish resizing
	
	//table data changing

	
}

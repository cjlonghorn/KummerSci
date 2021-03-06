package Data;

import java.util.ArrayList;

public class Sentance {

	private ArrayList<Word> data;
	
	//default constructor
	
	public Sentance() {
		data = new ArrayList<Word>();
	}
	
	public Sentance(String input) {
		data = new ArrayList<Word>();
		InputSentance(input);
	}
	
	//Methods
	
	public Word getWord(int index) {
		if(index < data.size()) {
			return data.get(index);
		}
		else {
			return data.get(data.size() - 1);
		}
	}
	
	public void InputSentance(String in) {
		int index = 0;
		//counter for the String
		if(dataMap.debug) System.out.println("DEBUG: Begin InputSentance\nSentance: " + in + "\n\nSentance Begin processing:");
		String sinDat;
		//check if the sentance has ended			also make sure the index is less than the string length
		while(index < in.length()) {
			sinDat = "";
			try {
				//begin word data
				while(Util.isChar(in.charAt(index))) {
					//Debug output a character when it is a char
					if(dataMap.debug) System.out.print(" "+sinDat.length() + "\\" + in.charAt(index));
				//ensure that the letter is a thing to continue the word
					sinDat += Character.toString(in.charAt(index));
					index++;
				}
				if(sinDat.length() > 0) {
					data.add(new Word(sinDat));
				}
				//if the data is above "" then it will be added to data
				if(dataMap.debug) System.out.print("^");
				index++;
			} catch(StringIndexOutOfBoundsException e ) {
				if(dataMap.debug) System.out.println("\nCaught end of string");
				data.add(new Word(sinDat));
			}
		}
		//when the sentence is done end the method
		if(dataMap.debug) System.out.println("\nEndInputSentance");
	}
	
	//Data returns
	
	//Returns a count of the syallbes inside all of the words
	public int getSylCount() {
		int count = 0;
		for(Word word: data) {
			count += word.getSyllable();
		}
		return count;
	}
	
	//returns a count of the words in the sentance
	public int getWordSize() {
		return data.size();
	}
}

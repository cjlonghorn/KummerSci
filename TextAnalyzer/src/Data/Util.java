package Data;

public class Util {

	//generalized class for general methods many of the functions may have a need for
	
	//ifVowel will check whether or not the selected character will have a vowel inside
	public static boolean ifVowel(char in) {
		
		//convert in to lower case
		switch(Character.toLowerCase(in)) {
		//cases for each vowel
		case 'a': case 'e': case 'i': case 'o': case 'u': case 'y':
				return true;
		default:
				//if not a vowel
				return false;
		}
	}
	
	
	public static boolean ifDipthong(String in) {
		String[] dip = new String[] {"ea", "ay", "ou", "ie", "oi", "ee", "ai", "ue"};
		//list of dipthongs that can be used for the one syllable vowels
		in.toLowerCase();
		//set to lowercase for the later
		for(String test: dip) {
			//for each of them
			//check if the two vowells match up with it
			if(test.equals(in)) return true;
		}
//if the syllables don't work then return false
		return false;
	}
	
	public static boolean isEndSen(char in) {
		
		switch(in) {
		case '.': case '?': case '!': 
			return true;
		default:
			return false;
		}
	}
	
	public static boolean isChar(char in) {
		return Character.isLetter(in);
	}
}


package topten;
import java.util.Scanner;
import java.io.*;



public class TopTen {
    private Player top[];

    public TopTen() {
        //default constructor
        top = new Player[10];
        //initialize top ten array
    }

    public void iFile(String path) throws IOException {
    	Scanner ifile = new Scanner(new File(path));
    	int i = 0;
    	int j = 0;
    	String tempname = "";
    	while(ifile.hasNext() && j <10) {
    		if(i == 0) {
    			tempname = ifile.next();
    			i++;
    		}
    		else if(i == 1) {
    			int num = ifile.nextInt();
    			top[j] = new Player(num, tempname);
    			j++;
    			i=0;
    		}
    	}
		ifile.close();
    }
    public void oFile(String path) {
    	try {
    		File pa = new File(path);
    		FileWriter file = new FileWriter(pa, false);
    		PrintWriter ofile = new PrintWriter(file, false);
    		ofile.print(toString());
    		ofile.close();
    	}catch (IOException e) {
    		System.out.print(e.getMessage());
    	}
    }
    public void add(Player in) {
    	boolean match = false;
    	for(int i = 0; i < 10; i++) {
    		if(!match) {
    			match = top[i].checkScore(in.getScore());
    			if(match){
    				Player temp = top[i];
    				top[i] = in;
    				top[i+1] = temp;
    				i++;
    			}
    		} else if(match) {
    			if(i < 9) {
    				Player temp = top[i];
    				top[i] = top[i+1];
    				top[i+1] = temp;
    			}
    		}
    	}
    }
    public String toString() {
    	String out = "";
    	for(int i = 0; i < 10; i++) {
    		out += top[i].toString();
    	}
    	return out;
    }
}
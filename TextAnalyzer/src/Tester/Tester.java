package Tester;

import java.io.File;
import java.util.Scanner;

import Data.*;

public class Tester {
	public static void main(String args[]) {

		Paragraph para;
		File inputFile = new File(dataMap.fileHome + "Gettysburg.txt");
		para = new Paragraph(inputFile);
		
		System.out.println("Fleusch Score of " + para.FleschScore());
	}
}

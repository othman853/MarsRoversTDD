package br.com.yasser.rachid.marsrovers.main;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dialogs {
	
	private Scanner reader;
	public static final String POSITION_INPUT_PATTERN = "([0-9])+(,)+([0-9])+";
	
	public Dialogs(Scanner reader){		
		this.reader = reader;		
	}
	
	public Dialogs(){
		
	}
	
	public void setReader(Scanner reader){
		this.reader = reader;
	}
	
	public Scanner getReader(){
		return this.reader;
	}
	
	public ExplorationPoint askForPosition() throws InputMismatchException{		
		System.out.print("position [X,Y] > " );
		String input = "";

		input = reader.next(POSITION_INPUT_PATTERN);

		return extractExplorationPoint(input);
	}
	
	public ExplorationPoint extractExplorationPoint(String input){
		int x = 0;
		int y = 0;
		
		ExplorationPoint point = new ExplorationPoint();
				
		x = Integer.parseInt(input.split(",")[0]);
		y = Integer.parseInt(input.split(",")[1]);
		
		point = new ExplorationPoint(x,y);
		
		return point;
	}

}

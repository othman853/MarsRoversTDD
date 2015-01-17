package br.com.yasser.rachid.marsrovers.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dialogs {
	
	private Scanner reader;
	public static final String POSITION_INPUT_PATTERN = "([0-9])+(,)+([0-9])+";
	public static final String COMMAND_INPUT_PATTERN  = "[LMR]+";
	
	public Dialogs(Scanner reader){		
		this.reader = reader;		
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
	
	public Command askForCommand() throws InputMismatchException{
		System.out.print("command [LMR] > ");
		
		String input = reader.next(COMMAND_INPUT_PATTERN);
		Command command = new Command(input);
		
		return command;
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
package br.com.yasser.rachid.marsrovers.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.yasser.rachid.marsrovers.model.Command;
import br.com.yasser.rachid.marsrovers.model.ExplorationPoint;

public class Dialogs {
	
	private Scanner reader;
	public static final String FIELD_DIMENSION_INPUT_PATTERN = "([0-9])+(,)+([0-9])+";
	public static final String POSITION_INPUT_PATTERN = "([0-9])+(,)+([0-9])+[NSWE]";
	public static final String COMMAND_INPUT_PATTERN  = "[LMR]+";
	
	private static final int WIDTH_INDEX  = 0;
	private static final int HEIGHT_INDEX = 1;
	
	
	public Dialogs(Scanner reader){		
		this.reader = reader;		
	}
	
	public void setReader(Scanner reader){
		this.reader = reader;
	}
	
	public Scanner getReader(){
		return this.reader;
	}
	
	public int[] askForFieldSize() {
		System.out.println("field size [W,H] > ");
		
		String userInput = reader.next(FIELD_DIMENSION_INPUT_PATTERN);
		
		int[] dimensions = new int[2];
		String [] inputDimensions = userInput.split(","); 
		
		dimensions[WIDTH_INDEX]  = Integer.parseInt(inputDimensions[WIDTH_INDEX]);
		dimensions[HEIGHT_INDEX] = Integer.parseInt(inputDimensions[HEIGHT_INDEX]);
		
		return dimensions;				
	}
	
	public ExplorationPoint askForPosition() throws InputMismatchException{		
		System.out.print("position [X,Y] > " );
		String input = "";

		input = reader.next(POSITION_INPUT_PATTERN);

		return extractExplorationPoint(input);
	}
	
	public Command askForCommand() throws InputMismatchException{
		System.out.print("command [LRM] > ");
		
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
package br.com.yasser.rachid.marsrovers.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.yasser.rachid.marsrovers.model.Command;
import br.com.yasser.rachid.marsrovers.model.ExplorationField;
import br.com.yasser.rachid.marsrovers.model.ExplorationPoint;

public class Dialogs {
	
	private Scanner reader;
	public static final String FIELD_DIMENSION_INPUT_PATTERN = "([0-9])+(,)+([0-9])+";
	public static final String POSITION_INPUT_PATTERN 	 = "([0-9])+(,)+([0-9])+[NSWE]";
	public static final String COMMAND_INPUT_PATTERN  	 = "[LMR]+";
	public static final String YES_PATTERN = "[yY]"; 
	public static final String NO_PATTERN  = "[nN]";
	
	public Dialogs(Scanner reader){		
		this.reader = reader;		
	}
	
	public void setReader(Scanner reader){
		this.reader = reader;
	}
	
	public Scanner getReader(){
		return this.reader;
	}
	
	public int[] askForFieldSize() throws InputMismatchException{
		String userInput = "";
		
		System.out.print("field size [W,H] > ");	
		try{
			userInput = reader.next(FIELD_DIMENSION_INPUT_PATTERN);
		}catch(InputMismatchException ex){
			throw new InputMismatchException("Invalid field size.");
		}
		
		
		int[] dimensions = new int[2];
		String [] inputDimensions = userInput.split(","); 
		
		dimensions[ExplorationField.WIDTH_INDEX]  = Integer.parseInt(inputDimensions[ExplorationField.WIDTH_INDEX]);
		dimensions[ExplorationField.HEIGHT_INDEX] = Integer.parseInt(inputDimensions[ExplorationField.HEIGHT_INDEX]);
		
		return dimensions;				
	}
	
	public ExplorationPoint askForPosition() throws InputMismatchException{		
		System.out.print("position [X,Y] > " );
		String input = "";

		try{
			input = reader.next(POSITION_INPUT_PATTERN);
		}catch(InputMismatchException ex){
			throw new InputMismatchException("Invalid Position.");
		}

		return extractExplorationPoint(input);
	}
	
	public Command askForCommand() throws InputMismatchException{
		System.out.print("command [LRM] > ");
		
		Command command = null;
		
		try{
			String input = reader.next(COMMAND_INPUT_PATTERN);
			command = new Command(input);
		}catch(InputMismatchException ex){
			throw new InputMismatchException("Invalid Command.");
		}		
		
		return command;
	}
	
	private ExplorationPoint extractExplorationPoint(String input) {
		int x = 0;
		int y = 0;
		
		ExplorationPoint point = new ExplorationPoint();
				
		x = Integer.parseInt(input.split(",")[0]);
		y = Integer.parseInt(input.split(",")[1]);
		
		point = new ExplorationPoint(x,y);
		
		return point;
	}

	public boolean mayContinue() throws InputMismatchException{
		System.out.print("Continue [y/n] ? ");
		String input = reader.next();
		
		
		if(input.matches(YES_PATTERN)){
			return true;
		}
		
		else if(input.matches(NO_PATTERN)){
			return false;
		}
		
		else{
			throw new InputMismatchException("Invalid Option");
		}		
	}
	
	public void skipLine(){
		reader.next();
	}
}
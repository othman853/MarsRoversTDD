package br.com.yasser.rachid.marsrovers.main;

import java.util.Scanner;

public class Dialogs {
	
	private static Scanner reader;
	private static final String POSITION_INPUT_PATTERN = "([0-9])+(,)+([0,9])+";
	
	public Dialogs(){
		if(reader == null){
			reader = new Scanner(System.in);
		}
	}
	
	public static ExplorationPoint askForPosition(){
		int x = 0;
		int y = 0;
		
		ExplorationPoint point = new ExplorationPoint();
		
		String input = "";
		System.out.print("position [X,Y] > " );		
		input = reader.next(POSITION_INPUT_PATTERN);		
		
		x = Integer.parseInt(input.split(",")[0]);
		y = Integer.parseInt(input.split(",")[1]);
		
		point = new ExplorationPoint(x,y);
		
		return point;
	}

}

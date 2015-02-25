package br.com.yasser.rachid.marsrovers.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.yasser.rachid.marsrovers.controller.MissionController;
import br.com.yasser.rachid.marsrovers.view.Dialogs;

public class Main {

	private Scanner reader;
	private MissionController controller;
	private Dialogs dialogs;

	public Main() {
		initialize();
	}

	public void initialize() {
		reader = Injector.createScanner(System.in);
		dialogs = Injector.createDialogs(reader);
		
		initializeController();		
	}

	private void initializeController(){
		controller = null;
		int[] dimensions;
		
		while(controller == null){
			try{				
				dimensions = dialogs.askForFieldSize();
				controller = Injector.createMissionController(Injector.createExplorationField(dimensions));
			}catch(InputMismatchException ex){			
				dialogs.skipLine();
				System.out.println(ex.getMessage());
			}			
		}				
	}
	
	public void run() {		
		boolean mayContinue = true;		
		do{
			try{
				
				
				mayContinue = dialogs.mayContinue();
			}catch(InputMismatchException ex){
				System.out.println(ex.getMessage());
			}				
		}while(mayContinue);		
	}

	public static void main(String[] args) {
		Main main = new Main();

		main.run();
	}
}
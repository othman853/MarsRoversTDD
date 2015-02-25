package br.com.yasser.rachid.marsrovers.main;

import java.io.InputStream;
import java.util.Scanner;

import br.com.yasser.rachid.marsrovers.controller.MissionController;
import br.com.yasser.rachid.marsrovers.model.ExplorationField;
import br.com.yasser.rachid.marsrovers.view.Dialogs;

public class Injector {
	
	public static Scanner createScanner(InputStream inputStream){
		return new Scanner(System.in);
	}
	
	public static Dialogs createDialogs(Scanner reader){
		return new Dialogs(reader);
	}
	
	public static MissionController createMissionController(ExplorationField field){
		return new MissionController(field);
	}
	
	public static ExplorationField createExplorationField(int [] dimensions){
		int width  = dimensions[ExplorationField.WIDTH_INDEX];
		int height = dimensions[ExplorationField.HEIGHT_INDEX];
		
		return new ExplorationField(width, height);
	}

}

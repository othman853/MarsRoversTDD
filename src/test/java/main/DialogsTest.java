package main;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import br.com.yasser.rachid.marsrovers.main.Dialogs;
import br.com.yasser.rachid.marsrovers.main.ExplorationPoint;

public class DialogsTest {
	
	private Dialogs dialogs;	
	
	@Test
	public void askForPosition_Valid5by5CoordinatesAsParam_ShouldReturnA5by5EXplorationPoint(){		
		String expectedInput = "5,5";		
		dialogs = new Dialogs(createScanner(expectedInput));
		ExplorationPoint expectedPoint = new ExplorationPoint(5,5);
				
		ExplorationPoint point = dialogs.askForPosition();		
		
		assertEquals(point, expectedPoint);
	}
	
	@Test(expected=InputMismatchException.class)
	public void askForPosition_InvalidCoordinatesAsParam_ShouldThrowInputMismatchException(){
		String incorrectInput = "a,a";
		dialogs = new Dialogs(createScanner(incorrectInput));
		
		dialogs.askForPosition();
	}
	
	@Test
	public void askForMoveCommand_ValidCommandAsParam_ShouldReturnAValidCommandObject(){
		String expectedInput = "LMRMLM";
		dialogs = new Dialogs(createScanner(expectedInput));
		Command expected = new Command(expectedInput);
		
		Command generated = dialogs.askForCommand();
		
		assertEquals(generated, expected);
	}
	
	@Test(expected=InputMismatchException.class)
	public void askForMoveCommand_InvalidCommandAsParam_ShouldThrowInputMismatchException(){
		String incorrectInput = "LMA";
		dialogs = new Dialogs(createScanner(incorrectInput));
		
		dialogs.askForCommand();
	}
	
	
	
	private Scanner createScanner(String input){
		return new Scanner(new ByteArrayInputStream(input.getBytes()));
	}
}
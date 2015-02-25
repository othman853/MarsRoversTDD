package main;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

import br.com.yasser.rachid.marsrovers.model.Command;
import br.com.yasser.rachid.marsrovers.view.Dialogs;

public class DialogsTest {
	
	private Dialogs dialogs;	
	
	@Test
	public void askForFieldSize_Valid5by5CoordinatesAsParam_ShouldReturnAValidIntegerArray(){		
		String expectedInput = "5,5";		
		dialogs = new Dialogs(createScanner(expectedInput));
		int [] expectedFieldDimension = {5,5};
		
		int [] generatedFieldDimension = dialogs.askForFieldSize();		
		
		assertArrayEquals(generatedFieldDimension, expectedFieldDimension);		
	}
	
	@Test(expected=InputMismatchException.class)	
	public void askForFieldSize_InvalidDimensionAsParam_ShouldThrowInputMismatchException(){
		String incorrectInput = "a,a";
		dialogs = new Dialogs(createScanner(incorrectInput));
		
		dialogs.askForFieldSize();
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
	
	@Test
	public void mayContinue_yAsParam_ShouldReturnTrue(){
		String expectedInput = "y";
		dialogs = new Dialogs(createScanner(expectedInput));
		
		boolean mayContinue = dialogs.mayContinue();
		
		assertTrue(mayContinue);
	}
	
	@Test(expected=InputMismatchException.class)
	public void mayContinue_InvalidInputAsParam_ShouldThrowInputMismatchException(){
		String incorrectInput = "a";
		dialogs = new Dialogs(createScanner(incorrectInput));
		
		dialogs.mayContinue();
	}
		
	
	private Scanner createScanner(String input){
		return new Scanner(new ByteArrayInputStream(input.getBytes()));
	}
}
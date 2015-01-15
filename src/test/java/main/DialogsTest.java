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
	
	@Before
	public void setUp(){
		dialogs = new Dialogs();
	}
	
	@Test
	public void askForPosition_ShouldReturnA5by5EXplorationPoint(){		
		String expectedInput = "5,5";		
		dialogs.setReader(createScanner(expectedInput));
		ExplorationPoint expectedPoint = new ExplorationPoint(5,5);
				
		ExplorationPoint point = dialogs.askForPosition();		
		
		assertEquals(point, expectedPoint);
	}
	
	@Test(expected=InputMismatchException.class)
	public void askForPosition_ShouldThrowInputMismatchException(){
		String incorrectInput = "a,a";
		Scanner reader = createScanner(incorrectInput);
		dialogs.setReader(reader);
		
		dialogs.askForPosition();
	}
	
	
	
	private Scanner createScanner(String input){
		return new Scanner(new ByteArrayInputStream(input.getBytes()));
	}
}
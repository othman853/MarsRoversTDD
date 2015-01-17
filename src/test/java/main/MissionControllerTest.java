package main;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import br.com.yasser.rachid.marsrovers.model.ExplorationField;

public class MissionControllerTest {

	private RobotController controller;
	@Mock private ExplorationField field;
		
	@Before
	public void setUp(){
		field = mock(ExplorationField.class);
		controller = new RobotController(field);
	}
	
	@Test
	public void addRobot_EmptyPointOnFieldDestinationAsParam_ShouldFillThePointOnTheFieldAndAddTheRobotToTheList(){
		
	}
	
	@Test
	public void moveRobot_EmptyPointOnFieldDestinationAsParam_ShouldEmptyTheOriginalPointAndFillTheDestinationOne(){
		
	}
}
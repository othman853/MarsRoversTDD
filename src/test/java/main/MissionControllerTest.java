package main;

import static org.mockito.Mockito.mock;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import br.com.yasser.rachid.marsrovers.model.ExplorationField;
import br.com.yasser.rachid.marsrovers.model.ExplorationPoint;

public class MissionControllerTest {

	private MissionController controller;
	@Mock private ExplorationField field;
		
	@Before
	public void setUp(){
		field = mock(ExplorationField.class);
		controller = new MissionController(field);
	}
	
	@Test
	public void addRobot_12NAsInitialRobotPosition_ShouldAddTheRobotToTheList(){
		Robot robot = robotBuilder.getSingle();
		ExplorationPoint initalRobotPoint = pointBuilder.getSingle();
		initialRobotPoint.setCoordinateX(1);
		initialRobotPoint.setCoordinateY(2);
		robot.setExplorationPoint(initalRobotPoint);
		robot.setOrientation(Orientation.NORTH);
		
		controller.addRobot(robot);		
		int pointStatus = controller.getField().getPointStatus(point);
		
		assertThat(pointStatus, is(ExplorationPoint.POINT_FILLED));		
	}
	
	@Test
	public void moveRobot_12NRobot_COMMANDAsParam_ShouldMoveTheRobotToTheXXXPosition(){
		
	}
	
	@Test
	public void moveRobot_12NRobot_COMMANDAsParam_ShouldNotMoveTheRobot_BecauseTheDestinationIsAlreadyFilled(){
		
	}
}
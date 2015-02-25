package main;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import br.com.yasser.rachid.marsrovers.controller.MissionController;
import br.com.yasser.rachid.marsrovers.model.ExplorationField;
import br.com.yasser.rachid.marsrovers.model.ExplorationPoint;
import br.com.yasser.rachid.marsrovers.model.Orientation;
import br.com.yasser.rachid.marsrovers.model.Robot;

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
		ExplorationPoint initialRobotPoint = new ExplorationPoint();
		initialRobotPoint.setCoordinateX(1);
		initialRobotPoint.setCoordinateY(2);
		
		Robot robot = new Robot(initialRobotPoint, Orientation.NORTH);		
		
		controller.addRobot(robot);		
		int pointStatus = controller.getField().getPointStatus(initialRobotPoint);
		
		assertThat(pointStatus, is(ExplorationPoint.POINT_FILLED));	
		assertThat(controller.getRobots().size(), is(1));
	}
	
	@Test
	public void moveRobot_12NRobot_COMMANDAsParam_ShouldMoveTheRobotToTheXXXPosition(){
		
	}
	
	@Test
	public void moveRobot_12NRobot_COMMANDAsParam_ShouldNotMoveTheRobot_BecauseTheDestinationIsAlreadyFilled(){
		
	}
}
package main;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import br.com.yasser.rachid.marsrovers.controller.MissionController;
import br.com.yasser.rachid.marsrovers.model.ExplorationField;
import br.com.yasser.rachid.marsrovers.model.ExplorationPoint;
import br.com.yasser.rachid.marsrovers.model.Orientation;
import br.com.yasser.rachid.marsrovers.model.Robot;
import br.com.yasser.rachid.marsrovers.model.exception.PointFilledException;

public class MissionControllerTest {

	private MissionController controller;

	@Mock private ExplorationField field;
		
	@Before
	public void setUp(){		
		field = mock(ExplorationField.class);
		controller = new MissionController(field);
	}
	
	@Test
	public void addRobot_12NAsInitialRobotPosition_ShouldAddTheRobotToTheList() throws Exception{		
		ExplorationPoint initialRobotPoint = new ExplorationPoint(1,2);		
		Robot robot = new Robot(initialRobotPoint, Orientation.NORTH);		
		
		org.mockito.Mockito.when(field.getPointStatus(initialRobotPoint)).thenReturn(ExplorationPoint.POINT_FILLED);
		controller.addRobot(robot);		
		int pointStatus = controller.getField().getPointStatus(initialRobotPoint);
		
		assertThat(pointStatus, is(ExplorationPoint.POINT_FILLED));	
		assertThat(controller.getRobots().size(), is(1));
	}
	
	@Test(expected=PointFilledException.class)
	public void addRobot_FilledPointOnFieldDestinationAsParam_ShouldThrowPointFilledException() throws PointFilledException{
		ExplorationPoint initialPoint = new ExplorationPoint(1,2);
		Robot robot = new Robot(initialPoint, Orientation.NORTH);
		Robot robot2 = new Robot(initialPoint, Orientation.NORTH);
		
		willThrow(new PointFilledException()).given(field).addRobot(robot2);		
		
		controller.addRobot(robot);
		controller.addRobot(robot2);		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addRobot_RobotOutOfFieldBoundsAsParam_ShouldThrowIllegalArgumentException() throws IllegalArgumentException, PointFilledException{
		ExplorationPoint initialPoint = new ExplorationPoint(50,50);
		Robot robot = new Robot(initialPoint, Orientation.NORTH);
		
		willThrow(new IllegalArgumentException()).given(field).addRobot(robot);
		
		controller.addRobot(robot);		
	}
}
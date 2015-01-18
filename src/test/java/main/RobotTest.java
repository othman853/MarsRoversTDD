package main;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.yasser.rachid.marsrovers.model.ExplorationPoint;
import br.com.yasser.rachid.marsrovers.model.Orientation;
import br.com.yasser.rachid.marsrovers.model.Robot;

public class RobotTest {
	
	private Robot robot;
	
	@Before
	public void setUp(){		
		robot = new Robot(new ExplorationPoint(1,2), Orientation.NORTH);		
	}
	
	@Test
	public void toLeft_12NAsRobotPosition_ShouldChangePositionTo12W(){
		String expectedPosition = "1 2 W";
		
		robot.toLeft();
		String robotPosition = robot.toString();		
		
		assertThat(robotPosition, is(expectedPosition));
	}
	
	@Test
	public void toRight_12NAsRobotPosition_ShouldChangePositionTo12E(){
		String expectedPosition = "1 2 E";
		
		robot.toRight();
		String robotPosition = robot.toString();		
		
		assertThat(robotPosition, is(expectedPosition));		
	}
	
	@Test
	public void move_12NAsRobotPosition_ShouldChangePositionTo13N(){
		String expectedPosition = "1 3 N";
		
		robot.toLeft();
		String robotPosition = robot.toString();		
		
		assertThat(robotPosition, is(expectedPosition));		
	}
}
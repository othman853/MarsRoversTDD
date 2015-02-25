package main;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.yasser.rachid.marsrovers.model.Command;
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
		
		robot.move();
		String robotPosition = robot.toString();		
		
		assertThat(robotPosition, is(expectedPosition));		
	}
	
	@Test
	public void trace_12NAsRobotPositionMAsCommandParam_ShouldReturn13ExplorationPoint(){
		ExplorationPoint expectedPoint = new ExplorationPoint(1,3);
		Command command = new Command("M");
		
		ExplorationPoint tracedPoint = robot.trace(command);
				
		assertEquals(expectedPoint, tracedPoint);
	}
	
	@Test
	public void execute_12NAsRobotPositionAndMAsCommandParam_ShouldChangePositionTo13n(){
		String expectedPosition = "1 3 N";
		Command command = new Command("M");
		
		robot.execute(command);
		String robotPosition = robot.toString();
		
		assertThat(robotPosition, is(expectedPosition));		
	}
}
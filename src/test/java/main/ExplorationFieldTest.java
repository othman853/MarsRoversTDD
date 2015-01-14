package main;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.yasser.rachid.marsrovers.main.ExplorationField;
import br.com.yasser.rachid.marsrovers.main.ExplorationPoint;
import br.com.yasser.rachid.marsrovers.main.Robot;


public class ExplorationFieldTest {
	
	private ExplorationField explorationField;
	private RobotBuilder robotBuilder;
	private ExplorationPointBuilder pointBuilder;
	
	@Before
	public void setUp(){
		explorationField = new ExplorationField();
		robotBuilder = new RobotBuilder();
		pointBuilder = new ExplorationPointBuilder();
	}
	
	@Test
	public void addRobot_Receives5by5AsParam__getPointStatus_ShouldReturnOne(){
		Robot robot = robotBuilder.getSingle();
		ExplorationPoint point = pointBuilder.getSingle();		
		point.setCoordinateX(5);
		point.setCoordinateY(5);
		
		explorationField.addRobot(robot, point);		
		int status = explorationField.getPointStatus(point);
		
		assertEquals(status, ExplorationPoint.POINT_FILLED);		
	}
	
	@Test(expected=IllegalArgumentException.class)	
	public void addRobot_Receives5by5AsParam_ShouldThrowIllegalArgumentException_BecauseThePointIsOutOfFieldsBounds(){
		Robot robot = robotBuilder.getSingle();
		ExplorationPoint point = pointBuilder.getSingle();
		point.setCoordinateX(5);
		point.setCoordinateY(5);		
		int fieldWidth = 4;
		int fieldHeight = 4;
		
		explorationField = new ExplorationField(fieldWidth,fieldHeight);
		explorationField.addRobot(robot, point);
	}
}

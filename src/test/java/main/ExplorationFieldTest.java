package main;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

import br.com.yasser.rachid.marsrovers.model.Command;
import br.com.yasser.rachid.marsrovers.model.ExplorationField;
import br.com.yasser.rachid.marsrovers.model.ExplorationPoint;
import br.com.yasser.rachid.marsrovers.model.Orientation;
import br.com.yasser.rachid.marsrovers.model.Robot;
import br.com.yasser.rachid.marsrovers.model.exception.PointFilledException;
import br.com.yasser.rachid.marsrovers.model.exception.RobotCollisionException;


public class ExplorationFieldTest {
	
	private ExplorationField explorationField;	
	
	@Before
	public void setUp(){
		explorationField = new ExplorationField();		
	}
	
	@Test
	public void addRobot_RobotAt12NAsParam__getPointStatusAtx1y2_ShouldReturnOne() throws IllegalArgumentException, PointFilledException{		
		ExplorationPoint point = new ExplorationPoint(1,2);
		Robot robot = new Robot(point, Orientation.NORTH);
		
		explorationField.addRobot(robot);		
		int status = explorationField.getPointStatus(point);
		
		assertEquals(status, ExplorationPoint.POINT_FILLED);		
	}
	
	@Test(expected=IllegalArgumentException.class)	
	public void addRobot_Receives5by5AsParam_ShouldThrowIllegalArgumentException_BecauseThePointIsOutOfFieldsBounds() throws IllegalArgumentException, PointFilledException{		
		ExplorationPoint point = new ExplorationPoint(5,5);
		Robot robot = new Robot(point, Orientation.NORTH);
		int fieldWidth = 4;
		int fieldHeight = 4;
		
		explorationField = new ExplorationField(fieldWidth,fieldHeight);
		
		explorationField.addRobot(robot);
	}
	
	@Test
	public void isInsideFieldsBounds_5by5AsPartam_ShouldReturnFalse_OnA4by4Field(){
		explorationField = new ExplorationField(4,4);
		ExplorationPoint point = new ExplorationPoint(5,5);		
		
		boolean isInsideBounds = explorationField.isInsideFieldBounds(point);
		
		assertFalse(isInsideBounds);
	}
	
	@Test(expected=PointFilledException.class)
	public void addRobot_RobotInAFilledPositionAsParam_ShouldThrowPointFilledException() throws IllegalArgumentException, PointFilledException{
		ExplorationPoint point = new ExplorationPoint(1,2);
		Robot robot = new Robot(point, Orientation.NORTH);
		
		explorationField.addRobot(robot);
		explorationField.addRobot(robot);
	}
	
	@Test
	public void moveRobot_RobotAt12NAndMMCommandAsParam_ShouldMoveTheRobotTo14N() throws IllegalArgumentException, PointFilledException, RobotCollisionException{
		ExplorationPoint initialPoint = new ExplorationPoint(1,2);		
		ExplorationPoint desiredDestination = new ExplorationPoint(1,4);
		Robot robot = new Robot(new ExplorationPoint(1,2), Orientation.NORTH);
		Command command = new Command("MM");
		
		explorationField.addRobot(robot);
		explorationField.moveRobot(robot, command);		
		
		assertThat(explorationField.getPointStatus(initialPoint), is(ExplorationPoint.POINT_FREE));
		assertThat(explorationField.getPointStatus(desiredDestination), is(ExplorationPoint.POINT_FILLED));		
	}
	
	@Test(expected=RobotCollisionException.class)
	public void moveRobot_RobotAndCollidingCOmmandAsParam_ShouldThrowRobotCollisionException() throws IllegalArgumentException, PointFilledException, RobotCollisionException{
		ExplorationPoint initialPoint = new ExplorationPoint(1,2);
		ExplorationPoint filledPoint = new ExplorationPoint(1,4);
		Robot movingRobot = new Robot(initialPoint, Orientation.NORTH);
		Robot placeholderRobot = new Robot(filledPoint, Orientation.NORTH);
		Command move = new Command("MM");
		
		explorationField.addRobot(movingRobot);
		explorationField.addRobot(placeholderRobot);
		explorationField.moveRobot(movingRobot, move);		
	}
}

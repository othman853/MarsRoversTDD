package main;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import br.com.yasser.rachid.marsrovers.model.ExplorationField;
import br.com.yasser.rachid.marsrovers.model.ExplorationPoint;
import br.com.yasser.rachid.marsrovers.model.Orientation;
import br.com.yasser.rachid.marsrovers.model.Robot;


public class ExplorationFieldTest {
	
	private ExplorationField explorationField;	
	
	@Before
	public void setUp(){
		explorationField = new ExplorationField();		
	}
	
	@Test
	public void addRobot_RobotAt12NAsParam__getPointStatusAtx1y2_ShouldReturnOne(){		
		ExplorationPoint point = new ExplorationPoint(1,2);
		Robot robot = new Robot(point, Orientation.NORTH);
		
		explorationField.addRobot(robot);		
		int status = explorationField.getPointStatus(point);
		
		assertEquals(status, ExplorationPoint.POINT_FILLED);		
	}
	
	@Test(expected=IllegalArgumentException.class)	
	public void addRobot_Receives5by5AsParam_ShouldThrowIllegalArgumentException_BecauseThePointIsOutOfFieldsBounds(){		
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
}

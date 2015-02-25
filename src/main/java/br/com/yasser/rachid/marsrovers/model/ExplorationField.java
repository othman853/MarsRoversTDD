package br.com.yasser.rachid.marsrovers.model;

import br.com.yasser.rachid.marsrovers.model.exception.PointFilledException;
import br.com.yasser.rachid.marsrovers.model.exception.RobotCollisionException;


public class ExplorationField {
	
	public static final int DEFAULT_WIDTH = 7;
	public static final int DEFAULT_HEIGHT = 7;	
	
	public static final int WIDTH_INDEX  = 0;
	public static final int HEIGHT_INDEX = 1;
	
	private int width;
	private int height;
	private int [][] field;
	
	public ExplorationField(){
		this.width = DEFAULT_WIDTH;
		this.height = DEFAULT_HEIGHT;
		
		field = new int [height][width];
	}	
	
	public ExplorationField(int width, int height){
		if(width <= 0){
			throw new IllegalArgumentException("Exploration Field width must be at least 1.");
		}
		
		if(height <= 0){
			throw new IllegalArgumentException("Exploration Field height must be at least 1.");
		}
		
		this.width = width;
		this.height = height;
		
		field = new int [height][width];		
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public void addRobot(Robot robot) throws IllegalArgumentException, PointFilledException{
		if(!isInsideFieldBounds(robot.getPoint())){
			throw new IllegalArgumentException("Specified coordinate is out of the exploration field's bounds.");						
		}		
		else if(field[robot.getPoint().getCoordinateX()][robot.getPoint().getCoordinateY()] == ExplorationPoint.POINT_FILLED){
			throw new PointFilledException("Point Already Filled");
		}
		else{
			field[robot.getPoint().getCoordinateX()][robot.getPoint().getCoordinateY()] = ExplorationPoint.POINT_FILLED;
		}					
	}
	
	public void executeCommand(Robot robot, Command command) throws RobotCollisionException, IllegalArgumentException{
		ExplorationPoint route = robot.trace(command);
		
		if(field[route.getCoordinateX()][route.getCoordinateY()] == ExplorationPoint.POINT_FILLED){
			throw new RobotCollisionException("The robot at " + robot.toString() + " will collide with another robot on command execution.");
		}
		
		else if(!isInsideFieldBounds(route)){
			throw new IllegalArgumentException("Command will lead the robot out of the exploration field.");
		}
		
		else{
			clear(robot.getPoint());
			robot.execute(command);
			fill(robot.getPoint());
		}
	}
	
	public boolean isInsideFieldBounds(ExplorationPoint point){
		return point.getCoordinateX()<= this.width && point.getCoordinateY()<=this.height;		
	}
	
	public int getPointStatus(ExplorationPoint point){
		return field[point.getCoordinateX()][point.getCoordinateY()];
	}
	
	private void clear(ExplorationPoint point){
		field[point.getCoordinateX()][point.getCoordinateY()] = ExplorationPoint.POINT_FREE;
	}
	
	private void fill(ExplorationPoint point){
		field[point.getCoordinateX()][point.getCoordinateY()] = ExplorationPoint.POINT_FILLED;
	}
	
	public void print(){
		for(int [] lines : field){
			for(int column : lines){
				System.out.print(" " + column + " " );
			}
			System.out.println();			
		}
	}
}
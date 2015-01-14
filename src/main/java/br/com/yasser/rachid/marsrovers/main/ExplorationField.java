package br.com.yasser.rachid.marsrovers.main;

public class ExplorationField {
	
	public static final int DEFAULT_WIDTH = 7;
	public static final int DEFAULT_HEIGHT = 7;	
	
	private int width;
	private int height;
	
	public ExplorationField(){
		this.width = DEFAULT_WIDTH;
		this.height = DEFAULT_HEIGHT;
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
		
	}
	
	public void addRobot(Robot robot, ExplorationPoint point) throws IllegalArgumentException{
		if(isInsideFieldBounds(point)){
			
			
		}
		else{
			throw new IllegalArgumentException("Specified coordinate is out of the exploration field's bounds.");
		}		
				
	}
	
	public boolean isInsideFieldBounds(ExplorationPoint point){
		return point.getCoordinateX()<= this.width && point.getCoordinateY()<=this.height;		
	}
	
	public int getPointStatus(ExplorationPoint point){
		return ExplorationPoint.POINT_FILLED;
	}

}

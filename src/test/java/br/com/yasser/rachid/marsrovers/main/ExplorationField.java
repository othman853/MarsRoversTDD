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
		
	}

}

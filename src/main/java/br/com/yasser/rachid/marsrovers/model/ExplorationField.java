package br.com.yasser.rachid.marsrovers.model;


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
	
	public void addRobot(Robot robot) throws IllegalArgumentException{
		if(isInsideFieldBounds(robot.getPoint())){
			field[robot.getPoint().getCoordinateX()][robot.getPoint().getCoordinateY()] = ExplorationPoint.POINT_FILLED;			
		}
		else{
			throw new IllegalArgumentException("Specified coordinate is out of the exploration field's bounds.");
		}					
	}
	
	public boolean isInsideFieldBounds(ExplorationPoint point){
		return point.getCoordinateX()<= this.width && point.getCoordinateY()<=this.height;		
	}
	
	public int getPointStatus(ExplorationPoint point){
		return field[point.getCoordinateX()][point.getCoordinateY()];
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
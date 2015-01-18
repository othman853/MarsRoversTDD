package br.com.yasser.rachid.marsrovers.model;

public class Robot {
	
	private ExplorationPoint point;
	private Orientation orientation;
	
	public Robot(ExplorationPoint point, Orientation orientation){
		this.point = point;
		this.orientation = orientation;
	}
	
	public void toLeft(){
				
	}
	
	public void toRight(){
		
	}
	
	public void move(){
		
	}
	
	@Override
	public String toString(){
		String robot = "";
		
		robot = Integer.toString(point.getCoordinateX());
		robot += " ";
		robot += Integer.toString(point.getCoordinateY());
		robot += " ";
		robot += orientation.toString();
		
		return robot;
	}
}

package br.com.yasser.rachid.marsrovers.main;

public class ExplorationPoint {
	
	public static final int POINT_FREE = 0;
	public static final int POINT_FILLED = 1;
	
	private int coordinateX;
	private int coordinateY;	
	
	
	public ExplorationPoint(int coordinateX, int coordinateY) {
		if(coordinateX < 0 ){
			throw new IllegalArgumentException("X coordinate can't be less than 0");
		}
		
		if(coordinateY < 0){
			throw new IllegalArgumentException("Y coordinate can't be less than 0");
		}
		
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}
	
	public int getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}
	public int getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}
}
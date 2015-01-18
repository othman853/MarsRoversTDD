package br.com.yasser.rachid.marsrovers.model;

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
	
	public ExplorationPoint(){
		
	}
	
	public int getCoordinateX() {
		return coordinateX;
	}
	
	public void setCoordinateX(int coordinateX) {
		if(coordinateX < 0 ){
			throw new IllegalArgumentException("X coordinate can't be less than 0");
		}
		
		this.coordinateX = coordinateX;
	}
	
	public int getCoordinateY() {
		return coordinateY;
	}
	
	public void setCoordinateY(int coordinateY) {
		if(coordinateY < 0){
			throw new IllegalArgumentException("Y coordinate can't be less than 0");
		}
		
		this.coordinateY = coordinateY;
	}
	
	public void increaseX(){
		coordinateX++;
	}
	
	public void decreaseX(){
		coordinateX = (coordinateX>0)? coordinateX++:coordinateX;
	}
	
	public void increaseY(){
		coordinateY++;
	}
	
	public void decreaseY(){
		coordinateY = (coordinateY>0)? coordinateY++:coordinateY;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coordinateX;
		result = prime * result + coordinateY;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExplorationPoint other = (ExplorationPoint) obj;
		if (coordinateX != other.coordinateX)
			return false;
		if (coordinateY != other.coordinateY)
			return false;
		return true;
	}	
}
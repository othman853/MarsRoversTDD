package br.com.yasser.rachid.marsrovers.model;

public enum Orientation {
	
	NORTH("N"),
	SOUTH("S"),
	EAST("E"),
	WEST("W");
	
	private final String orientation;
	
	Orientation(String orientation){
		this.orientation = orientation;
	}
	
	public String getOrientation(){
		return this.orientation;
	}
}

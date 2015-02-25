package br.com.yasser.rachid.marsrovers.model;

public class Robot {
	
	private static final int DIRECTION_RIGHT = 0;
	private static final int DIRECTION_LEFT  = 1;

	private ExplorationPoint point;
	private Orientation orientation;

	public Robot(ExplorationPoint point, Orientation orientation) {
		this.point = point;
		this.orientation = orientation;
	}
	
	public ExplorationPoint getPoint(){
		return this.point;
	}

	public void toLeft() {
		changeOrientation(DIRECTION_LEFT);
	}

	public void toRight() {
		changeOrientation(DIRECTION_RIGHT);
	}

	public void move() {
		switch (orientation) {
		case NORTH:
			point.increaseY();
			break;
		case EAST:
			point.increaseX();
			break;
		case WEST:
			point.decreaseX();
			break;
		case SOUTH:
			point.decreaseY();
			break;
		}
	}
	
	public void changeOrientation(int direction){
		switch (orientation) {
		case NORTH:
			orientation = (direction == DIRECTION_LEFT)? Orientation.WEST : Orientation.EAST;
			break;
		case EAST:
			orientation = (direction == DIRECTION_LEFT)? Orientation.NORTH: Orientation.SOUTH;
			break;
		case WEST:
			orientation = (direction == DIRECTION_LEFT)? Orientation.SOUTH : Orientation.NORTH;
			break;
		case SOUTH:
			orientation = (direction == DIRECTION_LEFT)? Orientation.EAST : Orientation.WEST;
			break;
		}
	}

	@Override
	public String toString() {
		String robot = "";

		robot = Integer.toString(point.getCoordinateX());
		robot += " ";
		robot += Integer.toString(point.getCoordinateY());
		robot += " ";
		robot += orientation.toString();

		return robot;
	}
}

package main;

import java.util.ArrayList;
import java.util.List;

import br.com.yasser.rachid.marsrovers.model.ExplorationPoint;

public class ExplorationPointBuilder implements Builder<ExplorationPoint>{

	public ExplorationPoint getSingle() {
		ExplorationPoint explorationPoint = new ExplorationPoint();
		
		return explorationPoint;
	}

	public List<ExplorationPoint> getMany(int amount) {
		ArrayList<ExplorationPoint> points = new ArrayList<ExplorationPoint>();
		
		for(int i = 0; i < amount; i++){
			ExplorationPoint point = new ExplorationPoint();
			
			points.add(point);
		}
		
		return points;
	}

}

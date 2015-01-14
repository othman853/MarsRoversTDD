package br.com.yasser.rachid.marsrovers.test;

import java.util.List;

public interface Builder<T> {
	
	public T getSingle();
	public List<T> getMany(int amount);

}

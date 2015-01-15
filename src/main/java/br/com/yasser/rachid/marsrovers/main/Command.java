package br.com.yasser.rachid.marsrovers.main;

public class Command {
	
	private StringBuilder command; 
	
	public Command(String command){
		this.command = new StringBuilder(command);
	}
	
	public void addCommand(String addedCommand){
		command.append(addedCommand);
	}
	
	public String get(){
		return command.toString();
	}

}

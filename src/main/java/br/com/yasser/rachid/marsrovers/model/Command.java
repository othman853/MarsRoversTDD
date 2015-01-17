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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((command == null) ? 0 : command.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Command other = (Command) obj;
		
		return this.command.toString().equals(other.get());
	}
}
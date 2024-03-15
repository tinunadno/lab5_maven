package org.lab5.commands;

import org.lab5.mainClasses.LabWorkListManager;
import org.lab5.storedClasses.LabWork;

public class Update extends Command implements CommandWithArgument {
	private String argument;
	@Override
	public void execute(){
		try {
			int index = Integer.parseInt(argument);
			LabWork labwork=LabWorkParser.parseLabWorkFromConsole();
			LabWorkListManager.set(index, labwork);
		}catch(NumberFormatException e){
			System.out.println("can't interpretate "+argument+" as integer");
		}
	}
	@Override
	public String getComment(){
		return "update id%обновить значение элемента коллекции, id которого равен заданному";
	}
	@Override
	public void setArgument(String arg){this.argument=arg;}
}
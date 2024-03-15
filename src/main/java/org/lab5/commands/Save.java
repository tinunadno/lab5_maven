package org.lab5.commands;

import org.lab5.mainClasses.LabWorkListManager;

public class Save extends Command implements CommandWithArgument {
	private String argument;
	@Override
	public void execute(){
		LabWorkListManager.save(argument.replace("\"", ""));
	}
	@Override
	public String getComment(){
		return "save%сохранить коллекцию в файл";
	}
	public void setArgument(String arg){this.argument=arg;}
}
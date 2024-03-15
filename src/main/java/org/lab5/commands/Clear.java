package org.lab5.commands;

import org.lab5.mainClasses.LabWorkListManager;

public class Clear extends Command{
	@Override
	public void execute(){
		LabWorkListManager.clear();
	}
	@Override
	public String getComment(){
		return "clear%очистить коллекцию";
	}
}
package org.lab5.commands;

import org.lab5.mainClasses.LabWorkListManager;

public class Add extends Command{
	@Override
	public void execute(){
		LabWorkListManager.append(LabWorkParser.parseLabWorkFromConsole());
	}
	@Override
	public String getComment(){
		return "add%добавить новый элемент в коллекцию";
	}
}
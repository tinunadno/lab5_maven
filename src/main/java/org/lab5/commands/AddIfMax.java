package org.lab5.commands;

import org.lab5.mainClasses.LabWorkListManager;

public class AddIfMax extends Command{
	@Override
	public void execute(){
		LabWorkListManager.addIfMax(LabWorkParser.parseLabWorkFromConsole());
	}
	@Override
	public String getComment(){
		return "add_if_max%добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
	}
}
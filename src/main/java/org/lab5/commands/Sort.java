package org.lab5.commands;

import org.lab5.mainClasses.LabWorkListManager;

public class Sort extends Command {
	@Override
	public void execute(){
		LabWorkListManager.sort();
	}
	@Override
	public String getComment(){
		return "sort%отсортировать коллекцию в естественном порядке";
	}
}
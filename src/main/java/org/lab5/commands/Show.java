package org.lab5.commands;

import org.lab5.mainClasses.LabWorkListManager;

public class Show extends Command {
	@Override
	public void execute(){
		System.out.println(LabWorkListManager.getCollectionAsString());
	}
	@Override
	public String getComment(){
		return "show%вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
	}
}
package org.lab5.commands;

import org.lab5.mainClasses.LabWorkListManager;

public class Info extends Command {
	@Override
	public void execute(){
		System.out.println(LabWorkListManager.getCollectionInfo());
	}
	@Override
	public String getComment(){
		return "info%вывести в стандартный поток вывода информацию о коллекции";
	}
}
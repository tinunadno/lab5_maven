package org.lab5.commands;

import org.lab5.mainClasses.LabWorkListManager;

public class PrintFieldAscendingDifficulty extends Command{
	@Override
	public void execute(){
		LabWorkListManager.printFieldAscendingDifficulty();
	}
	@Override
	public String getComment(){
		return "print_field_ascending_difficulty%вывести значения поля difficulty всех элементов в порядке возрастания";
	}
}
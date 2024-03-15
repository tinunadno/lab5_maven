package org.lab5.commands;
public class Exit extends Command {
	@Override
	public void execute(){
		System.exit(0);
	}
	@Override
	public String getComment(){
		return "exit%завершить программу (без сохранения в файл)";
	}
}
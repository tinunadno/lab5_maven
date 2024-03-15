package org.lab5.commands;

import org.lab5.storedClasses.LabWork;
import org.lab5.mainClasses.LabWorkListManager;
import org.lab5.mainClasses.CommandReg;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class ExecuteScript extends Command implements CommandWithArgument{
	private String argument;
	private Scanner scanner;
	private int recDepth=0;
	@Override
	public void execute(){
		try{
			//creating file scanner
			File file = new File(argument.replace("\"", ""));
			scanner =new Scanner(file);
			while(scanner.hasNext()){
				String cmd= scanner.nextLine();
				LabWork lw;
				//checking if next command need LabWork parse
				switch(cmd){
					case "add":
						LabWorkParser.setScanner(scanner);
						lw=LabWorkParser.parseLabWorkFromConsole();
						LabWorkListManager.append(lw);
						break;
					case "add_if_max":
						LabWorkParser.setScanner(scanner);
						lw=LabWorkParser.parseLabWorkFromConsole();
						LabWorkListManager.addIfMax(lw);
						break;
					case "Update":
						int index=Integer.parseInt(cmd.substring(0, cmd.indexOf(' ')));
						lw=LabWorkParser.parseLabWorkFromConsole();
						LabWorkListManager.set(index, lw);
						break;
					default:
						//checking recursion depth if next command is execute_script
						if((cmd.replaceAll("execute_script", "")).length()<cmd.length()) {
							if (++recDepth < 5)
								CommandReg.invoke(cmd);
							else
								recDepth = 0;
						}
						else{
							CommandReg.invoke(cmd);
						}
						break;
				}

			}
			System.out.println();
		}catch(FileNotFoundException e){System.out.println("file not found");}
	}
	@Override
	public String getComment(){
		return "execute_script%считать и исполнить скрипт из указанного файла. В скрипте команды содержатся в том же виду, в котором вводятся в консоль";
	}
	@Override
	public void setArgument(String arg){this.argument=arg;}
}
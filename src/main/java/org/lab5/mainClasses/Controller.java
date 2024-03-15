package org.lab5.mainClasses;

import org.lab5.commands.*;

import java.util.Map;
import java.util.HashMap;
public class Controller {
	/**
	 * 	Map with command objects and names
	 */

	private static Map<String, Command> comands=new HashMap<String, Command>();
	static{
		comands.put("help", new Help());
		comands.put("info", new Info());
		comands.put("show", new Show());
		comands.put("add", new Add());
		comands.put("update", new Update());
		comands.put("remove_by_id", new RemoveByID());
		comands.put("clear", new Clear());
		comands.put("exit", new Exit());
		comands.put("add_if_max", new AddIfMax());
		comands.put("remove_greater", new RemoveGreater());
		comands.put("filter_by_description", new FilterByDescription());
		comands.put("print_field_ascending_difficulty", new PrintFieldAscendingDifficulty());
		comands.put("min_by_name", new MinByName());
		comands.put("sort", new Sort());
		comands.put("save", new Save());
		comands.put("execute_script", new ExecuteScript());
	}

	/**
	 * Calls command object without argument
	 * @param key
	 */
	public static void invoke(String key){
		try{
		comands.get(key).execute();
		}catch(NullPointerException e){System.out.println("\""+key+"\" is not a command, use help for syntax");}
	}

	/**
	 * calls command object with argument
	 * @param key
	 * @param argument
	 */
	public static void invoke(String key, String argument){
		try{
			((CommandWithArgument)(comands.get(key))).setArgument(argument);
			comands.get(key).execute();
		}catch(NullPointerException e){
			System.out.println("\""+key+"\" is not a command, use help for syntax");
		}
	}

	/**
	 * showing command names and descriptions from commands Map
	 */
	public static void showComands(){
		System.out.println("commands without arguments:");
		for (CommandNoArgument value : comands.values()) {
			System.out.println(value.getComment().replace("%", "   "));
		}
	}
}
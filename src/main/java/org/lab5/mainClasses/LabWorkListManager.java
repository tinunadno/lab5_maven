package org.lab5.mainClasses;

import org.lab5.storedClasses.LabWork;
import org.lab5.storedClasses.Difficulty;
import org.lab5.storedClasses.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
public class LabWorkListManager{
	private static ArrayList<LabWork> list;
	private static java.time.LocalDate creationDate;

	/**
	 * initialize LabWork ArrayList
	 * @param list1
	 */
	public static void init(ArrayList<LabWork> list1){
		if(list==null){
			list=list1;
			creationDate=java.time.LocalDate.now();
		}
		else
			System.out.println("ArrayList already exists");
	}

	/**
	 * add LabWork Object to LabWork List
	 * @param lw
	 */
	
	public static void append(LabWork lw){
		list.add(lw);
	}

	/**
	 * replace LabWork object in ArrayList by its id in ArrayList
	 * @param id
	 * @param lw
	 */
	public static void set(int id, LabWork lw){list.set(id, lw);}

	/**
	 * removes LabWork object from ArrayList by its id
	 * @param id
	 */
	
	public static void remove(int id){

		try{list.remove(id);}
		catch(IndexOutOfBoundsException e){
			System.out.println("this index doesnt exists");
		}
	}

	/**
	 * clear ArrayList
	 */
	public static void clear(){
		Person.clearPassportBase();
		list.clear();
	}

	/**
	 * save ArrayList as json file
	 * @param way
	 */
	public static void save(String way){
		try (var fw = new FileWriter(way)) {
			fw.write(toJson());
		} catch (Exception e) {
			System.out.println("bad file name");
		}
	}

	/**
	 * add LabWork object if minimal point field is max
	 * @param lw
	 */
	public static void addIfMax(LabWork lw){
		boolean flag=true;
		for(LabWork labwork: list)
			flag=!(labwork.getMinimalPoint()>lw.getMinimalPoint());
		if(flag)append(lw);
	}

	/**
	 * removes LabWork object with max minimalPoint
	 * @param val
	 */
	public static void RemoveGreater(float val){
		for(int i=0;i<list.size();i++)
			if(list.get(i).getMinimalPoint()>val)remove(i);
	}

	/**
	 * shows LabWork objects with desired description
	 * @param description
	 */
	public static void FilterByDescription(String description){
		for(int i=0;i<list.size();i++)
			if(list.get(i).getDescription().equals(description))System.out.println(list.get(i).toString()+"\n");
	}

	/**
	 * print all LabWork objects sorted by difficulty
	 */
	public static void printFieldAscendingDifficulty(){
		for(Difficulty diff:Difficulty.values())
			for(int i=0;i<list.size();i++)
				if(list.get(i).getDifficulty()==diff)System.out.println(list.get(i).toString()+"\n");
	}

	/**
	 * print LabWork object with minimal name
	 */
	public static void printMinByName(){
		if(list.size()!=0){
			LabWork lw=list.get(0);
			for(int i=1;i<list.size();i++)
				if(lw.getName().length()>list.get(i).getName().length())lw=list.get(i);
			System.out.println(lw.toString());
		}
	}

	/**
	 * sort objects in ArrayList
	 */
	public static void sort(){
		Collections.sort(list);
	}

	/**
	 * print collection info (size, type, init date)
	 * @return
	 */
	public static String getCollectionInfo(){
		return "Collection info:[size:"+list.size()+", type:"+list.getClass()+", init date:"+creationDate+"]";
	}

	/**
	 * get Collection as String
	 * @return
	 */
	public static String getCollectionAsString(){
		if(list.size()==0)return "list is empty";
		String ret="";
		for (LabWork value : list) {
			ret+=(value.toString()+"\n\n");
		}
		return ret;
	}

	/**
	 * get Collection as String in json format
	 * @return
	 */
	public static String toJson(){
		String ret="{\n\"LabWorks\": [\n";
		for(int i=0;i<list.size()-1;i++)
			ret+=list.get(i).toJson()+",\n";
		ret+=list.get(list.size()-1).toJson()+"\n]\n}";
		return ret;
	}
}
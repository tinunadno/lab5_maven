package org.lab5;

import org.lab5.mainClasses.CommandReg;
import org.lab5.mainClasses.JsonToLabWork;
import org.lab5.mainClasses.LabWorkListManager;
import org.lab5.storedClasses.LabWork;

import java.util.ArrayList;
import java.util.Scanner;
public class Main{
	private static Scanner sc;
	public static void main(String[] args){
		sc=new Scanner(System.in);
		getFileFromWay();

		while(true){
			CommandReg.invoke(sc.nextLine().strip());
		}
	}

	private static void getFileFromWay(){
		System.out.print("insert way to boot file, insert \"null\" to create new collection:");
		boolean flag=false;
		while(!flag){
			flag=tryToGetWay();
		}

		System.out.println("Initialized succesfully!");
	}

	private static boolean tryToGetWay(){
		try{
			String message=(sc.nextLine()).replace("\"", "").strip();
			if(message.equals("null")) {
				ArrayList<LabWork> labWorks=new ArrayList();
				LabWorkListManager.init(labWorks);
			}
			else {
				ArrayList<LabWork> temp = JsonToLabWork.getLabWork(message);
				LabWorkListManager.init(temp);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
}

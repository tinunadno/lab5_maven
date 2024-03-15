package org.lab5.mainClasses;

public class CommandReg {
    /**
     * processing command
     * @param com
     */
    public static void invoke(String com){
        //checking if command have an argument
        if(com.length()-(com.replace(" ", "").length())!=0){
            //separating command name and its argument
            String commandArgument=com.substring(com.indexOf(' ')+1, com.length());
            com=com.substring(0, com.indexOf(' '));
            Controller.invoke(com, commandArgument);
        }
        else{
            Controller.invoke(com);
        }
    }

}

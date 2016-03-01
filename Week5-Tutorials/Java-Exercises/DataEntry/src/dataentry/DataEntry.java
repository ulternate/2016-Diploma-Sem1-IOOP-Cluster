/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataentry;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author 041601498
 * date 01/03/2016
 * 
 * methods
 *      + void main (String[] args)
 *      + void dataEntry()
 * 
 * class 
 *      + DataEntryObject
 * 
 */
public class DataEntry 
{
    static Scanner inputReader = new Scanner(System.in);
    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static ArrayList<DataEntryObject> dataBase = new ArrayList<DataEntryObject>();
    
        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        boolean cont = true;
        String loc;
        int dist, index;
        
        System.out.println("Please enter your choice of action on the database.");
        System.out.println("'add', 'edit', 'remove', 'print' or 'exit'");
        
        while (cont)
        {
            String choice = inputReader.nextLine();
            switch (choice)
            {
                case "add": case "Add": case "a": case "A":
                    System.out.println("Adding an entry");
                    System.out.println("Please enter your location, as a string" );
                    loc = inputReader.nextLine();
                    System.out.println("Please enter the distance, as an integer");
                    dist = inputReader.nextInt();
                    addEntry(loc, dist);
                    System.out.println("What would you like to do now? 'add', 'edit', 'remove', 'print' or 'exit'.");
                    break;
                    
                case "edit": case "Edit": case "e": case "E":
                    System.out.println("Editing an entry");
                    System.out.println("Please enter an entry between 0 and " + (dataBase.size() - 1));                    
                    index = inputReader.nextInt();
                    inputReader.nextLine(); //The int has a \n after it so the loc would normally just grab the new line character. this clears it.
                    System.out.println("Please enter your location, as a string" );
                    loc = inputReader.nextLine();
                    System.out.println("Please enter the distance, as an integer");
                    dist = inputReader.nextInt();
                    editEntry(index, loc, dist);                    
                    System.out.println("What would you like to do now? 'add', 'edit', 'remove', 'print' or 'exit'.");
                    break;
                    
                case "remove": case "Remove": case "r": case "R":
                    System.out.println("Removing an entry");
                    System.out.println("Please enter an entry between 0 and " + dataBase.size());
                    index = inputReader.nextInt();
                    removeEntry(index);
                    System.out.println("What would you like to do now? 'add', 'edit', 'remove', 'print' or 'exit'.");
                    break;
                    
                case "print": case "Print": case "p": case "P":
                    System.out.println("Here's the current database");
                    printEntries();
                    System.out.println("What would you like to do now? 'add', 'edit', 'remove', 'print' or 'exit'.");
                    break;
                    
                case "exit": case "Exit":
                    cont = false;
                    break;                    
            }
        }
    }
    
    public static void addEntry(String loc, int dist)
    {
        dataBase.add(new DataEntryObject(loc, dist));
    }
    
    public static void editEntry(int index, String nLoc, int nDist)
    {
        dataBase.get(index).setLocation(nLoc);
        dataBase.get(index).setDistance(nDist);
        dataBase.get(index).setDateModified();
    }
    
    public static void removeEntry(int index)
    {
        dataBase.remove(index);
    }
    
    public static void printEntries()
    {
        for(DataEntryObject dd : dataBase)
        {
            System.out.println(dd.toString());
        }
    }
      
    
    /**
     * 
     * A nested object class for the data entry objects
     * 
     * Methods:
     *      +DataEntryObject(String loc, int dist)
     *      +toString()
     *      +setLocation(String loc)
     *      +setDistance(int dist)
     *      +setDateModified()
     *      +getLocation
     *      +getDistance
     *      +getCreatedDate
     *      +getModifiedDate   
     */
    public static class DataEntryObject 
    {
        //DataEntry constants
        private String location, dateCreated, dateModified;
        private int distance;
    
        public DataEntryObject(String loc, int dist)
        {
            this.location = loc;
            this.distance = dist;
            this.dateCreated = dateFormat.format(new Date());
            this.dateModified = "";
        }
        
        @Override
        public String toString()
        {
            return ("DataObject = Location: " + this.getLocation() +
                        ", Distance: " + this.getDistance() +
                        ", Created: " + this.getCreatedDate() +
                        ", Modifed: " + this.getModifiedDate());
        }
        
        public void setLocation(String loc)
        {
            this.location = loc;
        }
        
        public void setDistance(int dist)
        {
            this.distance = dist;
        }
        
        public void setDateModified()
        {
            this.dateModified = dateFormat.format(new Date());
        }
        
        public String getLocation()
        {
            return this.location;
        }
        
        public int getDistance()
        {
            return this.distance;
        }
        
        public String getCreatedDate()
        {
            return this.dateCreated;
        }
        
        public String getModifiedDate()
        {
            return this.dateModified;
        }
    }
    
    
}

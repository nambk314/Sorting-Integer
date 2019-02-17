package com.sorting.client;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utility {
	public Utility() {
		
	}
	//Function to Read a file and put them in a String
	public List<Integer> ReadFile(String path) throws FileNotFoundException {
		List<Integer> result = new ArrayList<Integer>();
		
		//path = "test.txt";
		
		// TODO code application logic here

	    // // read KeyWestTemp.txt

	    // create token1

	    // for-each loop for calculating heat index of May - October

	    // create Scanner inFile1
	    Scanner inFile1 = new Scanner(new File(path)).useDelimiter(",\\s*");
	 

	    // while loop
	    while (inFile1.hasNext()) {
	    	  Integer token1 = inFile1.nextInt();
	  	      result.add(token1);
	      
	      
	    }
	    
	    
	    inFile1.close();

//	    Integer[] resultArray = result.toArray(new Integer[0]);

//	    for (Integer s : resultArray) {
//	      System.out.println(s);
//	    }
	    
	    return result;
	}
	
	public String WriteFile(List<Integer> source, String path) {
		
		
		try{
			  File file = new File(path);
			  if (file.createNewFile())
			  {
			      System.out.println("File is created!");
			  } else {
			      System.out.println("File already exists.");
			  }
	          FileWriter fr = new FileWriter(file);
//	          BufferedWriter br = new BufferedWriter(fr);
//	          PrintWriter out = new PrintWriter(br);
	          for(int i=0; i<source.size(); i++){
	              if(source.get(i) != null) {
	            	 String val = String.valueOf(source.get(i));
	            	  fr.write(val);
	            	  if (i != source.size() - 1) {
	            		  fr.write(","); 
	            	  }
	                  
	              }
	                   
	            	        
	          }
	          fr.close();
	           
	           
	      }
	       
	      catch(IOException e){
	       System.out.println(e);   
	      }
		return path;
	}
	
	
}

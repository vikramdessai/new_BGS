/**
	 * DataLoaderfromFile implements GeographicalObservationGetData interface
	 * This implementation is designed to read data from a whitespace(s) separated data values
	 * This class assumes that data is in correct format and does not contain any omissions
	 * There are no checks against the null values so make sure that data file contains values that are complete 
	 * and are in proper format
*/


package shaba.dessai.BGS.Action;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.xml.crypto.Data;

import shaba.dessai.BGS.Data.Borehole;
import shaba.dessai.BGS.Data.Fossil;
import shaba.dessai.BGS.Data.GeographicalObservation;
import shaba.dessai.BGS.Data.Measurement;
import shaba.dessai.BGS.Data.Rock;

public class FileDataLoader implements DataLoader {
	
		public ArrayList<GeographicalObservation> getData(InputStream is){
			
			ArrayList<GeographicalObservation> data = new ArrayList<GeographicalObservation>();
		
			//String fileName;
		
			//fileName = "E:/Data/Data.txt"; //hard coded for simplicity while developing
		
		
			/*try (Stream<String> stream = Files.lines(Paths.get(fileName))) {//changing this but this is the way forward
						stream.forEach(line -> getGeographicalObservationFromDataLine(line,data));

		
			} catch (IOException e) {
			
				System.out.println("\n\n!!!!!Make sure tyou specify absolute path of Data.txt at line 38 of shaba.dessai.BGS.Action.FileDataLoader.java !!!!! \n\n ");
			
			
				e.printStackTrace();
		
			}*/
			try{
				
				InputStreamReader isr = new InputStreamReader(is);
				
				BufferedReader reader = new BufferedReader(isr);
				
				String line = "";

				//
				// We read the file line by line and later will be loaded in memory 
				// browser page.
				//
				while ((line = reader.readLine()) != null) {
					
					getGeographicalObservationFromDataLine(line,data);
					
				}
			}catch (Exception e) {

				System.out.println("\n\n !!!!!Make sure to have Data/Data.txt under WEB-INF !!!!! \n\n ");
				e.printStackTrace();

			}
			
			
			
		
			printData(data);  // Printing for debugging purpose Have not added any annotations so will avoid here too
		
			return data;
	
		}
	
	
	
	
		private void printData(ArrayList<GeographicalObservation> data){
		
			for(GeographicalObservation gob:data){
			
				System.out.println("Data = "+gob);
		
			}
	
		}
	
	
		/**
	 * Converts a single line from the Data file to corresponding object
	 * Ideally this data needs to be represented in a more structured way like XML
	 * 
	 * This function breaks first two basic rules of SOLID programming, but once we have loaded data 
	 * there will be no need to worry. It is needed as data is structured in this particular form
	 */
		private static void getGeographicalObservationFromDataLine(String Line, ArrayList<GeographicalObservation> data){
		
			
			if (Line.contains("Name")) return;  // this is the header line of data Ignore it
		
		
			
			GeographicalObservation gobserv= null; // Each line of data is a new observation
		
		
			
			String [] strArray = Line.split("\\s+");
		
		
			
			LocalDateTime recording_DateTime = getRecordingDateTime(strArray[5], strArray[6]);
		
		
			// Assuming second value is always type, Not a good practice but just keeping it simple for lack of time
		
			if(strArray[1].equalsIgnoreCase("Borehole")){
			
				//TODO check data to be in correct format
			
				gobserv = new Borehole(strArray[0], Double.valueOf(strArray[2]), Double.valueOf(strArray[3]), Double.valueOf(strArray[4]), recording_DateTime, strArray[7], strArray[8], Double.valueOf(strArray[9]));
		
			}
		
			
			if(strArray[1].equalsIgnoreCase("Fossil")){
			
				//TODO check data to be in correct format
			
				
				gobserv = new Fossil(strArray[0], Double.valueOf(strArray[2]), Double.valueOf(strArray[3]), Double.valueOf(strArray[4]), recording_DateTime, strArray[7], strArray[8], strArray[9],strArray[10]);
		
			}
		
			
			if(strArray[1].equalsIgnoreCase("Rock")){
			
				//TODO check data to be in correct format
			
				gobserv = new Rock(strArray[0], Double.valueOf(strArray[2]), Double.valueOf(strArray[3]), Double.valueOf(strArray[4]), recording_DateTime, strArray[7], strArray[8], strArray[9], strArray[10]);
		
			}
		
			
			if(strArray[1].equalsIgnoreCase("Measurement")){
			
				//TODO check data to be in correct format
			
				gobserv = new Measurement(strArray[0], Double.valueOf(strArray[2]), Double.valueOf(strArray[3]), Double.valueOf(strArray[4]), recording_DateTime, strArray[7], strArray[8], Double.valueOf(strArray[9]));
		
			}
		
		
		
			data.add(gobserv);
	}
	
	
		
	/**
	 * Converts the string representation of date and time from data file into LocalDateTime value
	 * Assumes data is correct and do not check for exceptions
	 * Assumes data to be in the dd/mm/yyyy format
	 */
	
		
		private static  LocalDateTime getRecordingDateTime(String date,String time){
		
			String [] dateArr = date.split("/");
		
			
			String [] timeArr = time.split(":");
		
			
			// TODO: Check and handle exceptions properly
		
			
			int year = Integer.valueOf(dateArr[2]);
		
			
			int month = Integer.valueOf(dateArr[1]);  //Assuming Data in file to be in dd/mm/yyyy format
		
			
			int day = Integer.valueOf(dateArr[0]);
		
		
			int hr = Integer.valueOf(timeArr[0]);
		
			
			int min = Integer.valueOf(timeArr[1]);
		
			
			int sec = Integer.valueOf(timeArr[2]);
		
		
			LocalDateTime ldt = LocalDateTime.of(year,month,day,hr,min,sec);
		
		
			return ldt;
	
		}
	
	
	/**
	 * Gets the file name from console
	 * File name needs to be fully qualified URL
	 */
	
		private String getFileName(){
		
			String fileName = "";
		
			System.out.println("Enter data file name URI  : " );  // for testing enter Data/Data.txt
															// Will weed appropriate URI for different Data file locations
		 
			Scanner scanIn = new Scanner(System.in);
		 
			fileName = scanIn.nextLine();
		 
			scanIn.close();           
		 
			System.out.println("Name entered : " + fileName);
		
		    return fileName;
	
		}
	
	
	
	public static void main(String[] args){  //just for testing purposes
		
		FileDataLoader dlr = new FileDataLoader();
		
		//dlr.getData();
		
	}

}

package shaba.dessai.BGS.Action;

import java.util.ArrayList;

import shaba.dessai.BGS.Data.GeographicalObservation;


public class GeographicalObservationsAction {
	
	public int addGeographicalObservations(){
		
		int noOfRecords = 0;
		
		return noOfRecords;
		
	}
	
	public ArrayList<GeographicalObservation> getAllGeographicalObservations(){
		
		ArrayList<GeographicalObservation> geographicalObservationList = new ArrayList<GeographicalObservation>();
		
		return geographicalObservationList;
	
	}
	
	
	
	/**
	 * Take an array list containing all observations and name of observation and return
	 * corresponding observation(s).
	 * 
	 * 
	 * @param allObservations An arraylist containing all observations
	 * @param name String value containing Name of the desired geographical observation
	 * @return ArrayList<GeographicalObservation> containing all the geographical observations for the given name
	 */
	
	public ArrayList<GeographicalObservation> getGeographicalObservationByName(ArrayList<GeographicalObservation> allObservations,String name){
		
		ArrayList<GeographicalObservation> geographicalObservationList = new ArrayList<GeographicalObservation>();
		
		for(GeographicalObservation gob:allObservations){
			
			if (gob.getName().trim().equalsIgnoreCase(name.trim())){
				
				System.out.println("Check 002: "+gob);
				
				geographicalObservationList.add(gob);
				
			}
		}
		
		return geographicalObservationList;
	
	}
	
	
	
	/**
	 * Take an array list containing all observations and species of observation and return
	 * corresponding observation(s).
	 * 
	 * 
	 * @param allObservations An arraylist containing all observations
	 * @param name String value containing Name of the desired geographical observation
	 * @return ArrayList<GeographicalObservation> containing all the geographical observations for the given name
	 * @throws ClassNotFoundException 
	 */
	public ArrayList<GeographicalObservation> getGeographicalObservationBySpecies(ArrayList<GeographicalObservation> allObservations,String speciesName){
		
		ArrayList<GeographicalObservation> geographicalObservationList = new ArrayList<GeographicalObservation>();
		
		speciesName = "shaba.dessai.BGS.Data."+speciesName;
		
		Class obsClass;
		try {
			
			obsClass = Class.forName(speciesName.trim());
		
		for(GeographicalObservation gob:allObservations){
			
			if (obsClass.isInstance(gob)){
				
				geographicalObservationList.add(gob);
			
			}
		
		}
		
		} catch (ClassNotFoundException e) {
			
			System.out.println("Species nae not properly provided species naes are case sensitive and start with first letter as Caps"+speciesName);
			
			e.printStackTrace();
		
		}
		
		return geographicalObservationList;
	}
	
	
	/**
	 * Returns ArrayList containing all the geographical observations specified by the max and min coordinates
	 
	 * @param allObservations
	 
	 * @param max_X_Coordinate
	 
	 * @param max_Y_Coordinate
	 
	 * @param min_X_Coordinate
	 
	 * @param min_Y_Coordinate
	
	 * @return
	 
	 */
	public ArrayList<GeographicalObservation> getGeographicalObservationByXYCoordinate(ArrayList<GeographicalObservation> allObservations, double max_X_Coordinate, double max_Y_Coordinate, double min_X_Coordinate, double min_Y_Coordinate){
		
		ArrayList<GeographicalObservation> geographicalObservations = new ArrayList<GeographicalObservation>();
		
		System.out.println("Check 001: "+max_X_Coordinate+"  "+max_Y_Coordinate+"  "+min_X_Coordinate +"  "+min_Y_Coordinate);
		//System.out.println("Check 001.1 speciesName = : "+speciesName);
		
		for(GeographicalObservation gob:allObservations){
			//Assuming all the co-ordinates are non-negative
			
			if (gob.getX_coordinate()>= min_X_Coordinate  &&  
					
					gob.getX_coordinate()<= max_X_Coordinate  &&
					
					gob.getY_coordinate()>= min_Y_Coordinate  && 
					
					gob.getY_coordinate()<= max_Y_Coordinate 			
					
					){  
				
						geographicalObservations.add(gob);
						
						System.out.println("Check 002: "+gob);
					}
		}
		
		
		return geographicalObservations;
	}
}

package shaba.dessai.BGS.Servlets.Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shaba.dessai.BGS.Action.FileDataLoader;
import shaba.dessai.BGS.Action.GeographicalObservationsAction;
import shaba.dessai.BGS.Data.GeographicalObservation;

public class MainControllerUtilities {

	
	
	
	
	/**
	 * get Geographical observations filtered by name
	 * @param all_GeoObservations
	 * @param name
	 * @return
	 */
	public ArrayList<GeographicalObservation> pullGeographicalObservationsbyName(ArrayList<GeographicalObservation> all_GeoObservations,String name) {
		
		GeographicalObservationsAction geoObsAction = new GeographicalObservationsAction();
		
		ArrayList<GeographicalObservation> filtered_GeoObservations = new ArrayList<GeographicalObservation>();
		
		filtered_GeoObservations = geoObsAction.getGeographicalObservationByName(all_GeoObservations,name);
		
		return filtered_GeoObservations;
	
	}
	
	
	/**
	 * get Geographical observations filtered by species
	 * @param species
	 * @return
	 */
	public ArrayList<GeographicalObservation> pullGeographicalObservationsbySpecies(ArrayList<GeographicalObservation> all_GeoObservations,String species) {
		
		ArrayList<GeographicalObservation> filtered_GeoObservations;
		
		GeographicalObservationsAction geoObsAction = new GeographicalObservationsAction();
		
		filtered_GeoObservations = geoObsAction.getGeographicalObservationBySpecies(all_GeoObservations,species);
		
		return filtered_GeoObservations;
	}
	
	
	/**
	 * get Geographical observations filtered by X and Y coordinates(min,max)
	 * @param max_X_coordinated
	 * @param max_Y_coordinated
	 * @param min_X_coordinated
	 * @param min_Y_coordinated
	 * @return
	 */
	public ArrayList<GeographicalObservation> getGeographicalObservationsbyXYCoordinates(ArrayList<GeographicalObservation> all_GeoObservations,double max_X_coordinated,
			double max_Y_coordinated, double min_X_coordinated, double min_Y_coordinated) {
		
		ArrayList<GeographicalObservation> filtered_GeoObservations;
		
		GeographicalObservationsAction geoObsAction = new GeographicalObservationsAction();
		
		filtered_GeoObservations = geoObsAction.getGeographicalObservationByXYCoordinate(all_GeoObservations,max_X_coordinated, max_Y_coordinated, min_X_coordinated, min_Y_coordinated);
		
		return filtered_GeoObservations;
	}

	

	

	/**
	 * 
	 * Loads data from the data file into memory.
	 * Please note that the name of the data file is hardcoded and is absolute
	 * Just to get things done quickly
	 * 
	 * @param response
	 * @throws IOException
	 */
	public ArrayList<GeographicalObservation> loadData(ServletContext context) throws IOException {
		
		FileDataLoader FDL = new FileDataLoader();
		
		String filename = "/WEB-INF/Data/Data.txt";
		
		InputStream is = context.getResourceAsStream(filename);
		ArrayList<GeographicalObservation> all_GeoObservations  = FDL.getData(is);
		
		return all_GeoObservations;
	}

	
	
	
	
	/**
	 * Temporary worker method to generate response HTML
	 * 
	 * @return displayHtml String containing HTML code......know very bad practice
	 */
	public String displayObservations(ArrayList<GeographicalObservation> filtered_GeoObservations){
		
		
		String displayHTML = "<!DOCTYPE html><html lang=\"en\"><head> <meta charset=\"utf-8\"> <title>BGS SIMPLE UI Response</title>"+
								
				"<link rel=\"stylesheet\" href=\"css/style.css\"> </head><body>";
		
		displayHTML = displayHTML+ 
				"<div class='CSSTableGenerator' ><table width='100%'>"+
				
				"<tr><td>Name	</td><td >Type	</td> <td>X		</td><td>Y		</td><td >Z		</td> <td>Date		</td><td>Time		</td><td >Recorded by		</td> <td>Recorder email	</td><td>Drilled depth (m)	</td><td >Species	</td><td>Rock Name	</td><td>Porosity(Pt)	</td><td >Image	</td>";
		
		
		
		for(GeographicalObservation gobs:filtered_GeoObservations){
			
			displayHTML = displayHTML+"<tr>"+gobs.getHTML()+"</tr>";
		
		}
		
		
		displayHTML = displayHTML + "</table></div>";
		
		displayHTML = displayHTML + "<br><br> <a href = \"/BGS_Application/BGS_SimpleUIScreen.html\">Back </a> </body></html> ";
		return displayHTML;
		
	}
	
	
}

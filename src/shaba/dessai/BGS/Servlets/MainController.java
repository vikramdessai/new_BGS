package shaba.dessai.BGS.Servlets;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.InputStream;

import shaba.dessai.BGS.Action.FileDataLoader;
import shaba.dessai.BGS.Action.GeographicalObservationsAction;
import shaba.dessai.BGS.Data.GeographicalObservation;
import shaba.dessai.BGS.Servlets.Utilities.MainControllerUtilities;



/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	ArrayList<GeographicalObservation> all_GeoObservations = new ArrayList<GeographicalObservation>();
	MainControllerUtilities mainControllerUtilities = new MainControllerUtilities();
	  
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        
    	super();
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
    public void init() throws ServletException {
        //uploadFolder = new File("D:\\dev\\BGS\\uploads");
    }

	
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchvalue = request.getParameter("searchvalue");
		
		System.out.println("Test MC11 searchvalue = "+searchvalue);
		
		if(searchvalue.equalsIgnoreCase("loaddata")){
			
			ServletContext context = getServletContext();
			
			all_GeoObservations = mainControllerUtilities.loadData(context);
			if(all_GeoObservations.isEmpty()){
				
				response.getWriter().append("<b>!!!!! Please make sure that Data.txt file is present in WEB-INF/Data directory !!!!! </b>");	
			
			}else{
				
				response.getWriter().append("Data loaded ");
			
			}
			response.getWriter().append("<br> <a href = \"/BGS_Application/BGS_SimpleUIScreen.html\">Back </a> ");
			
		
		}
		
		if(searchvalue.equalsIgnoreCase("name")){
			
			String name = request.getParameter("name");
			
			ArrayList<GeographicalObservation> filtered_GeoObservations = new ArrayList<GeographicalObservation>();
			
			filtered_GeoObservations = mainControllerUtilities.pullGeographicalObservationsbyName(all_GeoObservations,name);
			
			response.getWriter().append(mainControllerUtilities.displayObservations(filtered_GeoObservations));
		
		}
		
		if(searchvalue.equalsIgnoreCase("species")){
			
			String species = request.getParameter("species");
			
			ArrayList<GeographicalObservation> filtered_GeoObservations = new ArrayList<GeographicalObservation>();
			
			filtered_GeoObservations = mainControllerUtilities.pullGeographicalObservationsbySpecies(all_GeoObservations,species);
			
			response.getWriter().append(mainControllerUtilities.displayObservations(filtered_GeoObservations));
		
		}
		
		if(searchvalue.equalsIgnoreCase("xycoordinates")){
			
			String max_X_coordinate = request.getParameter("Max_X-Coordinate");
			
			String max_Y_coordinate = request.getParameter("Max_Y-Coordinate");
			
			String min_X_coordinate = request.getParameter("Min_X-Coordinate");
			
			String min_Y_coordinate = request.getParameter("Min_Y-Coordinate");
			
			//TODO: need to add NULL checks
			double max_X_coordinated = Double.valueOf(max_X_coordinate);
			
			double max_Y_coordinated = Double.valueOf(max_Y_coordinate);
			
			double min_X_coordinated = Double.valueOf(min_X_coordinate);
			
			double min_Y_coordinated = Double.valueOf(min_Y_coordinate);
			
			
			ArrayList<GeographicalObservation> filtered_GeoObservations = new ArrayList<GeographicalObservation>();
			
			filtered_GeoObservations = mainControllerUtilities.getGeographicalObservationsbyXYCoordinates(all_GeoObservations,max_X_coordinated, max_Y_coordinated,
					min_X_coordinated, min_Y_coordinated);
			
			response.getWriter().append(mainControllerUtilities.displayObservations(filtered_GeoObservations));
		
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	
	}
	

}

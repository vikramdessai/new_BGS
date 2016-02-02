package shaba.dessai.BGS.Data;

import java.time.LocalDateTime;

public class Borehole extends GeographicalObservation{
	
	
	private double drilled_depth ;  // in meters

	
	
	public Borehole(String name, double x_coordinate, double y_coordinate, double z_coordinate,
			
			LocalDateTime recording_Date, String recordedBy, String recorderEmail, double drilled_depth) {
		
		
		super(name, x_coordinate, y_coordinate, z_coordinate, recording_Date, recordedBy, recorderEmail);
		
		
		this.drilled_depth = drilled_depth;
	
	}
	
	
	public String toString(){
		
		return super.toString()+ " drilled_depth = "+drilled_depth;
	
	}

	
	public double getDrilled_depth() {
		
		return drilled_depth;
	
	}

	
	public void setDrilled_depth(double drilled_depth) {
		
		this.drilled_depth = drilled_depth;
	
	}
	
	
	public String getHTML(){
		
		String HTMLData ="";
		
		
		HTMLData = super.getHTML();
		
		
		HTMLData = HTMLData+ "<td>"+getDrilled_depth()+"</td>"+"<td>N/A</td>"+"<td>N/A</td>"+"<td>N/A</td>"+"<td>N/A</td>";
		
		
		return HTMLData;
	
	}
	
	
}

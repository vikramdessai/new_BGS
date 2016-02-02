package shaba.dessai.BGS.Data;

import java.time.LocalDateTime;

public class Measurement extends GeographicalObservation{
	
	private double porosity ;  // 

	public Measurement(String name, double x_coordinate, double y_coordinate, double z_coordinate,
			LocalDateTime recording_Date, String recordedBy, String recorderEmail, double porosity) {
		
		
		super(name, x_coordinate, y_coordinate, z_coordinate, recording_Date, recordedBy, recorderEmail);
		
		this.porosity = porosity;
	
	}
	
	public String toString(){
		
		return super.toString()+ " porosity = "+porosity;
	}

	public double getPorosity() {
		
		return porosity;
	
	}

	public void setPorosity(double porosity) {
		
		this.porosity = porosity;
	
	}
	
	public String getHTML(){
		
		String HTMLData ="";
		
		HTMLData = super.getHTML();
		
		HTMLData = HTMLData+"<td>N/A</td>"+"<td>N/A</td>"+"<td>N/A</td>"+ "<td>"+getPorosity()+"</td>"+"<td>N/A</td>";
		
		return HTMLData;
	
	}


}

package shaba.dessai.BGS.Data;

import java.time.LocalDateTime;

public class Rock extends GeographicalObservation{
	
	private String rock_Name;
	
	private String image;
	
	public Rock(String name, double x_coordinate, double y_coordinate, double z_coordinate,
			
			LocalDateTime recording_Date, String recordedBy, String recorderEmail, String rock_Name, String image) {
		
		
		super(name, x_coordinate, y_coordinate, z_coordinate, recording_Date, recordedBy, recorderEmail);
		
		
		this.rock_Name = rock_Name;
		
		
		this.image = image;
	
	}
	
	public String toString(){
		
		
		return super.toString()+"<td>N/A</td>"+"<td>N/A</td>"+ " rock_Name = "+rock_Name+"<td>N/A</td>"+" image = "+image;
	
	}

	public String getRock_Name() {
		
		
		return rock_Name;
	
	
	}

	public void setRock_Name(String rock_Name) {
		
		
		this.rock_Name = rock_Name;
	
	}

	public String getImage() {
		
		return image;
	
	}

	public void setImage(String image) {
		
		
		this.image = image;
	
	}
	
	public String getHTML(){
		
		String HTMLData ="";
		
		
		HTMLData = super.getHTML();
		
		
		HTMLData = HTMLData+"<td>N/A</td>"+"<td>N/A</td>"+ "<td>"+getRock_Name()+"</td>"+"<td>N/A</td>"+"<td><img src=\"Data/"+getImage()+"\" height=\"50\" width=\"50\"></td>";
		
		
		return HTMLData;
	}
	
	
	
}


package shaba.dessai.BGS.Data;

import java.time.LocalDateTime;

public class Fossil extends GeographicalObservation{
	
	
	private String species;
	
	
	private String image;
	
	
	public Fossil(String name, double x_coordinate, double y_coordinate, double z_coordinate,
			LocalDateTime recording_Date, String recordedBy, String recorderEmail, String species, String image) {
		
		super(name, x_coordinate, y_coordinate, z_coordinate, recording_Date, recordedBy, recorderEmail);
		
		
		this.species = species;
		
		
		this.image = image;
	
	}
	
	
	
	public String toString(){
		
		return super.toString()+ " species = "+species+ " image = "+image;
	
	}

	
	public String getSpecies() {
		
		
		return species;
	
	
	}

	
	
	public void setSpecies(String species) {
		
		
		this.species = species;
	
	
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
		
		HTMLData = HTMLData+"<td>N/A</td>"+ "<td>"+getSpecies()+"</td>" +"<td>N/A</td>"+"<td>N/A</td>"+"<td><img src=\"Data/"+getImage()+"\" height=\"50\" width=\"50\"></td>";
		
		return HTMLData;
	}
	
	
}

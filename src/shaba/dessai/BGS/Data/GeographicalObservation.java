package shaba.dessai.BGS.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.LocalDateTime;

public class GeographicalObservation {
		
	private String name;
		
	private double x_coordinate;
		
	private double y_coordinate;
		
	private double z_coordinate;
		
	private LocalDateTime recording_Date;  // To Do : Decide to use Date time combined or separately
		
	private String recordedBy;
		
	private String recorderEmail;
		
	public GeographicalObservation(String name, double x_coordinate, double y_coordinate,
				double z_coordinate, LocalDateTime recording_Date, String recordedBy, String recorderEmail) {
			
		super();
			
		this.name = name;
			
		this.x_coordinate = x_coordinate;
			
		this.y_coordinate = y_coordinate;
			
		this.z_coordinate = z_coordinate;
			
		this.recording_Date = recording_Date;
			
		this.recordedBy = recordedBy;
			
		this.recorderEmail = recorderEmail;
		
	}
		
		
	public String toString(){
			
		return "name = "+name+" x_coordinate = "+x_coordinate+" y_coordinate = "+y_coordinate+" z_coordinate = "+z_coordinate+" recording_Date = "+recording_Date+" recordedBy = "+recordedBy+" recorderEmail = "+recorderEmail;
		
	}

		
	public String getName() {
			
		return name;
		
	}

		
	public void setName(String name) {
			
		this.name = name;
		
	}

		
	public double getX_coordinate() {
			
		return x_coordinate;
		
	}

		
	public void setX_coordinate(double x_coordinate) {
			
		this.x_coordinate = x_coordinate;
		
	}

		
	public double getY_coordinate() {
			
		return y_coordinate;
		
	}

		
	public void setY_coordinate(double y_coordinate) {
			
		this.y_coordinate = y_coordinate;
		
	}

		
	public double getZ_coordinate() {
			
		return z_coordinate;
		
	}

		
	public void setZ_coordinate(double z_coordinate) {
			
		this.z_coordinate = z_coordinate;
		
	}

		
	public LocalDateTime getRecording_Date() {
			
		return recording_Date;
		
	}

		
	public void setRecording_Date(LocalDateTime recording_Date) {
			
		this.recording_Date = recording_Date;
		
	}

		
	public String getRecordedBy() {
			
		return recordedBy;
		
	}

		
	public void setRecordedBy(String recordedBy) {
			
		this.recordedBy = recordedBy;
		
	}

		
	public String getRecorderEmail() {
			
		return recorderEmail;
		
	}

		
	public void setRecorderEmail(String recorderEmail) {
			
		this.recorderEmail = recorderEmail;
		
	}
		
		
	public String getHTML(){
			
		String HTMLData ="";
			
		HTMLData = "<td>"+getName()+"</td>"+"<td>"+this.getClass().getSimpleName()+"</td>"+
			
				"<td>"+getX_coordinate()+"</td>"+"<td>"+getY_coordinate()+
			
				"</td>"+"<td>"+getZ_coordinate()+"</td>"+"<td>"+
			
				getRecording_Date().toLocalDate()+"</td>"+"<td>"+getRecording_Date().toLocalTime()+
							
				"</td>"+"<td>"+getRecordedBy()+"</td>"+"<td>"+
			
				getRecorderEmail()+"</td>";
			
			
		return HTMLData;
		
	}
		
		
			
}

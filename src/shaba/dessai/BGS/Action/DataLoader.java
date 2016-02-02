package shaba.dessai.BGS.Action;

import java.io.InputStream;
import java.util.ArrayList;

import shaba.dessai.BGS.Data.GeographicalObservation;

public interface DataLoader {
	
		public ArrayList<GeographicalObservation> getData(InputStream is);

}

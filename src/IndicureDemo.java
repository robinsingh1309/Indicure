import java.io.IOException;

import extract.Hospitals;
import extract.IndicureHospitalsUrl;

public class IndicureDemo {

	public static void main(String[] args) throws IOException {
		
		// to extract urls
		IndicureHospitalsUrl extractUrl = new IndicureHospitalsUrl();
		extractUrl.extractHospitalsSpecialiatyUrls();

		
		// to extract data from the different url
		Hospitals hospitalsData = new Hospitals();
		hospitalsData.extractHospitalsData();
		
		
		System.out.println("Process Finished....");
	}

}

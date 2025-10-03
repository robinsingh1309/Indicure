import extract.IndicureHospitalsUrl;

public class IndicureDemo {

	public static void main(String[] args) {
		
		IndicureHospitalsUrl extractUrl = new IndicureHospitalsUrl();
		
		extractUrl.extractHospitalsSpecialiatyUrls();

		System.out.println("Process Finished....");
	}

}

package extract;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.jsoup.nodes.Document;

import service.IndicureUrlConnection;

public class IndicureHospitalsUrl {

	private IndicureUrlConnection urlConnection;
	private final String filePathToStoreHospitalsUrls = "/home/robin/eclipse-workspace/Indicure/csv/hospitalsCategoryUrls.csv";
	
	public IndicureHospitalsUrl() 
	{
		this.urlConnection = new IndicureUrlConnection();
	}
	
	public void extractHospitalsSpecialiatyUrls() 
	{
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePathToStoreHospitalsUrls)))
		{
			// TODO: add the homepage URL
			Document htmlDocument = urlConnection.getUrlConnect("");
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
}

package extract;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.logging.Logger;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import service.IndicureUrlConnect;
import url.IndicureUrl;

public class IndicureHospitalsUrl {

	private final String indicureUrl = IndicureUrl.INDICURE_URL.getValue();
	private IndicureUrlConnect urlConnection;
	
	private final String filePathToStoreHospitalsUrls = "/home/robin/eclipse-workspace/Indicure/csv/hospitalsCategoryUrls.csv";
	private Logger logger = Logger.getLogger(IndicureHospitalsUrl.class.getName());
	
	public IndicureHospitalsUrl() {
		this.urlConnection = new IndicureUrlConnect();
	}
	
	
	public void extractHospitalsSpecialiatyUrls() 
	{
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePathToStoreHospitalsUrls)))
		{
			
			Document htmlDocument = urlConnection.getUrlConnect(indicureUrl);
			logger.info("Parsing the HTML document");
			
			/**
			 *  extracted the only essential parts that contains hospitals url with their speciality
			 * 
			 *  I am sure of the website structure so that's why i used child concept over here
			 *  in case, in future their structure gets changed we just modify the below line and the rest would be same
			 */
			Elements ulListElements = htmlDocument.select("#main-menu > ul > li:nth-child(4) > ul > li > a");
			logger.info("Into the li for the urls in the htmlDocument");
			
			for(Element element : ulListElements) 
			{
				String url = element.attr("href");
				
				// write the urls in the csv file
				writer.write(indicureUrl + url + "\n");
			}
			
		} catch (Exception e) {
			logger.info("Problem in the url connection: " + e.getMessage());
		}
	}
}
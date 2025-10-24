package extract;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Logger;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import service.IndicureUrlConnection;
import url.IndicureUrl;

public class Hospitals {

    private final String indicureUrl = IndicureUrl.INDIDURE_URL.getValue();
    private IndicureUrlConnection urlConnection;
    
    private final String filePathToStoreHospitalsUrls = "/home/robin/eclipse-workspace/Indicure/csv/data/%s.csv";
    private Logger logger = Logger.getLogger(Hospitals.class.getName());
    
    public Hospitals() {
        this.urlConnection = new IndicureUrlConnection();
    }
    
    public void extractHospitalsData() {
    	
        String fileNameToBeRead = "/home/robin/eclipse-workspace/Indicure/csv/hospitalsCategoryUrls.csv";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileNameToBeRead))) {
        
        	String line;
            
            while ((line = reader.readLine()) != null) {
            
            	String[] urlSplit = line.split("/");
                String fileName = urlSplit[urlSplit.length - 1];
                
                String outputFileName = String.format(filePathToStoreHospitalsUrls, fileName);
                
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                    
                    writer.write("HospitalName,Speciality,HospitalImage,Location,Description");
                    writer.newLine();
                    
                    Document htmlDocument = urlConnection.getUrlConnect(line);
                    logger.info("Parsing HTML for: " + line);
                    
                    Elements classElementLists = htmlDocument.select(".medical__body");
                    
                    for (Element element : classElementLists) {
                    
                    	String hospitalName = element.selectFirst(".bg-grey.rright > h3").text();
                    	String speciality = element.select(".speciality").text().isEmpty() ? "Info Not Available" : element.select(".speciality").text();
                        String hospitalImage = indicureUrl + element.select(".bg-grey.rleft.text-center > img").attr("src");
                        String hospitalLocation = element.select(".city").text();
                        
                        Elements hospitalDescElements = element.select(".medical__body div.bg-grey.rright p.mt20");
                        StringBuilder hospitalDescBuilder = new StringBuilder();
                        
                        for(Element descElement : hospitalDescElements) 
                        {
                            hospitalDescBuilder.append(descElement.text());
                        }
                        
                        writer.write("\"" + hospitalName + "\",\"" + speciality + "\",\"" + hospitalImage + "\",\"" + hospitalLocation + "\",\""  + hospitalDescBuilder.toString() + "\"");
                        writer.newLine();
                    }
                    
                } catch (Exception e) {
                    logger.severe("Problem parsing hospital page: " + line + " " + e);
                }
            }
        } catch (Exception e) {
            logger.severe("Problem reading hospital category file: " + e);
        }
    }   
}
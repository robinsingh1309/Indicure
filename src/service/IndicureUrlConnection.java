package service;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class IndicureUrlConnection {
	
	public Document getUrlConnect(String webUrl) throws IOException 
	{
		return Jsoup.connect(webUrl)
				.userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/140.0.0.0 Safari/537.36")
				.referrer("https://www.indicure.com/")
				.timeout(5000)
				.header("cookie", "PHPSESSID=j5kmi79bakuh02nnkud933g0ja; _gcl_au=1.1.739462609.1759468074; _gid=GA1.2.835523243.1759468074; _clck=10yosmw%5E2%5Efzu%5E0%5E2102; _ga_TK0BYLS2S0=GS2.1.s1759468074$o1$g1$t1759468153$j55$l0$h0; _ga=GA1.2.4677509.1759468074; _gat_UA-262455950-1=1; _uetsid=eb21ce00a01611f0b5068d300063ded3; _uetvid=eb220620a01611f0ae03ab39c0e72f1a; _clsk=tyadch%5E1759468154245%5E6%5E1%5Eh.clarity.ms%2Fcollect")
				.method(Connection.Method.GET)
				.get();
	}
	
}
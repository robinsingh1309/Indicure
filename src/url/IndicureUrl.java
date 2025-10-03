package url;

public enum IndicureUrl {

	INDIDURE_URL("https://www.indicure.com");
	
	private String url;
	
	private IndicureUrl(String url) {
		this.url = url;
	}
	
	public String getValue() {
		return url;
	}
	
}

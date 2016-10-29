package creationJSON;

public class Country {
	
	private String latitude;
	private String longitude;
	private String countryName;
	
	public Country(String latitude, String longitude, String countryName){
		this.countryName = countryName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getCountryName() {
		return countryName;
	}
}
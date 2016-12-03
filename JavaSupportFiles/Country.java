package creationJSON;

public class Country {
	
	private String latitude = "0";
	private String longitude = "0";
	private String countryName = "0";
	private String magnitude = "0";
	
	public Country(String latitude, String longitude, String countryName, String magnitude){
		this.countryName = countryName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.magnitude = "0";
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

	public String getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(String magnitude) {
		this.magnitude = magnitude;
	}
}
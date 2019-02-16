package creationJSON;

public class JSONDriver {

	public static void main(String[] args) {
		
		JSONWriter jsonWriter = new JSONWriter();
		jsonWriter.createEntry("1", "http://www.nationmaster.com/country-info/stats/Geography/Land-area/Square-miles");
		jsonWriter.createEntry("2", "http://www.nationmaster.com/country-info/stats/Culture/Food-and-drink/Beer-consumption");
		jsonWriter.createEntry("3", "http://www.nationmaster.com/country-info/stats/Crime/Violent-crime/Murder-rate");
		jsonWriter.createEntry("4", "http://www.nationmaster.com/country-info/stats/Agriculture/Agricultural-land/Sq.-km");
		jsonWriter.createEntry("5", "http://www.nationmaster.com/country-info/stats/Energy/Oil/Consumption");
		jsonWriter.createEntry("6", "http://www.nationmaster.com/country-info/stats/Conflict/Civil-war-and-unrest/Arab-Spring-death-toll");
		jsonWriter.createEntry("7", "http://www.nationmaster.com/country-info/stats/Cost-of-living/Clothing-and-shoe-prices/Shoes/Pair-of-Nikes");
		jsonWriter.createEntry("1", "http://www.nationmaster.com/country-info/stats/Economy/GDP-per-capita");
		jsonWriter.createEntry("9", "http://www.nationmaster.com/country-info/stats/Culture/Happy-Planet-Index");
		jsonWriter.createEntry("10", "http://www.nationmaster.com/country-info/stats/Culture/World-Heritage-Sites");
		jsonWriter.createEntry("11", "http://www.nationmaster.com/country-info/stats/Disasters/Chernobyl/Contaminated-area-%28percent-of-country%29");
		jsonWriter.createEntry("12", "http://www.nationmaster.com/country-info/stats/Disasters/Storm-deaths/2009");
		jsonWriter.createEntry("13", "http://www.nationmaster.com/country-info/stats/Economy/Population-below-poverty-line");
		jsonWriter.createEntry("14", "http://www.nationmaster.com/country-info/stats/Education/Adult-literacy-rate/Total");
		jsonWriter.createEntry("15", "http://www.nationmaster.com/country-info/stats/Energy/Electric-power-consumption/KWh-per-capita");
		jsonWriter.createEntry("16", "http://www.nationmaster.com/country-info/stats/Military/Air-force/Combat-aircraft");
		
		jsonWriter.write();
	}
}

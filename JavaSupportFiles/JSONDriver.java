package creationJSON;

public class JSONDriver {

	public static void main(String[] args) {
		
		JSONWriter jsonWriter = new JSONWriter();
		//jsonWriter.createEntry("1990", "http://www.nationmaster.com/country-info/stats/Culture/Food-and-drink/Beer-consumption");
		jsonWriter.createEntry("1", "http://www.nationmaster.com/country-info/stats/Economy/GDP-per-capita");
		//jsonWriter.createEntry("2", "http://www.nationmaster.com/country-info/stats/Economy/GDP-per-capita");
		//jsonWriter.createEntry("3", "http://www.nationmaster.com/country-info/stats/Economy/GDP-per-capita");

		jsonWriter.createEntry("2", "http://www.nationmaster.com/country-info/stats/Crime/Violent-crime/Murder-rate");
		jsonWriter.createEntry("3", "http://www.nationmaster.com/country-info/stats/Agriculture/Agricultural-land/Sq.-km");
		//jsonWriter.createEntry("4", "http://www.nationmaster.com/country-info/stats/Agriculture/Arable-land/Hectares");
		//jsonWriter.createEntry("4", "http://www.nationmaster.com/country-info/stats/Conflict/Civil-war-and-unrest/Arab-Spring-death-toll");
		//jsonWriter.createEntry("4", "http://www.nationmaster.com/country-info/stats/Cost-of-living/Clothing-and-shoe-prices/Shoes/Pair-of-Nikes");
		//jsonWriter.createEntry("4", "http://www.nationmaster.com/country-info/stats/Crime/Rape-rate");
		//jsonWriter.createEntry("9", "http://www.nationmaster.com/country-info/stats/Culture/Happy-Planet-Index");
		
		jsonWriter.write();
	}
}

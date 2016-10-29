package creationJSON;

public class JSONDriver {

	public static void main(String[] args) {
		
		JSONWriter jsonWriter = new JSONWriter();
		jsonWriter.createEntry("1990", "http://www.nationmaster.com/country-info/stats/People/Population-in-2015");
		jsonWriter.createEntry("1995", "http://www.nationmaster.com/country-info/stats/Economy/GDP");
		jsonWriter.createEntry("2000", "http://www.nationmaster.com/country-info/stats/Culture/Food-and-drink/Beer-consumption");
		jsonWriter.write();
	}
}

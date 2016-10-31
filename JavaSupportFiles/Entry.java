package creationJSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class Entry {
	
	String fieldName, link;
	String data;
	StringBuffer entryString = new StringBuffer();
	
	public Entry(String fieldName, String link){
		this.fieldName = fieldName;
		this.link = link;
		data = getData();
		
	}
	
	public StringBuffer getEntry(){
		JSONWriter.refreshHashMap();
		entryString.append("[");
		entryString.append("\"" + fieldName + "\",[");
		boolean addedFirst = false;
		double max = retrieveMax();
		
		Iterator<java.util.Map.Entry<String, Country>> it = JSONWriter.hashMap.entrySet().iterator();
		
		while (it.hasNext()){
			Country country = it.next().getValue();

			if (!addedFirst){
				entryString.append(country.getLatitude());
				addedFirst = true;
			} else {
				entryString.append("," + country.getLatitude());
			}
			entryString.append("," + country.getLongitude());
			double mag = Double.parseDouble(country.getMagnitude()) / max;
			if (mag < .001){
				mag = .001;
			}
			entryString.append("," + mag);
		}
		
		entryString.append("]]");
		return entryString;
	}
	
	private String getData(){
		URL url;
		HttpURLConnection connection;
		BufferedReader BR;
		String line;
		StringBuffer dataString = new StringBuffer();
		boolean myDataFound = false;
		boolean myDataEndFound = false;
		
		try {
			url = new URL(link);
		    connection = (HttpURLConnection) url.openConnection();
		    connection.setRequestProperty("User-Agent", "Mozilla/5.0");
		    connection.setRequestMethod("GET");
		    BR = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		 
		    while ((line = BR.readLine()) != null) {	
		    	if (!myDataFound && line.length() > 21){
		    		for (int i = 0;i <= line.length() - 21;i++){
		    			if (line.substring(i, i + 21).equals("MAP_DATA = {\"data\": {")){
		    				myDataFound = true;
		    				break;
		    			}
		    		}
		    	}
				if (myDataFound){
					dataString.append(line);
					if (line.length() > 3){
				    	for (int i = 0;i <= line.length() - 3;i++){
				       		if (line.substring(i, i + 3).equals("}};")){
						       	myDataEndFound = true;
						       	break;
						    }
					    }
				    }
				    if (myDataEndFound){
				    	break;
				   	}
				}
			}
			BR.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return dataString.toString();
	}
	
	private double retrieveMax(){
		double max = 0;//ok because no negative magnitudes
		
		for (int i = 21;i <= data.length() - 2;i++){
			String tempCode = data.substring(i, i + 2);
			if (JSONWriter.hashMap.containsKey(tempCode)){
				int j = i + 5;
				String mag = "";
				while (!(data.substring(j, j+1).equals(",") || data.substring(j, j+1).equals("}"))){
					mag += data.substring(j, j+1);
					j++;
				}
				if (Double.parseDouble(mag) > max){
					max = Double.parseDouble(mag);
				}
				JSONWriter.hashMap.get(tempCode).setMagnitude(mag);
			}
		}
		return max;
	}
	
}

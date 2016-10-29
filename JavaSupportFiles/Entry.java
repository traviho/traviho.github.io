package creationJSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
		entryString.append("[");
		entryString.append("\"" + fieldName + "\",[");
		boolean addedFirst = false;
		for (int i = 0;i <= data.length() - 2;i++){
			String tempCode = data.substring(i, i + 2);
			if (JSONWriter.hashMap.containsKey(tempCode)){
				if (!addedFirst){
					entryString.append(JSONWriter.hashMap.get(tempCode).getLatitude());
				} else {
					entryString.append("," + JSONWriter.hashMap.get(tempCode).getLatitude());
				}
				entryString.append("," + JSONWriter.hashMap.get(tempCode).getLongitude());
				entryString.append("," + "1");
				addedFirst = true;
			}
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
	
}//61.5, -142.9

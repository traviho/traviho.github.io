package creationJSON;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JSONWriter {
	
	public static StringBuffer stringBuffer = new StringBuffer();
	public static HashMap<String, Country> hashMap = new HashMap<String, Country>();
	private boolean createdFirstEntry = false;
	
	public JSONWriter(){
		stringBuffer.append("[");
		initializeHashMap();
	}
	
	public void createEntry(String fieldName, String link){
		creationJSON.Entry newEntry = new creationJSON.Entry(fieldName, link);
		
		if (createdFirstEntry){
			stringBuffer.append(",");
		}
		stringBuffer.append(newEntry.getEntry());
		createdFirstEntry = true;
	}
	
	public void write(){
		stringBuffer.append("]");
		try {
			File file = new File("C:\\Users\\thdar\\Documents\\GitHub\\traviho.github.io\\created_file.json");
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			
			fileWriter.write(stringBuffer.toString());
			fileWriter.flush();
			fileWriter.close();
			System.out.println("wrote to file");
			System.out.println(stringBuffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void initializeHashMap(){
		Document document = null;
		try {
			document = Jsoup.connect("https://developers.google.com/public-data/docs/canonical/countries_csv").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements formEl = document.getElementsByTag("td");
		for (int j = 0;j < formEl.size() - 4;j += 4){
			if (formEl.get(j + 1).html().length() != 0){
				hashMap.put(formEl.get(j).html(), new Country(formEl.get(j + 1).html(), formEl.get(j + 2).html(), formEl.get(j + 3).html(), "0"));
			}
		}
	}
	
	public static void refreshHashMap(){
		Iterator<Entry<String, Country>> it = hashMap.entrySet().iterator();
		
		while (it.hasNext()){
			it.next().getValue().setMagnitude("0");
		}
	}
}

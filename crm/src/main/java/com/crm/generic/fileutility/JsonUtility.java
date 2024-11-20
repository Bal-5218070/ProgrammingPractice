package com.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
public String getDataFromJsonFile(String key) throws IOException, ParseException {
	
	JSONParser parser =new JSONParser();
	FileReader filer= new FileReader("./configurationAppdata/appcommondata.json");
	Object obj = parser.parse(filer);
	//step2: convert java object into jsonobject using downcasting
	JSONObject map = (JSONObject)obj;
	//get the value from json file using key
	String data=(String) (map.get("key"));
	return data;
	
}
}

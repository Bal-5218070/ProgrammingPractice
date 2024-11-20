package testScript;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Readdatafromjsontest {
public static void main(String[] args) throws IOException, ParseException {
	//step1 :parse(convert one form to another form)json physical file into java object using Jsonparse class
	JSONParser parser =new JSONParser();
	FileReader file =new FileReader("./appcommondata.json");
	Object obj = parser.parse(file);
	//step2: convert java object into jsonobject using downcasting
	JSONObject map = (JSONObject)obj;
	//get the value from json file using key
	System.out.println(map.get("url"));
	System.out.println(map.get("browser"));
	System.out.println(map.get("username"));
	System.out.println(map.get("password"));
}
}

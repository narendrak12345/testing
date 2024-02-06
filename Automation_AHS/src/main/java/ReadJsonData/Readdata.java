package ReadJsonData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Readdata {

	String n;
	@SuppressWarnings("unchecked")
	public String jsondata(String text) throws FileNotFoundException, IOException, ParseException {

		String dir = System.getProperty("user.dir");
		Object obj = new JSONParser().parse(new FileReader(dir + "\\src\\test\\resources\\Testdata.json"));
		JSONArray jsonArr = new JSONArray();
		jsonArr.add(obj);
		for (int i = 0; i < jsonArr.size(); i++) {
			JSONObject ob = (JSONObject) jsonArr.get(i);
			n = (String) ob.get(text);
		}
		 return n;
	}
}
package util;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class TestUtil {
	
	
	public static String getEmail()
	{
	  String generatedString = RandomStringUtils.randomAlphabetic(3);
	  return generatedString+"@gmail.com";
	}

}

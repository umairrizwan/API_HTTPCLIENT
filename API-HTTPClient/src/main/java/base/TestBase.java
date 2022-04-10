package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

	public static Properties properties;
	
	
	public int RESPONSE_STATUS_CODE_200 = 200;
	public int RESPONSE_STATUS_CODE_400 = 400;
	public int RESPONSE_STATUS_CODE_404 = 404;
	public int RESPONSE_STATUS_CODE_401 = 401;
	public int RESPONSE_STATUS_CODE_500 = 500;
	public int RESPONSE_STATUS_CODE_201 = 201;
	public int RESPONSE_STATUS_CODE_422 = 422;
	
	public TestBase() 
	{
		try {
		properties = new Properties();
	     FileInputStream inp = new FileInputStream("C:\\Users\\umair\\eclipse-workspace\\API-HTTPClient\\src\\main\\java\\config\\config.properties");
	     properties.load(inp);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}

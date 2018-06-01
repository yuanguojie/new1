package common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Tools {
	/**
	 * 获取propertis中key的值
	 * @param path
	 * @param key
	 * @return
	 */
	public static final Integer DEFAULT_STATUS=0;
	public static String getPropertiesByKey(String path,String key){
		 Properties properties=new Properties();
		 String valueString="";
		 InputStream inStream=Tools.class.getResourceAsStream(path);
		 try {
			properties.load(inStream);
			valueString=properties.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valueString;
	}

}

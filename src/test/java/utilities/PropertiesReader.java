package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	FileInputStream fis = null;
	Properties pro = null;

	String filepath =
			"src/test/java/resources/config.properties";

	public PropertiesReader() {
		try {

			fis = new FileInputStream(filepath);
			pro = new Properties();
			pro.load(fis);
		} catch (IOException fnfe) {
			fnfe.printStackTrace();
		}
	}

	public String getPropValue(String keyvalue) {

		return pro.getProperty(keyvalue);
	}

}

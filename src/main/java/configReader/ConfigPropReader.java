package configReader;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigPropReader {

	private Properties prop;
	private FileInputStream in;

	public Properties initLangProp() {
		
		//mvn clean install -Dlang = "french"
		
		String language = System.getProperty("lang");
		
		System.out.println("Language is " + language);
		prop = new Properties();
		
		try {
			switch (language.toLowerCase()) {
			case "english":
				in = new FileInputStream("./src/main/resources/lang.english.properties");

				break;
			case "french":
				in = new FileInputStream("./src/main/resources/lang.french.properties");

				break;

			default:
				System.out.println("Properties file not found for given language.");
				break;
			}

			prop.load(in);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}

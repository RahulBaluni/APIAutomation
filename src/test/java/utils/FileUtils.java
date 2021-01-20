package utils;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class FileUtils {

    public Properties readPropertiesFile(String fileName) throws IOException {
        Properties prop = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
        }
        return prop;
    }

    /***
     * loads properties into hash-map
     * @param properties
     * @return
     */
    public HashMap<String, String> loadPropertiesFileInHashMap(Properties properties){
        HashMap<String, String> propertiesMap = new HashMap<>();
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            propertiesMap.put(key, value);
        }
        return propertiesMap;
    }

    public String readJsonFileAsJsonObject() throws IOException, ParseException {
//        //JSON parser object to parse read file
//        JSONParser jsonParser = new JSONParser();
//
//        try (FileReader reader = new FileReader("employees.json"))
//        {
//            //Read JSON file
//            Object obj = jsonParser.parse(reader);

        FileReader fileReader = new FileReader("src/test/resources/payload/createuserdraft.json");
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(fileReader).toString();

    }
}

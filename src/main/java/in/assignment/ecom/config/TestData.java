package in.assignment.ecom.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class TestData {
    public static JSONObject testDataObject;
    Logger LOGGER = LogManager.getLogger();

    public TestData() {
    }

    public void setTestData(String testFile) {
        String dataFilePath = "src/test/testData/";

        try {
            FileReader reader = new FileReader(dataFilePath + testFile);
            JSONParser jsonParser = new JSONParser();
            testDataObject = (org.json.simple.JSONObject) jsonParser.parse(reader);
        } catch (Exception ex) {
            LOGGER.error("Failed to set test data from file " + testFile);
            ex.printStackTrace();
        }
    }

    public String getValueFromTestDataFile(String key){
        String value = testDataObject.get(key).toString();
        return value;
    }
}

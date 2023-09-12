package TestDataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name="BrandProvider")
    public static Object[][] getDataFromDataproviderForBrand(){
        return new Object[][] {
                { "Noise" },
                { "Fire-Boltt" },
                { "boAt" }
        };
    }


}

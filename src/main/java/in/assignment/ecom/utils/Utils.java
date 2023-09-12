package in.assignment.ecom.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {
    static Logger LOGGER = LogManager.getLogger();

    public static void waitfor(long delayInms, String reason) {
        if(reason == null)
            LOGGER.info("Waiting for " + delayInms/1000 + " sec");
        else
            LOGGER.info("Waiting for " + delayInms/1000 + " sec for " + reason);

        try {
            Thread.sleep(delayInms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

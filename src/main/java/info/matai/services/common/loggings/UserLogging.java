package info.matai.services.common.loggings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This logger is used to display console messages to the user.
 */
public class UserLogging {
    private final Logger logger;

    private UserLogging() {
        logger = LogManager.getRootLogger();
    }

    public void info(String message) {
        logger.info(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public static UserLogging getLogger() {
        return new UserLogging();
    }
}

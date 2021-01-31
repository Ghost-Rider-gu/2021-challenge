package siendev.corp.apps.apache.commons.cli;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author Iurii Golubnichenko
 *
 * Logging service tests.
 */
public class LoggingServiceTest {

    private static String[] params;
    private static LoggingServiceStarter serviceStarter;

    @BeforeAll
    public static void init() {
        params = new String[]{"-host", "localhost", "-backup", "true", "-update", "50"};
        serviceStarter = new LoggingServiceStarter();
    }

    @Test
    public void loggingServiceWithParametersTest() {
        serviceStarter.prepareToStart(params);
    }
}

package siendev.corp.apps.other;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.AWTException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Iurii Golubnichenko
 */
public class ScreenShotMakerTest {

    private static ScreenShotMaker screenShotMaker;
    private static final String screenShotName = "screenShot.png";

    @BeforeAll
    public static void init() {
        screenShotMaker = new ScreenShotMaker();
    }

    @Test
    public void makeScreenShotTest() throws IOException, AWTException {
        screenShotMaker.makeScreenShot();
        boolean result = Files.exists(Paths.get(screenShotName));

        Assertions.assertTrue(result);
    }
}

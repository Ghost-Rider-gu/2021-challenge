package siendev.corp.apps.network;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

/**
 * @author Iurii Golubnichenko
 *
 * Tests for PortScanner.
 */
public class PortScannerTest {

    private static PortScanner portScanner;

    @BeforeAll
    public static void init() {
        portScanner = new PortScanner();
    }

    @Test
    public void checkDefaultIpAddress() throws ExecutionException, InterruptedException {
        portScanner.runScanner();
    }
}

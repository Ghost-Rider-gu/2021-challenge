package siendev.corp.apps.network;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Iurii Golubnichenko
 */
public class NetworkUtilityTest {

    private static final String HOST_NAME = "google.com";

    @Test
    public void getIpAddressesTest() throws UnknownHostException {
        InetAddress[] addresses = NetworkUtility.getIpAddresses(HOST_NAME);

        Assertions.assertNotNull(addresses);
    }
}

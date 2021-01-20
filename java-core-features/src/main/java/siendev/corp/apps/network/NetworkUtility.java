package siendev.corp.apps.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Iurii Golubnichenko
 */
public class NetworkUtility {

    public static InetAddress[] getIpAddresses(String hostName) throws UnknownHostException {
        return InetAddress.getAllByName(hostName);
    }
}

package siendev.corp.apps.network;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Iurii Golubnichenko
 *
 * Simple port scanner.
 * See tests for checking this out.
 */
public class PortScanner {

    private static final int COUNT_OF_PORTS = 65_535;
    private static final int TIME_OUT = 200;

    private String ipAddress;
    private final ExecutorService executorService;

    public PortScanner() {
        this.executorService = Executors.newCachedThreadPool();
        this.ipAddress = "127.0.0.1";
    }

    public PortScanner(String ipAddress) {
        this.executorService = Executors.newCachedThreadPool();
        this.ipAddress = ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    private Future<Boolean> portIsOpen(final int port) {
        return executorService.submit(() -> {
            try(Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(ipAddress, port), TIME_OUT);
                printResult(port, true);
                return true;
            } catch (Exception ex) {
                printResult(port, false);
                return false;
            }
        });
    }

    private void printResult(int port, boolean isOpen) {
        String portState = isOpen ? "open" : "close";
        System.out.println(String.format("Port [%d] is %s.", port, portState));
    }

    public void runScanner() throws ExecutionException, InterruptedException {
        final List<Future<Boolean>> futures = new ArrayList<>();

        System.out.println(String.format("Start scanning on %s ...", this.ipAddress));
        for (int i = 1; i <=COUNT_OF_PORTS; i++) {
            futures.add(portIsOpen(i));
        }
        this.executorService.shutdown();

        int openPorts = 0;
        for (Future<Boolean> future : futures) {
            if (future.get()) {
                openPorts++;
            }
        }

        int closePorts = COUNT_OF_PORTS - openPorts;
        System.out.println(String.format("Scanning is done. Found [%d] open ports and [%d] close ports.", openPorts, closePorts));
    }
}

package siendev.corp.apps.network;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import siendev.corp.apps.network.server.SimpleServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;

/**
 * @author Iurii Golubnichenko
 */
public class SimpleServerTest {

    private static final int serverPort = 8180;
    private static final String serverHost = "127.0.0.1";
    private static PrintWriter outputData;
    private static BufferedReader inputData;
    private static Socket clientSocket;

    @BeforeAll
    public static void init() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Runnable r = new SimpleServer(clientSocket);
                Thread t = new Thread(r);
                t.start();
            }
        } catch (IOException ex) {
            System.out.println(String.format("Error: %s", ex.getMessage()));
        }

        prepareClient();
    }

    @Test
    public void sendDataToServerTest() throws IOException {
        outputData.println("time");
        String response = inputData.readLine();

        Assertions.assertEquals(LocalDate.now().toString(), response);

        closeClientConnection();
    }

    private static void prepareClient() throws IOException {
        clientSocket = new Socket(serverHost, serverPort);
        outputData = new PrintWriter(clientSocket.getOutputStream(), true);
        inputData = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    private void closeClientConnection() throws IOException {
        outputData.close();
        inputData.close();
        clientSocket.close();
    }
}

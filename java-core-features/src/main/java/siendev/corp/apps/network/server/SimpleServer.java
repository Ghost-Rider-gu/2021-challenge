package siendev.corp.apps.network.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Iurii Golubnichenko
 *
 * This is an example of simple server.
 */
public class SimpleServer implements Runnable {

    private static final String SERVER_NAME = "SimpleServer: ";
    private final Socket clientSocket;

    public SimpleServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {
            Scanner inputData = new Scanner(inputStream, "UTF-8");
            PrintWriter outputData = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);

            outputData.println(ServerCommands.SHOW_SERVER_GREETING);

             boolean needContinue = true;
             while (needContinue && inputData.hasNextLine()) {
                 String userInput = inputData.nextLine();
                 switch (userInput.trim().toLowerCase()) {
                     case ServerCommands.CLOSE:
                         outputData.println(SERVER_NAME + "closing ...");
                         needContinue = false;
                         break;
                     case ServerCommands.TIME:
                         outputData.println(SERVER_NAME + LocalDate.now());
                         break;
                     case ServerCommands.HELP:
                         outputData.println(ServerCommands.SHOW_TERMINATE);
                         outputData.println(ServerCommands.SHOW_CURRENT_DATE);
                         outputData.println(ServerCommands.SHOW_HELP);
                         break;
                     default: outputData.println("Unknown command. Please try again ...");
                 }
             }
        } catch (IOException ex) {
            System.out.println(String.format("There was an error: [%s]", ex.getMessage()));
        }
    }
}

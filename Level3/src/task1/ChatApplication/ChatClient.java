package task1.ChatApplication;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            out.println(name + " joined the chat");

            Thread listenerThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.print(serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from chat.");
                }
            });
            listenerThread.start();

            while (true) {
                String userMessage = sc.nextLine();
                if (userMessage.equalsIgnoreCase("exit")) {
                    out.println(name + " left the chat.");
                    break;
                }
                out.println(name + ": " + userMessage);
            }

        } catch (IOException e) {
            System.out.println("Could not connect to the server.");
        }
    }
}
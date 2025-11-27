package HomeWorks.hm10;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 5000;
        String inputFileName = "run_server.txt";

        // Читаємо файл як ресурс з пакета
        InputStream is = Client.class.getResourceAsStream(inputFileName);
        if (is == null) {
            System.out.println("File 'run_server.txt' not found in package. Please add it to HomeWorks.hm10");
            return;
        }

        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in);
             BufferedReader fileReader = new BufferedReader(new InputStreamReader(is))) {

            System.out.print("Enter a symbol to filter: ");
            String symbol = scanner.nextLine();
            out.println(symbol);

            String line;
            while ((line = fileReader.readLine()) != null) {
                out.println(line);
                System.out.println(in.readLine());
            }

            out.println("END");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

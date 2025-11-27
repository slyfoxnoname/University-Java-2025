package HomeWorks.hm10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 5000;
        String outputFileName = "Filteroutputfile.txt";

        // Файл створюється у тій же папці, що й Server.class
        File outputFile = new File(Server.class.getResource(".").getPath(), outputFileName);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started, waiting for client...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFile, true))) {

                    // Отримуємо символ від клієнта
                    String symbol = in.readLine();
                    if (symbol == null || symbol.isEmpty()) {
                        out.println("No symbol received");
                        continue;
                    }
                    System.out.println("Filtering for symbol: " + symbol);

                    // Отримуємо рядки від клієнта
                    String line;
                    while ((line = in.readLine()) != null) {
                        if (line.equals("END")) break;
                        if (line.contains(symbol)) {
                            fileWriter.write(line);
                            fileWriter.newLine();
                            out.println("Saved: " + line);
                        } else {
                            out.println("Skipped: " + line);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

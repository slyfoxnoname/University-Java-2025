package Aud2025.t09_net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class A09_01_Server {
    public static void main(String[] args) throws IOException {
      int port = 14110;

      try(ServerSocket server =  new ServerSocket(port)){
        System.out.println("Server running on" + server.getLocalSocketAddress());

        Socket conn = server.accept();
        System.out.print("Client connect:" + conn.getRemoteSocketAddress());


        var reader = new BufferedReader(
          new InputStreamReader(
            conn.getInputStream(), StandardCharsets.UTF_8
            ));
        var writer = new PrintStream(
          conn.getOutputStream(), true, StandardCharsets.UTF_8
        );

        writer.println("Hello from client");
        String msg = reader.readLine();
        System.out.println("Message from server:" + msg);


        conn.close();
        System.out.printf("Client disconnected: :" + conn.getRemoteSocketAddress());
      }   
    }   
}
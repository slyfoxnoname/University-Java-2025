package Aud2025.t09_net;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class A09_01_Client {
    public static void main(String[] args) throws IOException {
      int port = 14110;   
      
      String host = "localhost";


      Socket sock = new Socket(host, port);
      System.out.println("Connected to server:" + sock.getRemoteSocketAddress());

      var reader = new BufferedReader(
        new InputStreamReader(
          sock.getInputStream(), StandardCharsets.UTF_8
          ));
      var writer = new PrintStream(
        sock.getOutputStream(), true, StandardCharsets.UTF_8
      );

      writer.println("Hello from client");
      String msg = reader.readLine();
      System.out.println("Message from server:" + msg);
      
      
      
      sock.close();
      System.out.println("Disconnected from server:" + sock.getRemoteSocketAddress());

    } 

}
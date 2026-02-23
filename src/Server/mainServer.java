package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class mainServer {
    public static void main(String[] args) {
        System.out.println("Sono il server");

        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(3000);
            System.out.println("Server: in attesa di richieste");


            Socket socket = serverSocket.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String messaggio = br.readLine();
            System.out.println("SERVER: il client ha scritto -> " + messaggio);

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println("Messaggio ricevuto!");


            br.close();
            pw.close();
            socket.close();
            serverSocket.close();


        } catch (IOException e) {
            System.err.println("Could not listen on port: 3000");
            e.printStackTrace();
        }
    }
}


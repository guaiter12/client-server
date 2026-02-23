package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class mainServer {
    public static void main(String[] args) {
        System.out.println("Sono il server");

        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            System.out.println("Server: in attesa di richieste");

            Socket socket = serverSocket.accept();
            System.out.println("Server: client connesso!");

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            // Legge il messaggio dal client
            String messaggio = br.readLine();
            System.out.println("CLIENT -> SERVER: " + messaggio);

            // Risposta preimpostata del server
            String risposta = "Ciao client, messaggio ricevuto!";
            pw.println(risposta);
            System.out.println("SERVER -> CLIENT: " + risposta);

            br.close();
            pw.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }
}
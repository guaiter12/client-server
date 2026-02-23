package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class mainClient {
    public static void main(String[] args) {
        System.out.println("Client: avvio client");

        try {
            Socket socket = new Socket("localhost", 3000);
            System.out.println("Client: connesso al server!");

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            String messaggio = "Ciao server, come stai?";
            pw.println(messaggio);
            System.out.println("CLIENT -> SERVER: " + messaggio);


            String risposta = br.readLine();
            System.out.println("SERVER -> CLIENT: " + risposta);

            pw.close();
            br.close();
            socket.close();

        } catch (UnknownHostException e) {
            System.err.println("Errore nella connessione al server");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
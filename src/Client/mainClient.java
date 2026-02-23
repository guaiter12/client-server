package Client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class mainClient {
    public static void main(String[] args) {
        System.out.print("Client: avvio client");

        try {
            Socket socket = new Socket("localhost", 3000);
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println("Ciao!");
            System.out.println("CLIENT: messaggio inviato");

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String risposta = br.readLine();
            System.out.println("CLIENT: il server ha risposto -> " + risposta);


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
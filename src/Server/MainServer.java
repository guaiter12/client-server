package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {
    public static void main(String[] args) {
        System.out.println("SERVER:inizio l'esecuzione");
        try {
            ServerSocket server = new ServerSocket(2000);
            System.out.println("SERVER: in attesa di richieste dal client.");
            Socket clientSocket = server.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String mClient = br.readLine();
            System.out.println("SERVER: il client si è connesso" + clientSocket);
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter pw= new PrintWriter(outputStream);
            Scanner sc = new Scanner(System.in);
            if(mClient.isEmpty()) {
                clientSocket.close();
                sc.close();
                br.close();
            }else {
                System.out.println("Client: " + mClient);
                System.out.println("Scrivi un messaggio da mandare al client: ");
                String mServer = sc.nextLine();
                pw.println(mServer);
                pw.flush();
                System.out.println("Messaggio inviato");
            }
            /*String messaggio = br.readLine();
            System.out.println("SERVER: il client" + clientSocket +
                    "ha scritto il messaggio" + messaggio);
            clientSocket.close();
            server.close();
             */
        } catch (IOException e) {
            System.err.println("Porta non disponibile, " +
                    "errore nella creazione della connection socket");
        }
    }
}
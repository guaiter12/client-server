package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        System.out.println("CLIENT: avvio del client");

        try {
            Socket socket = new Socket("localhost",2000);
            System.out.println("CLIENT: si è connesso al server");
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);
            pw.println("Scrivi un messaggio da inviare al Server:");
            Scanner sc = new Scanner(System.in);
            String messaggio = sc.nextLine();
            pw.println(messaggio);
            pw.flush();
            System.out.println("CLIENT: ha inviato un messaggio");
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mServer = br.readLine();
            if(mServer.isEmpty()){
                System.out.println("Messaggio non valido");
                socket.close();
                System.out.println("Comunicazione chiusa");
            }else{
                System.out.println("Server: "+ mServer);
                System.out.println("Scrivi un messaggio da mandare al Server: ");
                String mClient = sc.nextLine();
                pw.println(mClient);
                pw.flush();
                System.out.println("CLIENT: ha inviato un messaggio");
            }
        } catch (Exception e) {
            System.err.println("CLIENT: errore nella connessione");
        }
    }


}
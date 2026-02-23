package Client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class mainClient {
public static void main(String[] args) {
System.out.print("Client: avvio client");
 try{
     Socket socket = new Socket ("local host",3000);
     OutputStream outputStream = socket.getOutputStream();
     PrintWriter pw = new PrintWriter(outputStream);
     pw.println("Ciao!");
     pw.flush();
     System.out.println("CLIENT:il client ha inviato un messaggio");

 } catch (UnknownHostException e) {
     System.err.println("Errore nella connessione al server");
 } catch (IOException e) {
     throw new RuntimeException(e);
 }
}



}
package Server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class mainServer {
    public static void main(String[] args) {

        System.out.println("Sono il server");
    }

    ServerSocket serverSocket;

    {
        try {
            serverSocket = new ServerSocket(3000);
            System.out.println("Server: in attesa di richieste");
        } catch (IOException e) {
            System.err.println("Could not listen on port: 3000");

            InputStream inputStream = Socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

                String messsaggio = br.readLine();


            System.out.println("SERVER: il client" + Socket + "ha scrittto il messaggio" + messaggio);

        }
    }
}


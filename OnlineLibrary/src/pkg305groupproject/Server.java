

package pkg305groupproject;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int ClientNumber = 0;
        try  {
            ServerSocket server_socket = new ServerSocket(9324);
            PrintWriter logs = new PrintWriter(new FileOutputStream("C:\\Users\\96657\\Documents\\GitHub\\Logs.txt",true), true);
            while (true) {            
                System.out.println("waiting ");
                Socket incoming = server_socket.accept();
                // new Client
                
                Runnable r = new ClientHandler(incoming);
                Thread th = new Thread(r);
                th.start();
                
            }
        } catch(IOException e){
        
        }
        
    }
    
    
}
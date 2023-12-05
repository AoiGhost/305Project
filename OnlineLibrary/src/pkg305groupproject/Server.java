

package pkg305groupproject;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
            
        
        try  {
             System.out.println("Server on, Waiting for clients....");
            int i=1;
            ServerSocket server_socket = new ServerSocket(9324);
            while (true) {                
                Socket incoming = server_socket.accept();
                System.out.println("Spawning Clinet: "+ i);
                Runnable r = new ClientHandler(incoming);
                Thread th = new Thread(r);
                th.start();
                th.join();
                
                i++;
             
            }
        } catch(IOException | InterruptedException e){
        
        }
        
    }
    
    
}
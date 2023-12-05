

package pkg305groupproject;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 9324; // Port number
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started. Listening on port " + port);

        // Specify the absolute path to your books directory here
        String booksDirectory = "C:\\Users\\starx\\Desktop\\CPIT305\\copresseed books\\";

        while (true) {
            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 OutputStream out = socket.getOutputStream()) {
                
                // Read the book name from the client
                String bookName = in.readLine();
               // Print the requested book name to the console
                System.out.println("Client requested: " + bookName);

                // Use the absolute path to locate the PDF file
                File pdfFile = new File(booksDirectory + bookName + ".pdf");
                if (pdfFile.exists()) {
                    // Create a buffer for reading and writing data
                    byte[] buffer = new byte[2097152]; //2MB buffer
                    // Open a FileInputStream for the file
                    try (FileInputStream fis = new FileInputStream(pdfFile)) {
                        int count;
                        // Read data from the file and write it to the client
                        while ((count = fis.read(buffer)) > 0) {
                            out.write(buffer, 0, count);
                        }
                    }
                } else {
                    out.write("Book not found".getBytes());
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
                break;
            }
        }
    }
    
    
}
package pkg305groupproject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.in;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    //public static DatabaseConnection DBcon =  new DatabaseConnection();

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
            String serverAddress = "127.0.0.1";
            int port = 9324;
             Socket ServerSocket  = new Socket(serverAddress, port);
            //socket that will lead us to server
            PrintWriter out = new PrintWriter(ServerSocket.getOutputStream(), true);
            BufferedInputStream in = new BufferedInputStream(ServerSocket.getInputStream()); // Create a FileOutputStream to save the downloaded book to the spceific path written below
            InputStreamReader in2 = new InputStreamReader(ServerSocket.getInputStream());
            BufferedReader in3 = new BufferedReader(in2);
        //this will be used to communicate with server
        
       
        //here client is connected to server
        
        Scanner user_input = new Scanner(System.in);
       
        boolean x = true;
        while(true){
        try {
            System.out.println("1 for show books");
            System.out.println("2 for buying ");
            System.out.println("3 For renting ");
            System.out.println("4 for exit");
            System.out.print("your choice:");
            String choice = user_input.nextLine();
            //customer choice
            if (choice.equals("1")) {
            //show books
            //the user wants to know books , we need to send book pdf
            System.out.println("the list of books that are available below: " + "\n");
            out.println(choice);
            String line;
            
            Thread.currentThread().sleep(1000);
            while ((line = in3.readLine())!= null &&!line.equals("EOF")) {
                System.out.println(line);
                
            }
            //if we reach here this means the list of books have been written
           
            }  
            
            else if (choice.equals("2") ) {
               //buying
                System.out.println("Enter the book number you want to buy: ");
                String book_number = user_input.nextLine();
                //book number that the custmoer want 
                 out.println(book_number);    
                 FileOutputStream fileOut = new FileOutputStream("C:\\Users\\96657\\Desktop\\" + book_number + ".pdf");
                 byte[] buffer = new byte[2097152];
                 int count;

                // Read data from the server and write it to the file
                while ((count = in.read(buffer)) > 0) {
                    fileOut.write(buffer, 0, count);
                   
                    }
                System.out.println("Thanks for buying the book and the book downloaded successfully.");
                fileOut.close();
                }
            else if (choice.equals("")) {
                   //renting
               
               
            } else if (choice.equals("")) {
               //exit
               x = false;
               
            } 
            
            
            
           
//                          Book book = findBook(books, book_number);


            

            //try with resources
            //Fileoutput path in the client

            //Send the book name to the server
          

            // Create a buffer for reading data
            
            //Buying 
            
            
           
            

            
         } catch (InputMismatchException e) {

            System.out.println("you entered in the wrong format");
        }

    }
    }

    private static boolean Authentication(int ID, String password) {
        return true;
    }

    private static Book findBook(Book books, int book_number) {
        for (int i = 0; i < books.getHypothetical_database().length; i++) {
            if (books.getHypothetical_database()[i].getBookNo() == book_number) {
                return books.getHypothetical_database()[i];
            }
        }

        return null;
    }

//    public Client() {
//         DBcon = new DatabaseConnection();
//    }
//
//    public static DatabaseConnection getDBcon() {
//        return DBcon;
//    }
//
//    public static void setDBcon(DatabaseConnection DBcon) {
//        Client.DBcon = DBcon;
//    }



}

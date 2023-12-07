package pkg305groupproject;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.in;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public static DatabaseConnection DBcon =  new DatabaseConnection();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String serverAddress = "localhost";
        int port = 9324;
        Socket socket;
        //this will be used to communicate with server
        PrintWriter out = null;
        try {
            socket = new Socket(serverAddress, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            BufferedInputStream in = new BufferedInputStream(socket.getInputStream()); // Create a FileOutputStream to save the downloaded book to the spceific path written below
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        Scanner user_input = new Scanner(System.in);
       
        boolean x = true;
        while(true){
        try {
            System.out.println("For login press 1:");
            System.out.println("For signup press 2:");
            System.out.println("For exist press 2:");
            System.out.print("your choice:");
            int choice = user_input.nextInt();
            //customer choice
            if (choice == 1) {

                System.out.println("Enter username: ");
                String username = user_input.next();
                System.out.println("Enter Passowrd:");
                String password = user_input.next();
                
                if (DBcon.login(username, password)) {
                    //if we enter here it means the client has loggid in 
                     
                        System.out.println("enter 1 for buy , 2 for rent");
                        
                        int userchoice = user_input.nextInt();
                        if (userchoice == 1) {
                            //the user wants to buy , we need to send book pdf
                            System.out.println("the list of books that are available to buy below: " + "\n");
                            Client.DBcon.getAllBooks();
                            
                            
                            System.out.println("Enter the book number you want to buy: ");
                            int book_number = user_input.nextInt();
                            //book number that the custmoer want 
//                          Book book = findBook(books, book_number);
                            
                           
                            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\96657\\Desktop\\" + book_number + ".pdf");
                                    
                            //try with resources
                            //Fileoutput path in the client
                            
                                //Send the book name to the server
                                out.println(book_number);

                                // Create a buffer for reading data
                                byte[] buffer = new byte[2097152];
                                int count;

                                // Read data from the server and write it to the file
                                while ((count = in.read(buffer)) > 0) {
                                    fileOut.write(buffer, 0, count);

                                }

                                System.out.println("Thanks for buying the book and the book downloaded successfully.");
                        }//buy choice

                }//login
            }//choice 
            
            
            if (choice == 2) {
                System.out.println("Enter username: ");
                String username = user_input.next();
                System.out.println("Enter Passowrd:");
                String password = user_input.next();
                DBcon.signUp(username, password);
            }
            else{
                x = false;
            } 

            
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

    public Client() {
         DBcon = new DatabaseConnection();
    }

    public static DatabaseConnection getDBcon() {
        return DBcon;
    }

    public static void setDBcon(DatabaseConnection DBcon) {
        Client.DBcon = DBcon;
    }



}

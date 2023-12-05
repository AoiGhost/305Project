/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg305groupproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler implements Runnable{
    /*
    this class will be used to create threads objects
    this is thread that will handle any client.
    the run method is the code that we will execute to handle the client.
    */
    Socket Client;

    public ClientHandler() {
    }

    public ClientHandler(Socket Client) {
        this.Client = Client;
    }

    public Socket getClient() {
        return Client;
    }

    public void setClient(Socket Client) {
        this.Client = Client;
    }
    
    
    @Override
    public void run() {
        
    }
    
    
    
    
    public static synchronized boolean Commit(){
        /* this method will do the following
        commit chagnes to the local repo then push to git repo
        */
        

        //here I will make a process that executes the script 
        
        //here put the path to the script
        ProcessBuilder myProcessBuilder = new ProcessBuilder("cmd.exe", "/c", "C:\\Users\\96657\\Documents\\GitHub\\305Project\\Git_Commit_push.bat");
        Map<String, String> environment = myProcessBuilder.environment();
        String path = environment.get("PATH");
        String gitPath = "C:\\Program Files\\Git\\bin";
        String updatedPath = gitPath + ";" + path;
        environment.put("PATH", updatedPath);
        myProcessBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        myProcessBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
        try {
            myProcessBuilder.directory(new File("C:\\Users\\96657\\Documents\\GitHub\\305Project"));
            Process process = myProcessBuilder.start();
             // Capture the output and error streams
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Print the output
            }
            
            int exitcode = process.waitFor();
            boolean result;
            result = (exitcode == 0);
            return result;
            //if true is returned the the process executed successfully
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex.toString());
            //if we reach here this means that an exception have occured 
            //so we print the execption and return false to indicate that the operation failed.
            return false;
        }
        
        

        //here I will make a process that executes the script gg

    }
    public static synchronized boolean Pull(){
        /* this method will do the following
        pull the repo from github to ensure we have latest version
        */
        //here put the path to the script
        ProcessBuilder myProcessBuilder = new ProcessBuilder("cmd.exe", "/c", "C:\\Users\\96657\\Documents\\GitHub\\305Project\\Git_pull.bat");
        Map<String, String> environment = myProcessBuilder.environment();
        String path = environment.get("PATH");
        String gitPath = "C:\\Program Files\\Git\\bin";
        String updatedPath = gitPath + ";" + path;
        environment.put("PATH", updatedPath);
        myProcessBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        myProcessBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
        try {
            myProcessBuilder.directory(new File("C:\\Users\\96657\\Documents\\GitHub\\305Project"));
            Process process = myProcessBuilder.start();
             // Capture the output and error streams
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Print the output
            }
            
            int exitcode = process.waitFor();
            boolean result;
            result = (exitcode == 0);
            return result;
            //if true is returned the the process executed successfully
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex.toString());
            //if we reach here this means that an exception have occured 
            //so we print the execption and return false to indicate that the operation failed.
            return false;
        }
        
        

}
}
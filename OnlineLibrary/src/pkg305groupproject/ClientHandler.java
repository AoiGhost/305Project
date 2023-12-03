/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg305groupproject;

import java.net.Socket;

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
    
    public static synchronized void Commit(){
        /* this method will do the following
        pull the repo from github to ensure we have latest version
        then commit any changes we have done in the local git repo
        */
        
        //here I will make a process that executes the script 
    }
}

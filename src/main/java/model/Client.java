package model;

import java.io.IOException;
import java.net.Socket;

public class Client extends Thread {
    
    
    String pokemon, hostname;
    int port;
    
    public Client(String pokemon, String hostname, int port) {
        this.pokemon = pokemon;
        this.hostname = hostname;
        this.port = port;
    }
    
    @Override
    public void run() {
        try {
            Socket s = new Socket(hostname, port);
            s.getOutputStream().write(pokemon.getBytes());
            s.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
}

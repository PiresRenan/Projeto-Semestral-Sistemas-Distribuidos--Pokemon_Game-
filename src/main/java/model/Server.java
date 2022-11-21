package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    
    ServerSocket server;
    int port = 8877;
    Battle pokemon;

    
    public Server(Battle pokemon, int port) {
        this.port = port;
        this.pokemon = pokemon;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        Socket clientSocket;
        try {
            while((clientSocket = server.accept()) != null) {
                InputStream is = clientSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = br.readLine();
                if(line != null) {
                    pokemon.pokemonBattle(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

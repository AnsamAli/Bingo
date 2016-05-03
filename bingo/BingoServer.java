package bingo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * a TCP server that produces a board when a player/client connects to it.
 * it sends random number spaces for the user.
 */
public class BingoServer {

    static ServerSocket socket;
    private static final int port = 9001;


    /**
     * Listens to the port and creates threads
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Bingo server is starting up...");
        socket = new ServerSocket(port);

        try {
            while (true) {
                new GameHandler(socket.accept()).start();
            }
        } finally {
            socket.close();
        }

    }

    /**
     *  A handler thread class.  Handlers are spawned from the listening
     * loop and are responsible for a dealing with a single client
     * and broadcasting its messages.
     */
    static class GameHandler extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public GameHandler(Socket socket) {
            this.socket = socket;
        }


        /**
         * runs the game using the Bingo protocol
         */
        public void run(){
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream());
                String line = reader.readLine();
                if (line.equalsIgnoreCase("sign-up")) {
                    //send "Welcome" message
                    System.out.println("Received sign-up");
                    writer.println("Welcome! Let's play bingo!");
                }


            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
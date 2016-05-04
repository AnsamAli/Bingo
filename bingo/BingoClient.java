package bingo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * The client that connects to the game server and communicates with it
 * through the gui
 */
public class BingoClient {
    BufferedReader reader;
    PrintWriter writer;

  Dealer dealer = new Dealer();


    /**
     * Connects to the server then enters the processing loop.
     */
    private void run() throws IOException {

        // Make connection and initialize streams
        Socket socket = new Socket("localhost", 9001);
        reader = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println("sign-up");

    }

    /**
     * Runs the client as an application with a closeable frame.
     */
    public static void main(String[] args) throws Exception {
        BingoClient client = new BingoClient();
        client.dealer.makeBoardGui();
        client.run();
    }
}
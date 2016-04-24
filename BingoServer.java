import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * a TCP server that produces a board when a player/client connects to it.
 * it sends random number spaces for the user.
 */
public class BingoServer {

    public static void main(String[] args) throws IOException {
        System.out.println("Bingo server is starting up...");
        ServerSocket socket = new ServerSocket(9898);
        try {

        } catch (Exception e) {

        }
    }


    private static class BingoListener extends Thread {
        private Socket socket;
        private int clientNumber;

        private BingoListener(Socket socket, int clientNumber) {
            this.socket = socket;
            this.clientNumber = clientNumber;
        }
    }

    public void run() {
        
    }

}
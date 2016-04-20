import java.io.IOException;

/**
 * a TCP server that produces a board when a player/client connects to it.
 */
public class Server {

    public static void main(String[] args) throws IOException {
            if (args.length != 1) {
                System.out.println("Please enter a port number");
                System.exit(1);
            }
        int port = Integer.valueOf(args[0]);

    }

}


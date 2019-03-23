package Server;

import CoffeRank.Coffee;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * Main class for the server.
 * Starts a new Thread for each request.
 * @author Joscha Henningsen
 */
public class Erie {

  /**
   * Main method to start Server with
   * @param args (not used)
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {

    Config config=new Config();
    Logger logger = new Logger();
    @SuppressWarnings("resource")
    ServerSocket serverSocket = new ServerSocket(config.port);
    HashMap<String, ArrayList<Coffee>> userlists = new HashMap<>();
    HashMap<String, int[]>remainingQuestions = new HashMap<>();
    IntStream.iterate(0, i -> i + 1).forEach(i -> {
      Socket client;
      try {
        client = serverSocket.accept();
        //System.out.println("*** Client connected!");
        WebserverThread wst = new WebserverThread(client, logger, userlists, remainingQuestions);
        wst.start();
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }

}

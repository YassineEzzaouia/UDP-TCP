import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
          
            ServerSocket serverSocket = new ServerSocket(6789);

            while (true) {
            
                Socket connectionSocket = serverSocket.accept();

             
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                String clientSentence = inFromClient.readLine();
        
                System.out.println("Received: " + clientSentence);

           
                String capitalizedSentence = clientSentence.toUpperCase() + '\n';

                outToClient.writeBytes(capitalizedSentence);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

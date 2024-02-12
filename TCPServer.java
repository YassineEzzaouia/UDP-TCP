import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            // Créer une socket pour le serveur avec le port 6789
            ServerSocket serverSocket = new ServerSocket(6789);

            while (true) {
                // Attendre une connexion entrante
                Socket connectionSocket = serverSocket.accept();

                // Créer un flux d'entrée pour recevoir les données du client
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                // Créer un flux de sortie pour envoyer les données au client
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                // Lire les données envoyées par le client
                String clientSentence = inFromClient.readLine();
                // Afficher les données reçues
                System.out.println("Received: " + clientSentence);

                // Transformer les données reçues
                String capitalizedSentence = clientSentence.toUpperCase() + '\n';

                // Envoyer les données transformées au client
                outToClient.writeBytes(capitalizedSentence);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try {
            // Créer une socket pour le client et se connecter au serveur à l'adresse localhost sur le port 6789
            Socket clientSocket = new Socket("localhost", 6789);

            // Créer un flux de sortie pour envoyer des données au serveur
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            // Créer un flux d'entrée pour recevoir les données du serveur
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Envoyer des données au serveur
            String sentence = "Hello, serveur TCP!";
            outToServer.writeBytes(sentence + '\n');

            // Lire les données envoyées par le serveur
            String modifiedSentence = inFromServer.readLine();
            // Afficher les données reçues
            System.out.println("FROM SERVER: " + modifiedSentence);

            // Fermer la socket client
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

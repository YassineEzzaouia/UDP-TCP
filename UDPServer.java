import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try {
            // Créer une socket pour le serveur avec le port 9876
            DatagramSocket serverSocket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            while (true) {
                // Préparer le paquet pour recevoir les données
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // Recevoir les données du client
                serverSocket.receive(receivePacket);
                // Extraire les données reçues
                String sentence = new String(receivePacket.getData());
                // Afficher les données reçues
                System.out.println("Received: " + sentence);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
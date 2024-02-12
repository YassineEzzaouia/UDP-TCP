import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
            // Créer une socket pour le client
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            String sentence = "Hello, serveur UDP!";
            sendData = sentence.getBytes();

            // Préparer le paquet pour envoyer les données au serveur
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            // Envoyer les données au serveur
            clientSocket.send(sendPacket);
            // Fermer la socket client
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

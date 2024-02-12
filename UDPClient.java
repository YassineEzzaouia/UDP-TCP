import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
           
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            String sentence = "Hello, serveur UDP!";
            sendData = sentence.getBytes();

     
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        
            clientSocket.send(sendPacket);
          
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

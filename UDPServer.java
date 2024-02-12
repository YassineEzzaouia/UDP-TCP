import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try {
           
            DatagramSocket serverSocket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            while (true) {
            
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            
                serverSocket.receive(receivePacket);
         
                String sentence = new String(receivePacket.getData());
              
                System.out.println("Received: " + sentence);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

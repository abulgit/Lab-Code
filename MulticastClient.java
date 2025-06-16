import java.io.*;
import java.net.*;

class MulticastClient {
    public static void main(String[] args) throws IOException {
        // Define multicast IP address (same as server: 224.0.0.1)
        InetAddress IP = InetAddress.getByName("224.0.0.1");

        // Create MulticastSocket and bind to port 5000
        MulticastSocket ms = new MulticastSocket(5000);

        // Join the multicast group to receive messages
        ms.joinGroup(IP);

        // Create buffer to store incoming messages (1024 bytes)
        byte[] buffer = new byte[1024];

        // Notify that client is ready to receive messages
        System.out.println("Client is listening...");

        // Infinite loop to continuously listen for messages
        while (true) {
            // Create DatagramPacket to receive incoming data
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

            // Wait for and receive a packet from the multicast group
            ms.receive(dp);

            // Convert received bytes to string (only actual data length)
            String response = new String(dp.getData(), 0, dp.getLength());

            // Display the received message
            System.out.println("Received data: " + response);
        }
    }
}
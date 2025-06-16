import java.io.*;
import java.net.*;

class MulticastServer {
    public static void main(String[] args) throws IOException {
        // Create a DatagramSocket for sending UDP packets
        DatagramSocket ms = new DatagramSocket();

        // Define multicast IP address (224.0.0.1 is reserved for multicast)
        InetAddress IP = InetAddress.getByName("224.0.0.1");

        // Prompt user to enter a message
        System.out.println("Enter your message:");

        // Create BufferedReader to read user input from console
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the message from user input
        String msg = br.readLine();

        // Convert message string to bytes for transmission
        byte[] buffer = msg.getBytes();

        // Create DatagramPacket with message, destination IP and port 5000
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, IP, 5000);

        // Send the packet to the multicast group
        ms.send(dp);

        // Display confirmation message
        System.out.println("Sent message: " + msg);

        // Close the socket to free up resources
        // ms.close();
    }
}
import java.io.*;
import java.net.*;

class ServerUDP {
    public static void main(String[] args) {
        DatagramSocket ds = null;

        try {
            int port = 8080; // Use the same port as the client
            ds = new DatagramSocket(port);
            System.out.println("Server started on port " + port);

            byte[] byteArray = new byte[1024];
            DatagramPacket dp = new DatagramPacket(byteArray, byteArray.length);

            while (true) {
                ds.receive(dp); // Corrected method name: receive

                byte[] receivedData = dp.getData();
                int length = dp.getLength();
                String msg = new String(receivedData, 0, length, "UTF-8").trim();
                InetAddress clientAddress = dp.getAddress();
                int clientPort = dp.getPort();

                System.out.println("Received from Client (" + clientAddress.getHostAddress() + ":" + clientPort + "): " + msg);
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }
}
import java.io.*;
import java.net.*;

class ClientUDP {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        BufferedReader br = null;

        try {
            // Declare socket
            ds = new DatagramSocket();

            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your message: ");
            String str = br.readLine();
            byte[] sendData = str.getBytes("UTF-8"); // Recommended encoding

            // use sendData.length for the length of the data to send
            DatagramPacket dp = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("localhost"), 8080);
            ds.send(dp);
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        } finally {
            if (ds != null) {
                ds.close();
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error closing BufferedReader: " + e);
                }
            }
        }
    }
}
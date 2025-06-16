//  Implement a Java Program to find out the Net ID, Host ID and Subnetmask
// of the User given IP Address. :

// code :

import java.util.Scanner;

public class IPDetailsFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter IP Address (e.g., 192.168.1.10): ");
        String ipAddress = scanner.nextLine();

        String[] parts = ipAddress.split("\\.");
        if (parts.length != 4) {
            System.out.println("Invalid IP address format.");
            return;
        }

        try {
            int firstOctet = Integer.parseInt(parts[0]);
            int secondOctet = Integer.parseInt(parts[1]);
            int thirdOctet = Integer.parseInt(parts[2]);
            int fourthOctet = Integer.parseInt(parts[3]);

            String ipClass = "";
            String subnetMask = "";
            String netID = "";
            String hostID = "";

            if (firstOctet >= 1 && firstOctet <= 126) {
                ipClass = "Class A";
                subnetMask = "255.0.0.0";
                netID = firstOctet + ".0.0.0";
                hostID = "0." + secondOctet + "." + thirdOctet + "." + fourthOctet;
            } else if (firstOctet >= 128 && firstOctet <= 191) {
                ipClass = "Class B";
                subnetMask = "255.255.0.0";
                netID = firstOctet + "." + secondOctet + ".0.0";
                hostID = "0.0." + thirdOctet + "." + fourthOctet;
            } else if (firstOctet >= 192 && firstOctet <= 223) {
                ipClass = "Class C";
                subnetMask = "255.255.255.0";
                netID = firstOctet + "." + secondOctet + "." + thirdOctet + ".0";
                hostID = "0.0.0." + fourthOctet;
            } else {
                System.out.println("IP Address is not Class A, B, or C.");
                return;
            }

            System.out.println("IP Address Class: " + ipClass);
            System.out.println("Default Subnet Mask: " + subnetMask);
            System.out.println("Network ID: " + netID);
            System.out.println("Host ID: " + hostID);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. IP parts must be numeric.");
        }
    }
}

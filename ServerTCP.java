import java.io.*;
import java.net.*;
public class server {
public static void main(String[] args) throws IOException {
ServerSocket ss = new ServerSocket(8080);
Socket s = ss.accept();
BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
String receiveSentence = br.readLine();
String upperSentence = receiveSentence.toUpperCase();
System.out.println("Received from Client (in UPPERCASE): " + upperSentence + "\n");
DataOutputStream dos = new DataOutputStream(s.getOutputStream());
dos.writeBytes(upperSentence + "\n");
s.close();
ss.close();}
}

import java.io.*;
import java.net.*;
public class ClientTCP{
public static void main(String[] args)throws IOException
{
Socket s = new Socket ("LocalHost", 8080);
System.out.println("Enter message : ");
BufferedReader br = new BufferedReader(new
InputStreamReader(System.in));
String sen = br.readLine();
DataOutputStream ds = new DataOutputStream(s.getOutputStream());
ds.writeBytes(sen+"\n");
BufferedReader br1 = new BufferedReader(new
InputStreamReader(s.getInputStream()));
String receiveSentence = br1.readLine();
System.out.println("Receive From Server : "+receiveSentence+"\n");
s.close();
}
}

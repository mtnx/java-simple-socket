import java.io.*;
import java.net.*;
import java.util.*;

public class TCPServer {
	public final static int serverPort = 7896;
	public static void main (String args[]) {
		try{
		//int serverPort = 7896;
			ServerSocket listenSocket = new ServerSocket(serverPort);
			System.out.println("\n Server Connected in Port : "+serverPort);
			System.out.println("");
			int sesi = 0;
		while(true) {
			sesi = sesi + 1;
			Socket clientSocket = listenSocket.accept();
			Connection c = new Connection(clientSocket);
			System.out.println("Client "+sesi+" Connected...");
		}
	} catch(IOException e) {System.out.println("Listen: " +
		e.getMessage());}
	}
}

class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	public Connection (Socket aClientSocket) {
		try {
			clientSocket = aClientSocket;
			in = new DataInputStream(clientSocket.getInputStream());
			out = new DataOutputStream( clientSocket.getOutputStream());

			this.start();
		} catch(IOException e) {System.out.println("Connection: "+e.getMessage());}
	}
	public void run(){
		try { // an echo server
			//String data = in.readUTF();
			String data = in.readUTF();
			System.out.println("Received Message "+data);
			//out.writeUTF(data);


			out.writeUTF(data);
			System.out.println("Message Has Been Replied");
			System.out.println("");
			System.out.println(" ");
		} catch(EOFException e) {System.out.println("EOF: "+e.getMessage());} 
			catch(IOException e) {System.out.println("IO:s a"+e.getMessage());}
		finally {
			try {
				clientSocket.close();
			}catch (IOException e){
				System.out.println("IO:s a"+e.getMessage());
			}
		}
	}
}
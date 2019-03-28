import java.net.*;

class myserver
{
	public static void main(String[] args) throws Exception
		{
	
			ServerSocket s=new ServerSocket(2020);
			System.out.println("Server menunggu koneksi....");
			Socket so=s.accept();
			System.out.println("Koneksi dibuat..");

		}
	
}
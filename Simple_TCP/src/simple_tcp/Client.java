package simple_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	//On Client side, we have only regular socket.
	public Client() throws Exception{
		//Address -localhost or 127.0.0.1
		//Write same port number which is there in server side , if not then error occurs
		Socket socket = new Socket("127.0.0.1",2023);
		System.out.println("Successful connection to the server");
		
		//I/O Streams
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		 
		//We will receive message from server and store that message in String
		//Read the message from our socket with readLine()
		String message = in_socket.readLine();
		System.out.println("Server says: "+ message);
		out_socket.println("Thanks!");
		
		socket.close();
		System.out.println("Socket closed.");
		
	
	}
	
	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

package simple_tcp_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

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
		 Scanner sc=new Scanner(System.in);
		 
		//We will receive message from server and store that message in String
		//Read the message from our socket with readLine()
		String message = in_socket.readLine();
		System.out.println("Server says: "+ message);
		System.out.println("Say Something to Sever:");
		message = sc.nextLine(); //user is prompted to type a message to send to server and whatever they type that will be stored in message string
		out_socket.println(message);  //client typed messaged will be sent to server
		
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

package simple_tcp_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
//On Client side, we have only regular socket.
public Client() throws Exception{
	//Address - localhost or 127.0.0.1
	//Write same port number which is there in server side , if not then error occurs
		
		Socket socket = new Socket("127.0.0.1",2023);
		System.out.println("Successful connection to the server.");
		
		// I/O streams
		BufferedReader in_socket = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter (new OutputStreamWriter (socket.getOutputStream()), true);
		Scanner sc = new Scanner (System.in);
		String user_number;
		
		while((in_socket.readLine()).startsWith("Guess")) {
			System.out.println("Server says: Guess a number [1-10].");
			user_number = sc.nextLine();
			out_socket.println(user_number);
		}
		
		System.out.println("You guessed it!!!");
		
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

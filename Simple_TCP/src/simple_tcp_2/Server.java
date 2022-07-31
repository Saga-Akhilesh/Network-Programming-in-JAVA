package simple_tcp_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	//On server side, we will have two types of sockets - server socket and regular socket
	//The server socket is just going to hold a port in operating system in our application
	public Server() throws Exception {
		ServerSocket server_socket = new ServerSocket(2023); //opening a new port
		System.out.println("Port 2023 is open.");
		
		//Using Socket method to create socket object
		//The socket object holds the information that's relevant to our connection,which can be used to pull the IP address of the client from this object using socket.getInetAddress()
		Socket socket= server_socket.accept(); //This line blocks rest of the code until an incoming connection shows up
		System.out.println("Client "+ socket.getInetAddress()+ " has connected");
		
		//We have two streams of data - Incoming stream of data and Outgoing Stream of Data
		//Incoming Stream of data means the data which is coming from client to server
		//Outgoing Stream of data means the messages that server sends to Client
		//We are going to use in_socket for Incoming stream of data 
		//We are going to use out_socket for outgoing stream of data
		
		//By using getinputStream, we are selecting the data that we want to look at.
		//InputStreamReader is used to switch that unreadable data into readable text so a user can understand
		//BufferedReader is used to pull all the data into  a buffer
		
		//I/O Buffers:
		BufferedReader in_socket =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter (socket.getOutputStream()), true);
		
		out_socket.println("Welcome!");   //send "Welcome" to the Client
		String message = in_socket.readLine();   //receive "Thanks!"
		System.out.println("Client says: "+ message);   //display Client's message in the console
		
		socket.close();
		System.out.println("Socket is Closed");
	}
	
	public static void main(String[] args) {
		try {
			new Server();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

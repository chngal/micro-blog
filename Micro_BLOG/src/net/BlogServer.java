package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BlogServer {
	public static final int PORT = 3021;
	public static void main(String[] args) {
//		if(args.length!=1){
//			System.err.println("Usage: Jave BlogServer <port number>");
//			System.exit(1);
//		}
		//int portNumber = Integer.parseInt(args[0]);
		
		
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			Socket clientSocket = serverSocket.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			System.out.println("From Server: ");
			System.out.println(in.readLine());
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}

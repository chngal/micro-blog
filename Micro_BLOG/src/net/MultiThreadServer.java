package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {
	public static final int PORT = 3021;
	private static int vistorCounter = 0;
	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			while(true){
				Socket clientSocket = serverSocket.accept();
				ThreadHandler threadhandler =new ThreadHandler(clientSocket, ++vistorCounter);
				Thread thread = new Thread(threadhandler);
				thread.start();
				

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}

package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadHandler implements Runnable{
	Socket clientSocket;
	int vistorCounter;
	public ThreadHandler(Socket clientSocket, int vistorCounter){
		this.clientSocket = clientSocket;
		this.vistorCounter = vistorCounter;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
			String userInput = "";
			do{
				userInput = in.readLine();
			if(userInput.equals("visitor")){
				out.println("You're the " + vistorCounter + " vistor today");
			}
			else if(userInput.equals("quit")){
				break;
			}
			else{
				out.println("echo: " +userInput);
			}
			}while(!(userInput.equals("quit")));
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

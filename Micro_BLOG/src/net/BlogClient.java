package net;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class BlogClient {
	public static final String IP = "127.0.0.1";
	public static final int PORT = 3021;
	
	public static void main(String[] args) {
//		if(args.length!=2){
//			System.err.println("Usage: Java BlogClient <host name> <port number>");
//			System.exit(1);
//		}
		try (
			Socket blogSocket = new Socket(IP, PORT);
			PrintWriter out = new PrintWriter(blogSocket.getOutputStream(),true);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(blogSocket.getInputStream())
					);
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			
		){
			String userInput;
			out.println("hihi jai ");
			out.close();
			/*userInput
			 * 
			 * 
			 * 
			 * 
			 */
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.err.println("Don't know about host"+ IP);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Could't get I/O for the connection to" + IP);
			e.printStackTrace();
		}
	}
}

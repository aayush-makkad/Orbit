package com.orbit.net.listener;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.orbit.process.pool.*;

public class Server extends Thread{
		
	private final int port = 9990;
	
	private ServerSocket ss;
	
	private volatile ArrayList<String> holdstack = new ArrayList<String>();
	private volatile ProcessStoreImpl psi = new ProcessStoreImpl();
	static Logger log = Logger.getLogger(Server.class.getName());
	
	
	public void makeConnctAsAt() throws IOException, ClassNotFoundException {
		
		ss = new ServerSocket(port);
		while(true){
            System.out.println("Waiting for client request");
            Socket socket = ss.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            holdstack.add(message);
            
            Thread t = new Thread( new Runnable() {

            	@Override
            	public void run() {
            		for(String sid : holdstack) {
            			
            			try {
            				log.info(message);
            				psi.addProcess(Integer.parseInt(sid));
            			}catch(Exception e) {
            				log.info("Exception for :" +message);
            				continue;
            			}
            		}}});
            t.start();
            System.out.println("Message Received: " + message);
            ois.close();
            socket.close();
        }
    }

		
	}


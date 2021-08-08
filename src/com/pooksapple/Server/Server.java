package com.pooksapple.Server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.pooksapple.pojo.Person;

public class Server {
	


	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		ServerSocket serverSocket=new ServerSocket(9090);
		Person p1=new Person();
		p1.setName("pukar");
		p1.setHeight("5.5");
		p1.setGender("male");
		
		while(true) {
		Socket s=serverSocket.accept();
	
		BufferedInputStream bfs=new BufferedInputStream(s.getInputStream());
		ObjectInputStream ois=new ObjectInputStream(bfs);
		Person p=(Person)ois.readObject();
		System.out.println(p.getName());
		System.out.println(p.getGender());
		System.out.println(p.getHeight());
		
		
		
		}

	}
}

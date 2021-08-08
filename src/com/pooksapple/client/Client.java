package com.pooksapple.client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.pooksapple.pojo.Person;


public class Client {
	
	private ObjectInputStream objectInputStream;
	private BufferedInputStream bufferedInputStream;
	
	private OutputStream outputStream;
	private ObjectOutputStream objectOutputStream;
	
	private String serName;
	private int port;

	public Client(String serName,int port) {
	this.serName=serName;
	this.port=port;
		
	}
	
	 
  public static void main(String[] args) throws IOException, ClassNotFoundException {
	
Client c=new Client("localhost",9090);
if(c.connect()) {
	System.out.println("connected successfully");
}
}


private boolean connect() throws UnknownHostException, IOException, ClassNotFoundException {
	  Socket s=new Socket(serName,port);
	
	  
	  this.outputStream=s.getOutputStream();
	  ObjectOutputStream ojs=new ObjectOutputStream(outputStream);
	  this.bufferedInputStream=new BufferedInputStream(s.getInputStream());
	  this.objectInputStream=new ObjectInputStream(bufferedInputStream);
	  
	  Person p=(Person)objectInputStream.readObject();
	System.out.println(p.getGender());
	System.out.println(p.getHeight());
	System.out.println("learning git");
	p.getName();
	  
	System.out.println("second commmit");
	  ojs.writeObject(personObj());
	  
	 
	
	  return true;
}

private Person personObj() {
	
	Person p=new Person();
	p.setGender("male");
	p.setHeight("7.7");
	p.setName("sandesh");
	
	return p;
	
	
}


}

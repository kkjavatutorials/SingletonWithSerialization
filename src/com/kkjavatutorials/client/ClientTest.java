package com.kkjavatutorials.client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import com.kkjavatutorials.singleton.Singleton;
/**
 * @author KK JavaTutorials
 */
public class ClientTest {

	public static void main(String[] args) throws IOException {
		
		ObjectOutput objectOutput = null;
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = null;
		try {
			objectOutput = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
			objectOutput.writeObject(singleton1);
			
			objectOutput.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(objectOutput != null)
				objectOutput.close();
		}
		
		ObjectInput objectInput = null;
		
		try {
			objectInput = new ObjectInputStream(new FileInputStream("singleton.ser"));
			
			Object readObject = objectInput.readObject();
			
			singleton2 = (Singleton)readObject;
			
		} catch (Exception e) {
			e.printStackTrace();
		 }finally {
			if(objectInput != null)
				objectInput.close();
		}
		
		System.out.println(singleton1.hashCode());
		System.out.println(singleton2.hashCode());
	}
}

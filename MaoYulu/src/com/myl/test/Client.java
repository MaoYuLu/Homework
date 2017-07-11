package com.myl.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	public static void main(String[] args) {
		
		BufferedWriter bw = null;
		BufferedReader br = null;
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 9000);
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("This is mt first TCP!");
			bw.flush();
			socket.shutdownOutput();
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = "";
			while ((str=br.readLine())!=null) {
				System.out.println(str);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (null != br) {
				try {
					br.close();
					br = null;	
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != bw) {
				try {
					bw.close();
					br = null;	
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}	
}

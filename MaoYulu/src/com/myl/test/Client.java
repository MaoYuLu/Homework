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
		BufferedReader br1 = null;
		try {
			socket = new Socket("127.0.0.1", 9000);
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br1 = new BufferedReader(new InputStreamReader(System.in));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while (true) {
				System.out.println("请输入你要发给服务器的内容:");
				String instr =  br1.readLine();
				if ("exit".equals(instr)) {
					System.exit(0);		
				}
				bw.write("Client:" + instr);
				bw.newLine();  //空行
				bw.flush();
				
				String str = br.readLine();
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
			if (null  != br1) {
				try {
					br1.close();
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

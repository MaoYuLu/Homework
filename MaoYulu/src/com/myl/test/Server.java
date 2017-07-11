package com.myl.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		
		ServerSocket ss = null;
		Socket socket = null;
		BufferedReader br = null;
		BufferedReader br1 = null;
		BufferedWriter bw = null ;
		try {
			ss = new ServerSocket(9000);
			socket = ss.accept();
			br1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while (true) {
				String s = br1.readLine();
					System.out.println(s);
				
				
				System.out.println("请输入你要发给客户端的内容:");
				String instr = br.readLine();
				while ("exit".equals(instr)) {
					System.exit(0);			
				}
				bw.write("Server:" + instr);
				bw.newLine();  //空行
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (null != bw) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
			if (null != br1) {
				try {
					br1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
			try {
				socket.close();
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

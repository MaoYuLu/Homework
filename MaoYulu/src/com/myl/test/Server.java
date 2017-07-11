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
		BufferedWriter bw = null ;
		try {
			ss = new ServerSocket(9000);
			socket = ss.accept();
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = "";
			while ((str=br.readLine())!= null) {
				System.out.println(str);			
			}
			socket.shutdownInput();
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("已接收信息");
			bw.flush();
			socket.shutdownOutput();
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
			try {
				socket.close();
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

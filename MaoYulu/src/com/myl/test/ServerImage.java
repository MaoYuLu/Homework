package com.myl.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerImage {
	
	ServerSocket ss = null;
	Socket socket = null;
	private boolean bstarted = false;
	private boolean bconnected = false;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	
	public static void main(String[] args)  {
		ServerImage si = new ServerImage();
		si.control();
	}
	
	private void control() {
		ServerRunnable sr = new ServerRunnable();
		Thread thread = new Thread(sr);
		thread.start();
	}
	
	private  class  ServerRunnable implements Runnable {
		@Override
		public void run() {
			connect();
			byte[] by = new byte[1024];
			int a = 0;
			try {
				while ((a = dis.read(by)) != -1) {
					dos.write(by, 0, a);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			disconnect();
		}		
	}
	
	private void connect() {
		try {
			ss = new ServerSocket(9900);
			bstarted = true;
			System.out.println("服务器已启动！");
			if (bstarted) {
				socket = ss.accept();
				bconnected = true;
				System.out.println("客户端已连接！");
			}
			if (bconnected) {
				dis =  new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(new FileOutputStream(new File("d:\\a.jpg")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void disconnect() {
		try {
			if (null != dos) {
				dos.close();
				dos = null;
			}	
			if (null != dis) {
				dis.close();
				dis = null;
			}
			if (null != socket) {
				socket.close();
				socket = null;
			}
			if (null != ss) {
				ss.close();
				ss = null;
			}	
			bconnected= false;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

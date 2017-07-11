package com.myl.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientImage {
	Socket socket = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	private boolean bconnected = false;
	
	public static void main(String[] args) {
		ClientImage ci = new ClientImage();
		ci.control();
	}
	
	private void control() {
		ClientRunnable cr = new ClientRunnable();
		Thread thread = new Thread(cr);
		thread.start();
	}
	
	//连接服务器的方法
	private void connect() {
		try {
			socket = new Socket("127.0.0.1", 9900);
			dis = new DataInputStream(new FileInputStream(new File("F:\\aa.jpg")));
			dos =  new DataOutputStream(socket.getOutputStream());
			System.out.println("客户端已连接到服务端！");
			bconnected = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//关闭与服务器连接的函数
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
			bconnected = false;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class ClientRunnable implements Runnable {
		@Override
		public void run() {
			connect();
			if (bconnected) {
				byte[] b = new byte[1024];
				int a = 0;
				try {
					while ((a=dis.read(b))!=-1) {
						dos.write(b, 0, a);					
					}
					//dos.flush();
					
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					disconnect();
					bconnected = false;
				}
			}			
		}		
	}
}

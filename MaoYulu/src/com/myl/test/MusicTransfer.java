package com.myl.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class MusicTransfer {
	public static void main(String[] args) throws IOException  {
		long start = new Date().getTime();
		File f = new File("F:\\软件1403班-0515\\guanguanguan.mp4");
		FileInputStream fis = new FileInputStream(f);
		FileOutputStream fos = new FileOutputStream(new File("guanguan.mp4"));
		byte [] buf = new byte[1024];
		while ((fis.read(buf))!= -1) {
			fos.write(buf);			
		}
		try {
			if (null != fos) {
				fos.close();
				fos = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}			
		long end = new Date().getTime();
		System.out.println("传递数据花费时间为："+(end-start)+"s");
	}
}

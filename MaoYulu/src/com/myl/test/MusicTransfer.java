package com.myl.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class MusicTransfer {
	public static void main(String[] args)   {
		long start = new Date().getTime();
		File f = new File("F:\\软件1403班-0515\\guanguanguan.mp4");
		FileInputStream fis=null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(f);
			fos = new FileOutputStream(new File("guanguan.mp4"));
			byte [] buf = new byte[1024];
			while ((fis.read(buf))!= -1) {
				fos.write(buf);			
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (null != fos) {
				try {
					fos.close();
					fos = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		long end = new Date().getTime();
		System.out.println("传递数据花费时间为："+(end-start)+"s");
	}
}

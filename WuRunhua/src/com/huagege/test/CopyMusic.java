package com.huagege.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 复制音乐并计算时间
 * 
 * @author wubobo
 *
 */
public class CopyMusic {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream  fos = null;
		try {
			long begin = System.currentTimeMillis();
			fis = new FileInputStream(new File("F:/绅士.mp3"));
			fos = new FileOutputStream(new File("H:/shenshi.mp3"));
			byte[] bytes = new byte[1024];
			while(fis.read(bytes)!=-1)
				fos.write(bytes);
			long end = System.currentTimeMillis();
			System.out.println(end-begin);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.getMessage();
		}finally{
			if(fis!=null)
				try {
					fis.close();
				} catch (IOException e) {
					e.getMessage();
				}
			if(fos!=null)
				try {
					fos.close();
				} catch (IOException e) {
					e.getMessage();
				}
		}
	}

}

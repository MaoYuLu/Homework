package com.myl.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//1.����һ���ļ���ָ��Ŀ¼  ���� ͨ�����ڸ�ʽ �������� 
public class FileTest {
	
	public static void main(String[] args) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String  filedate = sdf.format(new Date());
		System.out.println(filedate);
		System.out.println(""+filedate+".txt");
		File f = new File(""+filedate+".txt");
		if(!f.exists())
			f.createNewFile();
 	}
}

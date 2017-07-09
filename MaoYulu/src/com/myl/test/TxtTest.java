package com.myl.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * 2.写一个txt文件 ，要求 将3个学生的信息 写入文本中，
  ①包括 ：
   姓名  年龄 学号 
  ② 输出这三个学生 的信息 并且按 学号从小到大排列。
  ③ 要求 txt文件名称  按照当前时间创建的。   
 */
public class TxtTest {
	//定义全局常量来制定txt中存储的学生个数
	public final static  int STUDENTNUM = 3 ;
	
	public static void main(String[] args) {
		File  file = new File("2017-07-06.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String[] line = new String [STUDENTNUM+1];
			int i = 0;
			while ((line[i]= br.readLine())!=null) {
				line[i] = line[i].trim();
				i++;
			}
			for (int j = 0; j < line.length-2; j++) {
				String  temp = "";
				if (line[j].charAt(0) > line[j+1].charAt(0)) {
					temp = line[j];
					line[j] = line[j+1];
					line[j+1] = temp;
				}
			}
			for (int j = 0; j < line.length-1; j++) {

				System.out.println(line[j]);
			}
		} catch (FileNotFoundException e) {
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
		}
	}
}



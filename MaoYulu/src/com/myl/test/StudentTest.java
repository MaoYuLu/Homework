package com.myl.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * 1.学生管理系统 
   要求 ：5个学生  姓名 年龄 学号
   控制台 输出 ：    ① 添加学生 --》文件txt  --》读取 --》 向集合中添加--》写入     ② 删除学生     ③ 查询 
 */
/**
 * 学生信息测试类
 * @author MaoYuLu
 */
public class StudentTest {
	public static final int STUNUMBER = 10;
	public static void main(String[] args) {
		StudentTest st = new StudentTest();
		st.frame();		
	}
	/**
	 * 主页面，听歌输入转入其他功能
	 */
	public void frame() {
		Scanner s = new Scanner(System.in);
		System.out.println("主页面,按1读取学生，按2添加学生，按3查询学生，按4删除学生，按0回到主页面!");
		switch (s.nextInt()) {
			case 1:
				readStu();
				for (int i = 0; i < readStu().length; i++) {
					if (null != readStu()[i]) {
						System.out.println(readStu()[i]);					
					}
				}
				frame();
				break;
			case 2:
				insertStu();
				break;
			case 3:
				selectStu();
				frame();
				break;
			case 4:
				deleteStu();
				frame();
				break;
			case 0:
				frame();
				break;	
			default:
				System.out.println("输入错误！");
				frame();
				break;
		}	
	}
	/**
	 * 删除学生信息
	 */
	public  void deleteStu() {
		System.out.println("请输入你要删除的id号：");
		Scanner sid = new Scanner(System.in);
		int id = sid.nextInt();
		String[] s = readStu();
		for (int i = id-1; i < s.length-1; i++) {
			s[i] = null;
			s[i] = s[i+1];
		}
		System.out.println("删除成功!");
		writeStu(s);
	}
	/**
	 * 查询学生信息
	 */
	public void selectStu() {
		System.out.println("请输入你要查询的id号：");
		Scanner sid = new Scanner(System.in);
		String[] s = readStu();
		int id = sid.nextInt();
		if (id < s.length) {
			System.out.println(s[id-1]);			
		}else {
			System.out.println("此id用户不存在");
		}
		readStu();
	}
	/**
	 * 插入学生信息
	 */
	public void insertStu() {
		System.out.println("请按“学号=XX,姓名=XX,年龄=XX”的格式输入学生数据，每次输入一个学生信息！");
		System.out.println("请输入你要输入的数据:");
		Scanner scanner = new Scanner(System.in);
		String[] s = readStu();
		String si = scanner.nextLine();
		int i = 0;
		for (int j = 0; j < s.length; j++) {
			if (null != s[j]) {	
				j++;				
			}else {
				s[j-1] = si;
				System.out.println("一行信息插入成功！");	
				break;
			}
		}
		
		writeStu(s);
 	}
	/**
	 * 写出学生信息
	 * @return 将学生信息存在String数组里返回给调用函数
	 */
	public void writeStu(String[] arr) {
		BufferedWriter  bw = null;
		try { 
			bw = new BufferedWriter(new FileWriter("2017-07-06.txt"));
			for (int i = 0; i < arr.length-2; i++) {
				String s = arr[i]+"\n";
				bw.write(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (null != bw) {
				try {
					bw.close();
					bw = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		frame();
 	}
	/**
	 * 读取学生信息
	 * @return 将学生信息存在String数组里返回给调用函数
	 * @throws FileNotFoundException 
	 */
	public String[] readStu() {
		File file = new File("2017-07-06.txt");
		BufferedReader br = null;
 		String[] line = new String [STUNUMBER+2];
		try {br = new BufferedReader(new FileReader(file));
			int i = 0,sum=0;
			while ((line[i]= br.readLine())!=null) {
				line[i] = line[i].trim();
				i++;sum++;
			}
			for (int j = 0; j < sum-2; j++) {
				for (int j2 = j; j2<sum-2; j2++) {
					String  temp = "";
					if ((line[j2+1].length()>3) && (line[j2].charAt(3)>line[j2+1].charAt(3))) {
						temp = line[j2];
						line[j2] = line[j2+1];
						line[j2+1] = temp;
					}
				}
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
		return line;
	}
}
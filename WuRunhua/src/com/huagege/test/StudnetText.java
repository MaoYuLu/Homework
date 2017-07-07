package com.huagege.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class StudnetText {

	public static void main(String[] args) throws IOException {
		
		//格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(new Date());
		
		//读取文件，向set中添加学生
		File file = new File("src/com/huagege/test/2017-7-6.txt");
		FileReader fr = new FileReader(file);
		char[] cbuf = new char[1024];
		String s;
		String[] student = new String[4];
		Set<Student> students = new TreeSet<Student>();
		while(fr.read(cbuf)!=-1){
			s = new String(cbuf).replace(" ", "");//去掉字符串中的空格
			student = s.split("。");//按“。”分割字符串，获取每个学生的信息
			for(String a:student){
				String[] message = a.split(",");//按“，”分割字符串，获取每个学生的属性
				int id = Integer.valueOf(message[0]);
				Student stu = new Student(id,message[1],message[2]);
				students.add(stu);
			}
				
		}
		fr.close();
		
		//输出
		for(Student st: students)
			System.out.println(st);
	}

}

class Student implements Comparable{
	private int id;
	private String name;
	private String age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Student(int id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	/**
	 * 重写compareTo，使其在treeSet中按id排序
	 */
	public int compareTo(Object o) {
		Student s= (Student)o;
		return this.id-s.getId();
	}
	
}

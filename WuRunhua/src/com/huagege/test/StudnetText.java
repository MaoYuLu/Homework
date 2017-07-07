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
		
		//��ʽ������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(new Date());
		
		//��ȡ�ļ�����set�����ѧ��
		File file = new File("src/com/huagege/test/2017-7-6.txt");
		FileReader fr = new FileReader(file);
		char[] cbuf = new char[1024];
		String s;
		String[] student = new String[4];
		Set<Student> students = new TreeSet<Student>();
		while(fr.read(cbuf)!=-1){
			s = new String(cbuf).replace(" ", "");//ȥ���ַ����еĿո�
			student = s.split("��");//���������ָ��ַ�������ȡÿ��ѧ������Ϣ
			for(String a:student){
				String[] message = a.split(",");//���������ָ��ַ�������ȡÿ��ѧ��������
				int id = Integer.valueOf(message[0]);
				Student stu = new Student(id,message[1],message[2]);
				students.add(stu);
			}
				
		}
		fr.close();
		
		//���
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
	 * ��дcompareTo��ʹ����treeSet�а�id����
	 */
	public int compareTo(Object o) {
		Student s= (Student)o;
		return this.id-s.getId();
	}
	
}

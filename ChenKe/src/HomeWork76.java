

/*
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.TreeSet;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	public class HomeWork76 {

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmss");
			File f=new File(sf.format(new Date())+".txt");//???
			Student a=new Student("xiaomin",20,20);
			Student b=new Student("xiaohong",10,30);
			Student c=new Student("xiaogang",60,10);
			//�����
			//1.�������ݵ�txt
			FileWriter fw=new FileWriter(f);
			fw.write(a.toString());
			fw.write(b.toString());
			fw.write(c.toString());
			fw.close();
			//��ô���ļ�txt
			FileReader fr =new FileReader(f);
			char[] cbuf =new char[1024];
			//StringBuffer
			//�����ж�ȡ������һ�ηŲ���
			StringBuffer sb=new StringBuffer();
			//ѭ����ȡ
			int count =0;
			while((count=fr.read(cbuf))!=-1)
			{
				sb.append(new String(cbuf,0,count));//???	
			}
			//System.out.println(sb);
			//ѧ������
			TreeSet<Student> ts=new TreeSet();
			//��ȡ���ַ������зָ��ԣ� �ָ�
			String[]s1=sb.toString().split(":");
			for(String string :s1){
			//	System.out.println(string);
				//���
				String[] s2=string.split(",");
				
				//����һ������list
				ArrayList<String> list=new ArrayList();
				for(String string2 :s2){
			//		System.out.println(string2);
					String []s3 =string2.split("=");
					list.add(s3[1]);
					for(String string3 :s3){
						System.out.println(string3);
						}
					
					}ts.add(new Student(list.get(0),Integer.valueOf(list.get(1)),Integer.valueOf(list.get(2))));
				//System.out.println("=======");
			}//System.out.println("=======");
					//ƴ�ӳ�ѧ������
			//���������̨����
			System.out.println(ts);
		}
		

	}

		

	class tudent implements Comparable<Student>{
		private String name;
		private int age;
		private int id;
		
		@Override//???
		public String toString() {
			return "name=" + name + ", age=" + age + ", id=" + id + ":";
		}
		public Student(String name, int age, int id) {
			super();
			this.name = name;
			this.age = age;
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			if (age != other.age)
				return false;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			return this.id-o.id;
		}
	}
*/
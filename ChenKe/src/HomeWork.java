import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;


public class HomeWork {
	
	public static void main(String[] args) throws Exception {
		// TODO �Զ����ɵķ������
		Scanner scan=new Scanner(System.in);
		HomeWork hw=new HomeWork();
		//List<Student> li=new ArrayList();
			System.out.println();
		System.out.println("��ӭ����ѧ������ϵͳ");
		int a=scan.nextInt();
		switch (a) {
		case 1:
			System.out.println("������ѧ������");
			String name=scan.toString();
			
			System.out.println("������ѧ������");
		    int	age=scan.nextInt();
			
			System.out.println("������ѧ��ѧ��");
			int id=scan.nextInt();
			hw.addStudent(name, age, id);//�쳣
			break;
		case 2:
			
			break;
		
		case 3:
			
			break;
		}
		
	}
	public void addStudent(String name,int age,int id)throws Exception{
		Scanner scan=new Scanner(System.in);
		TreeSet<Student> set=new TreeSet();
		
		
		
		set.add(new Student(name,age,id));
		
		//�������������
		ObjectOutputStream fo=new ObjectOutputStream(new FileOutputStream(new File("5.txt")));
	
		fo.writeObject(set);
		fo.close();
	}

}
class student  implements Serializable{//
	private String name;
	private int age;
	private int id;
	public Student(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}
	public Student() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	/* ���� Javadoc��
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/* ���� Javadoc��
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
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
	/* ���� Javadoc��
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name Ҫ���õ� name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age Ҫ���õ� age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id Ҫ���õ� id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
}*/
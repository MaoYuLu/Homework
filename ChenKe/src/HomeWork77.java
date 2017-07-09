import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;



public class HomeWork77 {
	
	public static void main(String[] args) throws Exception {
		// TODO �Զ����ɵķ������
		Scanner scan=new Scanner(System.in);
		
		HomeWork77 hw=new HomeWork77();
		
		//�������������
				ObjectOutputStream fo=new ObjectOutputStream(new FileOutputStream(new File("5.txt")));
				//��������������
				ObjectInputStream fi=new ObjectInputStream(new FileInputStream(new File("5.txt")));
		//��list
				TreeSet<Student> set=new TreeSet();
				set.add(new Student("С��",20,123));
				set.add(new Student("����",21,124));
				set.add(new Student("С����",23,122));
				set.add(new Student("�ֻ�",22,120));
				set.add(new Student("����",19,128));
				fo.writeObject(set);
			
				fo.flush();
				//�ر���Դ
				fo.close();
				//====================================
			
				//��ȡ����
				
				//Student ro = (Student) fi.readObject();
			//	Iterator<Student> it = set.iterator();
			//	while (it.hasNext())
			//		System.out.println(it.next());
				TreeSet<Student> set1=(TreeSet<Student>) fi.readObject();
				for (Student student : set1) {
				
					System.out.println(student);
				}
			/*for(int i=0;i<set1.size();i++){
				System.out.println(set1);
			}*/
				
				
				//fi.close();
				
		//List<Student> li=new ArrayList();
		int flag=1;
		do{
		System.out.println("��ӭ����ѧ������ϵͳ:1���ѧ�� 2ɾ��ѧ�� 3��ѯѧ��");
		int a=scan.nextInt();
		switch (a) {
		case 1:
			System.out.println("������ѧ������");
			String name=scan.next();
			
			System.out.println("������ѧ������");
		    int	age=scan.nextInt();
			
			System.out.println("������ѧ��ѧ��");
			int id=scan.nextInt();
			hw.addStudent(name, age, id);//�쳣
			
			System.out.println("�Ƿ��������");
			System.out.println("��1 ���� ���� ��2 �˳�");
			flag=scan.nextInt();
			break;
		case 2:
			System.out.println("������ѧ��ѧ��");
			int id2=scan.nextInt();
			hw.deleteStudent(id2);
			System.out.println("�Ƿ��������");
			System.out.println("��1 ���� ���� ��2 �˳�");
			flag=scan.nextInt();
			break;
		
		case 3:
			System.out.println("�����Ҫ��ѯѧ��ѧ��");
			int id1=scan.nextInt();
			hw.searchStudent(id1);
			System.out.println("�Ƿ��������");
			System.out.println("��1 ���� ���� ��2 �˳�");
			flag=scan.nextInt();
			break;
		}
		
	}
	while(flag==1);
		
	
		
	}
	//���ѧ��
	public void addStudent(String name,int age,int id)throws Exception{
		Scanner scan=new Scanner(System.in);
		
		ObjectOutputStream fo=new ObjectOutputStream(new FileOutputStream(new File("5.txt")));
		//��������������
		ObjectInputStream fi=new ObjectInputStream(new FileInputStream(new File("5.txt")));
		
		TreeSet<Student> set=new TreeSet();
		set.add(new Student(name,age,id));
		fo.writeObject(set);
		fo.flush();
		fo.close();
	}
	
//����ѧ��ɾ��ѧ��
public void  deleteStudent (int id2)throws Exception{
	
	Scanner scan=new Scanner(System.in);
	
	ObjectOutputStream fo=new ObjectOutputStream(new FileOutputStream(new File("5.txt")));
	//��������������
	ObjectInputStream fi=new ObjectInputStream(new FileInputStream(new File("5.txt")));
	
	TreeSet<Student> set1=(TreeSet<Student>) fi.readObject();
	/*for (Student student : set1) {
	 	while(student.getId()==id2){
		System.out.println(set1.remove(student));
	 	break;
	 	}
	}*/
	Iterator it = set1.iterator();
	while(it.hasNext()){
		for (Student student : set1) {
	  if(student.getId()==id2){
	      
	       it.remove();
	  }
	}
	}
	

/*for(int i=0;i<set1.size();i++){
	System.out.println(set1);
}*/
	}
	

	
//����ѧ�Ų�ѯѧ��
public void searchStudent(int id1)throws Exception{
	
	
	
	//ObjectOutputStream fo=new ObjectOutputStream(new FileOutputStream(new File("5.txt")));
	//��������������
	ObjectInputStream fi=new ObjectInputStream(new FileInputStream(new File("5.txt")));

	TreeSet<Student> set1=(TreeSet<Student>) fi.readObject();
	
	for (Student student : set1) {
		
	 	while(student.getId()==id1){//???
		System.out.println(student);
		break;
	 	}; 	//remove
	}
	
}
	

}
class Student  implements Serializable,Comparable<Student> {//
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
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	/**
	 * @param id Ҫ���õ� id
	 */
	public int compareTo(Student o) {//�ǵ�Ҫд   ���� ��д������������������
		// TODO �Զ����ɵķ������
		return this.id-o.id;
	}
	
}
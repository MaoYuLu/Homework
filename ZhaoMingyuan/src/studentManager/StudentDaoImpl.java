package cn.jxau.homework.studentManager;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.TreeMap;
 
/**
 * 学生对象操作实现类
 */
public class StudentDaoImpl implements StudentDao {
    private static final String file = "student.dat";
 
    /**
     * 添加学生
     */
    public void addStu(TreeMap<String, Student> stuMap) {
        /** 把原来的数据也加入去 */
//        Iterator<Student> iterator = findAll().values().iterator();
//        while (iterator.hasNext()) {
//            Student student = iterator.next();
//            stuMap.put(student.getNum(), student);
//        }
 
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(file);
            out = new ObjectOutputStream(fos);
            Iterator<Student> it = stuMap.values().iterator();
            while (it.hasNext()) {
                out.writeObject(it.next());
            }
            out.writeObject(null);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    /**
     * 查找所有学生对象
     */
    public TreeMap<String, Student> findAll() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        TreeMap<String, Student> stuMap = null;
        try {
            fis = new FileInputStream(file);
            if(fis != null)
            in = new ObjectInputStream(fis);
            Student student = null;  
            stuMap = new TreeMap<String, Student>();
            if(in != null){
            	while ((student = (Student) (in.readObject())) != null) {
            		stuMap.put(student.getNum(), student);
            	}            	
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
        	try {
        		if(in != null)
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	try {
        		if(fis != null)
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        return stuMap;
    }
    /**
     * 删除所有学生对象
     */
    public void delAll() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(file);
            out = new ObjectOutputStream(fos);
            out.writeObject(null);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
       
        }
    }
 
    /**
     * 更新学生对象
     */
    public void updateStu(TreeMap<String, Student> stuMap) {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(file);
            out = new ObjectOutputStream(fos);
            Iterator<Student> it = stuMap.values().iterator();
            while (it.hasNext()) {
                out.writeObject(it.next());
            }
            out.writeObject(null);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    public boolean delByNum(String num) {
        boolean flag = false;
        TreeMap<String, Student> stuMap = findAll();
        if (stuMap.remove(num) != null) {
            updateStu(stuMap);
            flag = true;
        }
        return flag;
    }
 
    public Student findByNum(String num) {
        return findAll().get(num);
    }
 
    public void updateByNum(String num, Student student) {
        TreeMap<String, Student> stuMap = findAll();
        stuMap.get(num).setId(student.getId());
        stuMap.get(num).setName(student.getName());
        stuMap.get(num).setNum(student.getNum());
        stuMap.get(num).setSex(student.getSex());
        updateStu(stuMap);
    }
 
}

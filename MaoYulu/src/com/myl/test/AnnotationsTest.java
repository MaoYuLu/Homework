package com.myl.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import com.myl.test.AnnotationsTest.MyAnnotation;


/**
 * 2.自定义一个名为“MyTiger”的注解类型，
 * 它只可以使用在方法上，带一个String类型的value属性
 * ，然后在第1题中的Person类上正确使用
 * @author Administrator
 *
 */
public class AnnotationsTest {
	
	/**
	 * 自定义注释类
	 * @author MaoYuLu
	 */

	@Target(ElementType.CONSTRUCTOR)
 	public @interface MyAnnotation{
 		//Annotation的成员变量在 Annotation定义中以无参数方法的形式来声明.
 		//其方法名和返回值定义了该成员的名字和类型. 指定成员变量的初始值可使用 default关键字
 	       String name() default "呵呵";
      }
}

class Person {
	String name;
	String sex;
	int age;
	int id;
	Person(){}
	@MyAnnotation
	Person(String name, String sex, int age, int id) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "姓名："+name+"性别"+sex+"年龄"+"学号"+id;
	}
}
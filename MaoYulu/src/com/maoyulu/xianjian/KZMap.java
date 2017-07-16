package com.maoyulu.xianjian;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class KZMap extends Map  {
	// 全局变量 ：作用域在整个类中
	static Image bg;
	//创建李逍遥对象 
	LXYMap lxym = new LXYMap();
	
		int x,y;
	//判断李逍遥是否靠近李家村
	boolean flag;
	// 静态代码块 构造代码块
	static {
		try {
			bg = ImageIO.read(new File("img\\客栈\\0.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(bg, -x, -y, null);
		//方法连动 通过李家村的paint方法 调用李逍遥的paint方法
		lxym.draw(g);
		int[] xpoints={280-x,210-x,196-x,260-x};
		int[] ypoints={340-y,370-y,330-y,310-y};
		//判断李逍遥是否靠近客栈
		Graphics2D g2d=(Graphics2D) g;
		flag = g2d.hit(new Rectangle(400, 370, 50, 50),new Polygon(xpoints, ypoints, xpoints.length), true);
	}
	
	@Override
	public String keyPressed(KeyEvent e) {
		lxym.keyPressed(e);
		//getKeyCode按下的键的值  返回值为int类型的常量 
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			y+=10;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			y-=10;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			x-=10;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			x+=10;
		}
		//重绘
		repaint();
		if(flag){
			return "李家村";
		}
		return "";
	}
}

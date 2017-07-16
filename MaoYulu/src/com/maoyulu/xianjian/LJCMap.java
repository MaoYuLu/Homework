package com.maoyulu.xianjian;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



public class LJCMap extends Map {
	
	
	private static final long serialVersionUID = 1L;
	static Image bimg = null;
	static Image[] aws = new Image[17];
	static Image[] az = new Image[6];
	static Image[] mj = new Image[6];
	static Image[] xj = new Image[2];
	static Image[] xxj = new Image[2];
	private int awsi = 0;
	private int azmji = 0;
	private int xxji = 0;
	LXYMap lxy=new LXYMap();
	int x,y;
	//全局变量 判断李逍遥是否靠近客栈
	public boolean flag;
	
	static {
		try {
			bimg = ImageIO.read(new File("img\\李家村\\0.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < aws.length; i++) {
			try {
				aws[i] = ImageIO.read(new File("img\\阿旺婶\\"+i+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		for (int i = 0; i < az.length; i++) {
			try {
				az[i] = ImageIO.read(new File("img\\阿珠喂鸡\\"+i+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		for (int i = 0; i < mj.length; i++) {
			try {
				mj[i] = ImageIO.read(new File("img\\母鸡\\"+i+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}for (int i = 0; i < xj.length; i++) {
			try {
				xj[i] = ImageIO.read(new File("img\\小鸡\\"+i+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}for (int i = 0; i < xxj.length; i++) {
			try {
				xxj[i] = ImageIO.read(new File("img\\小小鸡\\"+i+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
	LJCMap() {
		run();
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(bimg, -400-x, -400-y, null);	
		g.drawImage(aws[awsi], 200-x, 150-y, null);
		g.drawImage(az[azmji], 550-x, 250-y, null);
		g.drawImage(mj[azmji], 530-x, 300-y, null);
		g.drawImage(xj[xxji], 510-x, 320-y, null);
		g.drawImage(xxj[xxji], 600-x, 340-y, null);
		lxy.draw(g);
		int[] xpoints={720-x,660-x,730-x,770-x};
		int[] ypoints={280-y,300-y,370-y,300-y};
		//判断李逍遥是否靠近客栈
		Graphics2D g2d=(Graphics2D) g;
		flag = g2d.hit(new Rectangle(430, 370, 50, 50),new Polygon(xpoints, ypoints, xpoints.length), true);
	}

	public void run() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					awsi++;
					if (awsi>16) {
						awsi = 0;
					}
					azmji++;
					if (azmji>5) {
						azmji = 0;
					}
					xxji++;
					if (xxji>1) {
						xxji = 0;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					repaint();
				}				
			}
		}).start();
	}
	public String keyPressed(KeyEvent e) {
		lxy.keyPressed(e);
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
		//从李家村靠近客栈 
		if(flag){
			return "客栈";
		}
		return "";
	}
}




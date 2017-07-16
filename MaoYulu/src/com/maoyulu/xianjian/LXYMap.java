package com.maoyulu.xianjian;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LXYMap {


	static Image[] lxyU = new Image[8];
	static Image[] lxyD = new Image[8];
	static Image[] lxyR = new Image[8];
	static Image[] lxyL = new Image[8];

	private int imgi = 0;
	
	//定义snake运动的几个方向
	enum Direction {L, R, U, D, STOP};
//	//定义默认方向为stop状态
	private Direction dir = Direction.STOP;


	static{
		for (int i = 0; i < lxyU.length; i++) {
			try {
				lxyU[i] = ImageIO.read(new File("img\\李逍遥上\\"+i+".png"));
				lxyD[i] = ImageIO.read(new File("img\\李逍遥下\\"+i+".png"));
				lxyR[i] = ImageIO.read(new File("img\\李逍遥右\\"+i+".png"));
				lxyL[i] = ImageIO.read(new File("img\\李逍遥左\\"+i+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
	
	//绘制方法
	public void draw(Graphics g) {	
		switch(dir) {
		case L:
			g.drawImage(lxyL[imgi], 200, 200, null);
			break;
		case U:
			g.drawImage(lxyU[imgi], 200, 200, null);
			break;
		case R:
			g.drawImage(lxyR[imgi], 200, 200, null);
			break;
		case D:
			g.drawImage(lxyD[imgi], 200, 200, null);
			break;
		case STOP:
			g.drawImage(lxyD[0], 200, 200, null);
			break;
		}
			
	}
	
		//监听按下的按键来确定是那个方向的移动
	public void keyPressed(KeyEvent e) {
		imgi++;
		if (imgi>7) {
			imgi = 0;
		}
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_LEFT :
			dir = Direction.L;
			break;
		case KeyEvent.VK_UP :
			dir = Direction.U;
			break;
		case KeyEvent.VK_RIGHT :
			dir = Direction.R;
			break;
		case KeyEvent.VK_DOWN :
			dir = Direction.D;
			break;
		}
	}
}

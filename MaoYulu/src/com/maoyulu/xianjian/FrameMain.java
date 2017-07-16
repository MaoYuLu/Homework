package com.maoyulu.xianjian;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * 仙剑游戏的主舞台
 * @author MaoYuLu
 */
public class FrameMain extends JFrame implements KeyListener {
	
	private static final long serialVersionUID = 1L;
	Map ljc = new LJCMap();
	KZMap kz = null;
	
	
	public FrameMain() {
		setSize(900, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //关闭窗口的时候退出程序
		setLocationRelativeTo(null);  //窗体居中
		addKeyListener(this);	
		add(ljc);
		setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		String msg = ljc.keyPressed(e);
		//根据 keyPressed 返回值来进行判断  空串在当前场景 ，
		//如果为客栈 ，切换到客栈场景 移除李家村场景 ，如果为李家村，切换到李家村，移除客栈场景
		if(msg.length()!=0){
			if("客栈".equals(msg)){
				remove(ljc);
				ljc=new KZMap();
				add(ljc);
			}
			if("李家村".equals(msg)){
				remove(ljc);
				ljc=new LJCMap();
				add(ljc);
			}
			//刷新组件 重绘
			validate();
			repaint();
		}
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		FrameMain fm = new FrameMain();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}



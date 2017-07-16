package com.maoyulu.xianjian;

import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 * 地图的构造父类，继承自JPanel，仅一个返回类型为String类型的空值 的监听按钮的函数
 * @author Administrator
 *
 */
public class Map extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public String keyPressed(KeyEvent e){
		return "";
	}
}
package com.myl.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * 2.дһ��txt�ļ� ��Ҫ�� ��3��ѧ������Ϣ д���ı��У�
  �ٰ��� ��
   ����  ���� ѧ�� 
  �� ���������ѧ�� ����Ϣ ���Ұ� ѧ�Ŵ�С�������С�
  �� Ҫ�� txt�ļ�����  ���յ�ǰʱ�䴴���ġ�   
 */
public class TxtTest {
	//����ȫ�ֳ������ƶ�txt�д洢��ѧ������
	public final static  int STUDENTNUM = 3 ;
	
	public static void main(String[] args) {
		File  file = new File("2017-07-06.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String[] line = new String [STUDENTNUM+1];
			int i = 0;
			while ((line[i]= br.readLine())!=null) {
				line[i] = line[i].trim();
				i++;
			}
			for (int j = 0; j < line.length-2; j++) {
				String  temp = "";
				if (line[j].charAt(0) > line[j+1].charAt(0)) {
					temp = line[j];
					line[j] = line[j+1];
					line[j+1] = temp;
				}
			}
			for (int j = 0; j < line.length-1; j++) {

				System.out.println(line[j]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (null != br) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}



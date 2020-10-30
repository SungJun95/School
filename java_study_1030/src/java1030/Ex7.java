package java1030;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex7 
{
	public static void main(String[] args) 
	{
		
		// ���� �����ϱ� (�о�ͼ� ����ϱ�)
		File src = new File("C:/fol", "heart.jpg"); // ���ã��
		File dest = new File("C:/fol", "heart_���纻.jpg");
		
		
		// �ܼ� str�� �ƴ� ���ϰ�ü�� ��ΰ����Ѱ��ָ� �̷������� �˼��� ����
		if (!src.exists()) {
			System.out.println("������ ������ �������� �ʽ��ϴ�.");
			return;
		}
		
		// �Է½�Ʈ�� �غ�
		BufferedInputStream bis = null;
		
		// ��½�Ʈ�� �غ�
		FileOutputStream fos = null;
		
		try 
		{					
			bis = new BufferedInputStream(new FileInputStream(src)); 
							
			fos = new FileOutputStream(dest); // ���纻 ���� ����
			
			int data;
			while((data = bis.read()) != -1) // ���ϳ��� ������ -1 �� ����
			{
				fos.write(data);
			}
			
			System.out.println("���Ϻ��� �Ϸ��...");
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				bis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}		// main

}

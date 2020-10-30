package java1030;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex5 
{
	public static void main(String[] args) 
	{
		
		// �ؽ�Ʈ ���� �����ϱ� (�о�ͼ� ����ϱ�)
		File src = new File("C:/fol", "�����α׷���_�н�.txt"); // ���ã��
		File dest = new File("C:/fol", "�����α׷���_�н� - ���纻.txt");
		
		
		// �ܼ� str�� �ƴ� ���ϰ�ü�� ��ΰ����Ѱ��ָ� �̷������� �˼��� ����
		if (!src.exists()) {
			System.out.println("������ ������ �������� �ʽ��ϴ�.");
			return;
		}
		
		// �Է½�Ʈ�� �غ�
		BufferedReader reader = null;
		
		// ��½�Ʈ�� �غ�
		FileWriter writer = null;
		
		try 
		{					// ���ϸ������� �ѱ��ھ� �����ͼ� ���۵忡 ����������δ�
			reader = new BufferedReader(new FileReader(src)); // ���ϸ����� ������ �о���� ���۵� ������ ���۸� ����
			
			writer = new FileWriter(dest); // ���纻 ���� ����
			
			String line = "";
			while((line = reader.readLine()) != null) 
			{
				writer.write(line + "\n"); // ���������� ���ۿ��� \n�� ������ �о���⶧���� ���ٸ��� \n �߰�
			}
			
			System.out.println("���Ϻ��� �Ϸ��...");
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}		// main
}

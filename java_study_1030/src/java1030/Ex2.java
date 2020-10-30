package java1030;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2 
{

	public static void main(String[] args) 
	{
		//InputStreamReader �� �ѱ� �ؽ�Ʈ���� �б�
		FileInputStream fis = null; // FileInputStream�� ���� �ý����� ���Ϸκ��� �Է� ����Ʈ�� ����մϴ�. ��� ������ ��ȿ�Ѱ��� ȣ��Ʈ ȯ�濡 �����մϴ�.
									// FileInputStream�� ���ù���Ʈ (�̹��� �����͵�)�� ��Ʈ���� �о���� �� ����մϴ�. ������ ��Ʈ���� �о���� ���� FileReader�� ����� �ּ���.
									// FileReader(��� ����Ʈ����) �� �̿��ؼ� ������ �о���� �ʴ� ������ InputStreamReader�� �̿��ϱ� ���ؼ��� �ּҴ���(���̳ʸ�?)�� ���� �޾ƿ;� �ϱ⶧��
		
		InputStreamReader reader = null; // InputStreamReader�� ����Ʈ ��Ʈ���κ��� ���� ��Ʈ������ �߰��� ������ ����, ����Ʈ �����͸� �б�, 
										 // ������ charset�� ����� ���ڷ� ��ȯ�մϴ�. ���Ǵ� ĳ���ͼ��� �̸����� �����ϴ���, ��������� �ǳ��ִ���, �Ǵ� �÷����� ����Ʈ�� ĳ���ͼ¸� �״�� ����� ���� �ֽ��ϴ�.
		
		
		try 
		{
			fis = new FileInputStream("C:/fol/�����α׷���_�н�.txt");
			reader = new InputStreamReader(fis, "utf-8");
			
			int c;
			
			while ( (c =  reader.read()) != -1)
			{
				System.out.print( (char) c);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				reader.close();		// reader�ȿ� fis�� �����ִ� ���±⶧���� reader�� �ݾ��ָ� fis�� �ڵ����� ���� ������.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}			// main

}

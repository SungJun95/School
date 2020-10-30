package java1030;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex1 
{

	public static void main(String[] args) 
	{
		// �ڹ� IO(�����) ������ ����
		
		
		// byte(8bit) ���� ó�� ����� : �̹������� ���� ���̳ʸ�(2����) ������ ������ ����� + ���������� �ؽ�Ʈ������ �ƴ� ��ǻ�� ����
		// 		InputStream �������̽� ������ Ŭ����
		//		- FileInputStream , BufferedInputStream
		//	    OutputStream �������̽� ������ Ŭ����
		//		- FileOutputStream , BufferedOutputStream
		
		
		// char ���� ó�� ����� : ������� char(����)ó��, �ؽ�Ʈ ������ ������ �����
		// Reader �������̽� ������ Ŭ����
									//�� *�ܺζ��̺귯������ �޾ƿ��� ���ϰ��� ��ǲ,�ƿ�ǲ��Ʈ�� ��ü �ΰ�쿡 ���̻��
		// 		- FileReader , InputStreamReader*, BufferedReader
		// Writer �������̽� ������ Ŭ����
		//		- FileWriter , OutputStreamWriter*, WriterBuffered
		
		
		// ex FileReader�� �ؽ�Ʈ ���� �о �ܼ�ȭ�鿡 ����ϱ�. (!.hwp , .doc ���� ������ ���̳ʸ��� ������ .java �ڵ尰���� txt�α���)
		
		// �Է½�Ʈ�� �غ�
		FileReader reader = null;
		
		try {
			reader = new FileReader("C:/Window/system.ini");
		
			// �����ϳ��� 2byte ������ 4byte
			// read�޼ҵ�� ���ڸ� �Ѱ��� �����´�.
			// read�޼ҵ��� ��ȯ���� int���� ������(4byte int�� �ʿ���������) �����Ǹ������� -1�� ��Ÿ���⶧��.
			
			int c;
			while( (c = reader.read()) != -1) // ������ ���� �ƴҶ����� ���� end of file
			{ 
				
						//	  char �� ��������ȯ �������������� ���ڷ� ��Ÿ�� + �ѱ�ó�� �����ָ� �ѱۃ���
				System.out.print( (char) c);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close(); // �޸� ���������� ���ؼ� �ݾ������ + �������� ���ܰ� �߻��Ҽ��ֱ⶧���� �ѹ��� try catch
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		

	}		// main

}

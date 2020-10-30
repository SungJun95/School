package java1030;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex3 
{
	public static void main(String[] args) 
	{
		// �굵 ����Ʈ����
		// System.in.read();
		
		// �Է� ��Ʈ�� �غ�
		Scanner sc = new Scanner(System.in);  // System.in�� InputStream ���·� �����Ǿ� �ִ�. System Ŭ������ �ڹ� ���߾� �ӽ��� �����ϰ� �ִ� ǥ�� ��ġ�� ���ϴ� Ŭ�����̴�. 
											  // �ڹ� ���߾� �ӽ��� �� ��ü�� �Ϻ��� �ϳ��� ��ǻ�� �÷����� �����ϰ� �ֱ� ������ 
											  // ���������� ������ �� �ִ� ������ ǥ���ϱ� ���Ͽ� ǥ�� �Է°� ǥ�� ����� �������� System Ŭ������ ����Ͽ� ����Ѵ�.

		
		// ��� ��Ʈ�� �غ�
		FileWriter writer = null;
		try 
		{								
								// append ������ true �� �ְԵǸ� �����ۿ� �߰������� �����̵ǰ�, false�� �������ִ������� �����ǰ� ����Եȴ�
			writer = new FileWriter("C:/fol/test.txt",false);
			
			// sc.nextLine(); // txt�� ���پ�(\n�� ������) �����´� + ��ĳ�ʴ� ���������� ���۸� ����������.
			
			System.out.println("Ű����� ���ڸ� �Է��ϼ���");
			String Line = "";
			
			while(true)
			{	
				Line = sc.nextLine();
				
				if(Line.length() == 0) // ����Ű���Է��� ���ڿ��� �Է��Ѱ�� ������.
				{
					break;
				}
				
				writer.write(Line + "\n");  // txt���Ͽ� ����ؼ� ����.  +  nextLine()�� \n �ν������ʱ⶧���� \n�� �߰�����
											// ��½�Ʈ�� ��ü�� �⺻������ ���۸� ����. (�Է��� �׷�������)
											// ���۸� �������ֱ⶧���� close()�ÿ� �Է��ߴ� �����͵��� txt�� ���Ե�
				
				writer.flush(); // ���Ҷ� �ٷιٷ� �����ϴ°͵� ����(���ۺ���)
				
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			sc.close();
			try {
				writer.close(); // close() �޼ҵ尡 ���������� flush ���ۺ��⸦ ���ش�
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

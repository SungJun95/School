package java1030;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex3 
{
	public static void main(String[] args) 
	{
		// 얘도 바이트단위
		// System.in.read();
		
		// 입력 스트림 준비
		Scanner sc = new Scanner(System.in);  // System.in은 InputStream 형태로 지정되어 있다. System 클래스는 자바 버추얼 머신을 구성하고 있는 표준 장치를 뜻하는 클래스이다. 
											  // 자바 버추얼 머신은 그 자체가 완벽한 하나의 컴퓨터 플랫폼을 가정하고 있기 때문에 
											  // 독립적으로 동작할 수 있는 구조를 표현하기 위하여 표준 입력과 표준 출력을 스스로의 System 클래스에 등록하여 사용한다.

		
		// 출력 스트림 준비
		FileWriter writer = null;
		try 
		{								
								// append 값으로 true 를 주게되면 기존글에 추가적으로 기입이되고, false면 기존에있던내용이 삭제되고 덮어쓰게된다
			writer = new FileWriter("C:/fol/test.txt",false);
			
			// sc.nextLine(); // txt를 한줄씩(\n앞 까지만) 가져온다 + 스캐너는 내부적으로 버퍼를 가지고있음.
			
			System.out.println("키보드로 문자를 입력하세요");
			String Line = "";
			
			while(true)
			{	
				Line = sc.nextLine();
				
				if(Line.length() == 0) // 엔터키만입력해 빈문자열을 입력한경우 끝난다.
				{
					break;
				}
				
				writer.write(Line + "\n");  // txt파일에 출력해서 기입.  +  nextLine()은 \n 인식하지않기때문에 \n을 추가해줌
											// 출력스트림 객체는 기본적으로 버퍼를 가짐. (입력은 그렇지않음)
											// 버퍼를 가지고있기때문에 close()시에 입력했던 데이터들이 txt에 기입됨
				
				writer.flush(); // 원할때 바로바로 기입하는것도 가능(버퍼비우기)
				
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
				writer.close(); // close() 메소드가 내부적으로 flush 버퍼비우기를 해준다
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

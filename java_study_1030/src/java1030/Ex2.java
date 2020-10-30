package java1030;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2 
{

	public static void main(String[] args) 
	{
		//InputStreamReader 로 한글 텍스트파일 읽기
		FileInputStream fis = null; // FileInputStream는 파일 시스템의 파일로부터 입력 바이트를 취득합니다. 어느 파일이 유효한가는 호스트 환경에 의존합니다.
									// FileInputStream는 원시바이트 (이미지 데이터등)의 스트림을 읽어들일 때 사용합니다. 문자의 스트림을 읽어들일 때는 FileReader를 사용해 주세요.
									// FileReader(얘는 바이트단위) 를 이용해서 파일을 읽어오지 않는 이유는 InputStreamReader을 이용하기 위해서는 최소단위(바이너리?)로 값을 받아와야 하기때문
		
		InputStreamReader reader = null; // InputStreamReader는 바이트 스트림로부터 문자 스트림에의 중개의 역할을 가져, 바이트 데이터를 읽기, 
										 // 지정된 charset를 사용해 문자로 변환합니다. 사용되는 캐릭터셋은 이름으로 지정하는지, 명시적으로 건네주는지, 또는 플랫폼의 디폴트의 캐릭터셋를 그대로 사용할 수도 있습니다.
		
		
		try 
		{
			fis = new FileInputStream("C:/fol/웹프로그래밍_학습.txt");
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
				reader.close();		// reader안에 fis가 잡혀있는 상태기때문에 reader만 닫아주면 fis도 자동으로 같이 닫힌다.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}			// main

}

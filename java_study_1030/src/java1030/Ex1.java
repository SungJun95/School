package java1030;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex1 
{

	public static void main(String[] args) 
	{
		// 자바 IO(입출력) 데이터 종류
		
		
		// byte(8bit) 단위 처리 입출력 : 이미지파일 등의 바이너리(2진법) 위주의 데이터 입출력 + 이진파일은 텍스트파일이 아닌 컴퓨터 파일
		// 		InputStream 인터페이스 구현한 클래스
		//		- FileInputStream , BufferedInputStream
		//	    OutputStream 인터페이스 구현한 클래스
		//		- FileOutputStream , BufferedOutputStream
		
		
		// char 단위 처리 입출력 : 입출력을 char(문자)처리, 텍스트 위주의 데이터 입출력
		// Reader 인터페이스 구현한 클래스
									//↓ *외부라이브러리에서 받아오는 리턴값이 인풋,아웃풋스트림 객체 인경우에 많이사용
		// 		- FileReader , InputStreamReader*, BufferedReader
		// Writer 인터페이스 구현한 클래스
		//		- FileWriter , OutputStreamWriter*, WriterBuffered
		
		
		// ex FileReader로 텍스트 파일 읽어서 콘솔화면에 출력하기. (!.hwp , .doc 같은 파일은 바이너리로 구성됨 .java 코드같은건 txt로구성)
		
		// 입력스트림 준비
		FileReader reader = null;
		
		try {
			reader = new FileReader("C:/Window/system.ini");
		
			// 문자하나는 2byte 정수는 4byte
			// read메소드는 문자를 한개씩 가져온다.
			// read메소드의 반환값이 int형인 이유는(4byte int가 필요한이유는) 문자의마지막이 -1로 나타나기때문.
			
			int c;
			while( (c = reader.read()) != -1) // 파일의 끝이 아닐때까지 실행 end of file
			{ 
				
						//	  char 로 강제형변환 을해주지않으면 숫자로 나타남 + 한글처리 안해주면 한글꺠짐
				System.out.print( (char) c);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close(); // 메모리 누수방지를 위해서 닫아줘야함 + 닫을때도 예외가 발생할수있기때문에 한번더 try catch
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		

	}		// main

}

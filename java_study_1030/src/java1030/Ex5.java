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
		
		// 텍스트 파일 복사하기 (읽어와서 출력하기)
		File src = new File("C:/fol", "웹프로그래밍_학습.txt"); // 경로찾기
		File dest = new File("C:/fol", "웹프로그래밍_학습 - 복사본.txt");
		
		
		// 단순 str이 아닌 파일객체로 경로값을넘겨주면 이런식으로 검수가 가능
		if (!src.exists()) {
			System.out.println("복사할 파일이 존재하지 않습니다.");
			return;
		}
		
		// 입력스트림 준비
		BufferedReader reader = null;
		
		// 출력스트림 준비
		FileWriter writer = null;
		
		try 
		{					// 파일리더에서 한글자씩 가져와서 버퍼드에 차곡차곡쌓인다
			reader = new BufferedReader(new FileReader(src)); // 파일리더로 파일을 읽어오고 버퍼드 리더가 버퍼를 제공
			
			writer = new FileWriter(dest); // 복사본 정보 전달
			
			String line = "";
			while((line = reader.readLine()) != null) 
			{
				writer.write(line + "\n"); // 마찬가지로 버퍼에서 \n앞 까지만 읽어오기때문에 한줄마다 \n 추가
			}
			
			System.out.println("파일복사 완료됨...");
			
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

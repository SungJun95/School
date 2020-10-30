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
		
		// 파일 복사하기 (읽어와서 출력하기)
		File src = new File("C:/fol", "heart.jpg"); // 경로찾기
		File dest = new File("C:/fol", "heart_복사본.jpg");
		
		
		// 단순 str이 아닌 파일객체로 경로값을넘겨주면 이런식으로 검수가 가능
		if (!src.exists()) {
			System.out.println("복사할 파일이 존재하지 않습니다.");
			return;
		}
		
		// 입력스트림 준비
		BufferedInputStream bis = null;
		
		// 출력스트림 준비
		FileOutputStream fos = null;
		
		try 
		{					
			bis = new BufferedInputStream(new FileInputStream(src)); 
							
			fos = new FileOutputStream(dest); // 복사본 정보 전달
			
			int data;
			while((data = bis.read()) != -1) // 파일끝을 만나면 -1 을 리턴
			{
				fos.write(data);
			}
			
			System.out.println("파일복사 완료됨...");
			
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

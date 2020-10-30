package java1030;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex4 
{
	
	public static void listDirectory(File dir) 
	{
		System.out.println("---" + dir.getPath() + "의 서브 리스트입니다.");
		
		File[] files =  dir.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(File file : files)
		{
			System.out.print(file.getName());
			System.out.print(file.isDirectory() ? "\t<DIR>" : "\t");
			System.out.print("\t파일크기" + file.length());
			
			// System.out.println("\t수정한 시간: " + file.lastModified());
			long milis = file.lastModified();
			Date date = new Date(milis);
			String str = sdf.format(date);
			System.out.println("\t수정한 시간: " + str);
		}		//for
	}
	
	
	public static void main(String[] args) 
	{
		// File 클래스 (입출력을 수행하는 기능은없음) File 클래스는 입출력에 필요한 파일 및 디렉토리에 관한 정보를 다를 수 있다. 
										  // File 클래스는 파일과 디렉토리의 접근 권한, 생성된 시간, 마지막 수정 일자, 크기, 경로 등의 정보를 얻을 수 메소드를 가지고 있으며, 
										  // 새로운 파일과 디렉토리 생성 및 삭제, 이름 변경 등의 조작 메소드를 가지고 있다.
		File file1 = new File("C:/fol/웹프로그래밍_학습.txt");
		
		System.out.println(file1.getPath()); // 경로가져오기
		System.out.println(file1.getParent()); // 상위폴더 경로
		System.out.println(file1.getName()); // 파일 이름
		
		
		if(file1.isFile())
		{
			System.out.println("파일입니다.");
		} else if (file1.isDirectory()) {
			System.out.println("디렉토리입니다.");
		}
		
		
		
		File file2 = new File("C:/fol/sample"); // 새로만들고자하는 디렉토리정보를 파일객체로 준비함
		if (!file2.exists()) // sample이 없으면 
		{
			file2.mkdir();
			// file2.mkdirs() = "C:/fol/sample/a/b/c" 한번에 다만들때 메소드
		}
		
		
		listDirectory(new File("C:/Windows/Boot/PCAT"));
	} 			// main
}

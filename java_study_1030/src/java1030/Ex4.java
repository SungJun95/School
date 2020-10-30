package java1030;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex4 
{
	
	public static void listDirectory(File dir) 
	{
		System.out.println("---" + dir.getPath() + "�� ���� ����Ʈ�Դϴ�.");
		
		File[] files =  dir.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(File file : files)
		{
			System.out.print(file.getName());
			System.out.print(file.isDirectory() ? "\t<DIR>" : "\t");
			System.out.print("\t����ũ��" + file.length());
			
			// System.out.println("\t������ �ð�: " + file.lastModified());
			long milis = file.lastModified();
			Date date = new Date(milis);
			String str = sdf.format(date);
			System.out.println("\t������ �ð�: " + str);
		}		//for
	}
	
	
	public static void main(String[] args) 
	{
		// File Ŭ���� (������� �����ϴ� ���������) File Ŭ������ ����¿� �ʿ��� ���� �� ���丮�� ���� ������ �ٸ� �� �ִ�. 
										  // File Ŭ������ ���ϰ� ���丮�� ���� ����, ������ �ð�, ������ ���� ����, ũ��, ��� ���� ������ ���� �� �޼ҵ带 ������ ������, 
										  // ���ο� ���ϰ� ���丮 ���� �� ����, �̸� ���� ���� ���� �޼ҵ带 ������ �ִ�.
		File file1 = new File("C:/fol/�����α׷���_�н�.txt");
		
		System.out.println(file1.getPath()); // ��ΰ�������
		System.out.println(file1.getParent()); // �������� ���
		System.out.println(file1.getName()); // ���� �̸�
		
		
		if(file1.isFile())
		{
			System.out.println("�����Դϴ�.");
		} else if (file1.isDirectory()) {
			System.out.println("���丮�Դϴ�.");
		}
		
		
		
		File file2 = new File("C:/fol/sample"); // ���θ�������ϴ� ���丮������ ���ϰ�ü�� �غ���
		if (!file2.exists()) // sample�� ������ 
		{
			file2.mkdir();
			// file2.mkdirs() = "C:/fol/sample/a/b/c" �ѹ��� �ٸ��鶧 �޼ҵ�
		}
		
		
		listDirectory(new File("C:/Windows/Boot/PCAT"));
	} 			// main
}

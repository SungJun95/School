package java0922;

import java.util.*;

public class Ex4 {

	public static void main(String[] args) {
		// Map �÷���: Ű�� ���� ������ ������ �����ϴ� �ڷᱸ��
		
		Map<String, Animal> animalMap = new HashMap<>();
		
//		�� �÷����� ��� �����͸� ��������
		Set<String> keySet = animalMap.keySet();
	
//		'Ű'�� '��'���� �� �߰�
		animalMap.put("Ǫ��", new Puppy());
		animalMap.put("�����", new Cat());
		animalMap.put("����", new Duck());
		
//		Ű�� ���ؼ� �� ��������
		Animal ani = animalMap.get("Ǫ��");
		ani.speak();
		
//		Ű���� �����ϸ� �߰��� �ƴϰ� �����۾��̰� �ȴ�
		animalMap.put("Ǫ��", new Puppy(8, "����"));
		ani = animalMap.get("Ǫ��");
		ani.speak();
		
		for (String key : keySet)
		{
			Animal animal = animalMap.get(key);
			System.out.println(animal);
		}
		
//		Ư�� ������ ����
		animalMap.remove("Ǫ��");
		
//		��� ������ ����
		animalMap.clear();
		
		

	} // main

}

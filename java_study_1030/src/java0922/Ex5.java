package java0922;

class Parent {
	private int num;
	
//	Parent() {
//	}
	
	Parent(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}

class Child extends Parent {
	String str;
	
	Child() {
		// �����Ϸ��� ������ ��� �ȿ���
		// ������ ù���ο� �θ�Ŭ������ �⺻������ ȣ�⹮�� ������.
		super(10);
		
		str = "���ڿ�";
		
		
//		setNum(10);
	}
}


public class Ex5 {

	public static void main(String[] args) {
		Child child = new Child();
	}

}

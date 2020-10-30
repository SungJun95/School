package java0924;

class GoThread extends Thread {

	@Override
	public void run() // �������� ���� �޼ҵ�
	{
		go();
	}

	void go() {
		while (true) {
			System.out.println("go");
		}
	}
} // GoThread

class ComeThread extends Thread {

	@Override
	public void run() {
		come();
	}

	void come() {
		while (true) {
			System.out.println("come");
		}
	}
} // ComeThread

public class Ex2 {
	public static void main(String[] args) {
//		��Ƽ������ �������
//		1. java.lang.Thread Ŭ���� ���
//		   run() �޼ҵ� �������̵�
//		   ������ ��ü�� start() ȣ���ؼ� ������ ���۽�Ŵ

//		������ ��ü����. �����尴ü�� ������ �غ��.
//		�����尴ü�� �ϲۿ� �ش�
		GoThread goThread = new GoThread();
		ComeThread comeThread = new ComeThread();
		
		goThread.start(); // JVM���� ������ ������ ��Ź�� -> JVM�� �����尴ü�� run() ȣ����.
		comeThread.start();

	}
}
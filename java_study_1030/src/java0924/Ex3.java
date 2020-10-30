package java0924;

class GoTask implements Runnable 
{
	@Override
	public void run() 
	{
		go();
	}
	void go() {
		while (true) {
			System.out.println("go");
		}
	}
} // GoThread

class ComeTask implements Runnable {

	@Override
	public void run() 
	{
		come();
	}

	void come() {
		while (true) {
			System.out.println("come");
		}
	}
} // ComeThread

public class Ex3 {
	public static void main(String[] args) {
//		��Ƽ������ �������
//		2. java.lang.Runnable �������̽� ������ �۾�Ŭ���� ����
//		   run() �޼ҵ� �������̵�
//		   ������ ��ü ���� �� Runnable ������ü�� �����ϰ� start() ȣ���ؼ� ������ ���۽�Ŵ

//		������ ��ü����. �����尴ü�� ������ �غ��.
		
//		�����尴ü(�ϲ�)�� �غ��ϰ� ����(Runnable ������ü��) ������
		GoTask goTask = new GoTask(); // ����
		Thread thread1 = new Thread(goTask);  // �ϲۿ��� ������ ������
		Thread thread2 = new Thread(new ComeTask());
		
		thread1.start();
		thread2.start(); 

	}
}
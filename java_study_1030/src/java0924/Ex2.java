package java0924;

class GoThread extends Thread {

	@Override
	public void run() // 스레드의 시작 메소드
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
//		멀티스레드 생성방법
//		1. java.lang.Thread 클래스 상속
//		   run() 메소드 오버라이딩
//		   스레드 객체의 start() 호출해서 스레드 시작시킴

//		스레드 객체생성. 스레드객체당 스택이 준비됨.
//		스레드객체는 일꾼에 해당
		GoThread goThread = new GoThread();
		ComeThread comeThread = new ComeThread();
		
		goThread.start(); // JVM에게 스레드 시작을 부탁함 -> JVM이 스레드객체의 run() 호출함.
		comeThread.start();

	}
}
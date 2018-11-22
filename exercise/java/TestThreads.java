
public class TestThreads {
	public static void main(String args[]) {

		int minusOne   = 0b11111111111111111111111111111111;
		System.out.println(minusOne);
		
		System.out.println("main.thread");
		System.out.println("main.thread: " + Thread.currentThread().isDaemon());
		
		Thread t1 = new MyThread();
		t1.setDaemon(true);
		t1.start();
		
		t1.interrupt();
		
		System.out.println("main.thread join t1");
		try {
			t1.join();
		} catch (InterruptedException inrExp) {
			
		}
		
		System.out.println("main.thread exit");
	}
}

class MyThread extends Thread {
	public void run() {
		try {
			Thread.sleep(1000 * 3);
		} catch (InterruptedException inrExp) {
			System.out.println("my.thread got InterruptedException");
			return;
		}
		
		System.out.println("my.thread");
		System.out.println("my.thread: " + Thread.currentThread().isDaemon());
		System.out.println("my.thread exit");
	}
}

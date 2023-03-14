import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Process {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void produce() throws InterruptedException {
		lock.lock();
		System.out.println("Producer method");
		condition.await();
		System.out.println("Again Producer method");
		lock.unlock();
	}

	public void consume() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();
		System.out.println("consume method");
		Thread.sleep(3000);
		condition.signal();//Wakes up one waiting thread. // works like notify
		System.out.println("Again consume method");
		lock.unlock();

	}
}

public class ProducerConsumerPattern {
	public static void main(String[] args) {
		Process process = new Process();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {
					process.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					process.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

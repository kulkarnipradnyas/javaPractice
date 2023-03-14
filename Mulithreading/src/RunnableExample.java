
public class RunnableExample {
	 static int counter=0;
	 static int counter1=0;
	 // lock can be acquired at a time to resolve this problem
	 private static final Object lock1= new Object();
	 private static final Object lock2= new Object();
//	public static synchronized void increment() {
//		counter++;
//	}
//	public static synchronized void increment1() {
//		counter1++;
//	}
	
	 // solution for block class based locking, at a time 1 lock acquired (single intrinsic lock)
	public static  void increment() {
		synchronized(lock1) {
			counter++;
		}
	
	}
	public static synchronized void increment1() {
		synchronized(lock2) {
			counter1++;
		}
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(2000);
						increment();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Runner 1: " + i);
				}

			}
		});
		t1.start();

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(2000);
						increment1();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Runner 2: " + i);
				}
			}
		});
		t2.start();
		try {
			// this will wait for t1 to finish, if t1 finished before 2 then it will sysout below line and then keep finishing t2
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("finished");
		System.out.println(counter +" :counter value");// result should come 20, as sycnhonized method called.

	}

}

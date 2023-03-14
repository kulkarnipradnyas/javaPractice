import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Work implements Runnable{
	private int id;
	public Work(int id) {
		this.id=id;
	}

	@Override
	public void run() {
		System.out.println("Work with id" + id + " is in work - thread is" + Thread.currentThread());
		long duration =(long) (Math.random() * 5);	
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
public class FixedThreadExecutor {
	public static void main(String[] args) {
		// it is single thread hence execute tasks sequentially
		ExecutorService executor= Executors.newFixedThreadPool(2);
		for(int i=0;i <10; i++){
			executor.execute(new Work(i + 1));
		}
		//shut down executor
		executor.shutdown();
		try {
			if(executor.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
				//executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			executor.shutdownNow();
		}
		
	}

}

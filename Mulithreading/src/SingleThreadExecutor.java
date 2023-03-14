import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable{
	private int id;
	public Task(int id) {
		this.id=id;
	}

	@Override
	public void run() {
		System.out.println("Task with id" + id + " is in work - thread is" + Thread.currentThread().getId());
		long duration =(long) (Math.random() * 5);	
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
public class SingleThreadExecutor {
	public static void main(String[] args) {
		// it is single thread hence execute tasks sequentially
		Executor executor= Executors.newSingleThreadExecutor();
		for(int i=0;i <5; i++){
			executor.execute(new Task(i));
		}
		//shut down executor
		
	}

}

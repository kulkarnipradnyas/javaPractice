import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
//To solve producer consumer problem

//singleton pattern
enum Downloader {
	INSTANCE;

	// only 3 threads can download at a time
	private Semaphore semaphore = new Semaphore(3, true); // permits and fairness

	public void download() {

		try {
			semaphore.acquire();
			downloadData();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaphore.release();
		}

	}

	void downloadData() {
		try {
			System.out.println("downloding data from web");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class SemaphoreExample {
	public static void main(String[] args) {

		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 12; i++) {
			service.execute(new Runnable() {

				@Override
				public void run() {
					Downloader.INSTANCE.download();

				}
			});

		}
	}
}

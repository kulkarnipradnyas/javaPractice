import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class StockMarketUpdater implements Runnable {

	@Override
	public void run() {
		System.out.println("updating and downloading stock related data from web");
		
	}
	
}
public class ScheduledExecutor {
	public static void main(String[] args) {
		ScheduledExecutorService executor=Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(new StockMarketUpdater(), 1000, 50000, TimeUnit.MICROSECONDS);
		
	}
}

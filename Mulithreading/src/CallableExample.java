import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Processor implements Callable<String> {
	private int id;

	Processor(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		return "ID:" + id;
	}

}

public class CallableExample {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		List<Future<String>> list = new ArrayList<>();

		for (int i = 0; i < 10; ++i) {
			Future<String> future = service.submit(new Processor(i+1));
			list.add(future);

		}
		for(Future<String> f: list) {
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

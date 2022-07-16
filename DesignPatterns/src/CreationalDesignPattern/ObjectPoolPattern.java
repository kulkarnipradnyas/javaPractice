/*
 * Object pools (otherwise known as resource pools) are used to manage the object caching.
 * A client with access to a Object pool can avoid creating a new Objects by simply asking the pool for one that has already been instantiated instead.
 * Generally the pool will be a growing pool, i.e. the pool itself will create new objects if the pool is empty,
 * or we can have a pool, which restricts the number of objects created.
 * 
 * Use the Object Pool pattern when:
 * 1.The objects are expensive to create (allocation cost).
 * 2.You need a large number of short-lived objects (memory fragmentation).
 */
package CreationalDesignPattern;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

class CounterIncrement {

	private static final AtomicInteger counter = new AtomicInteger(0);

	private final int id;

	public CounterIncrement() {
		id = counter.incrementAndGet();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Oliphaunt id=%d", id);
	}
}

abstract class ObjectPool<T> {

	private final Set<T> available = new HashSet<>();
	private final Set<T> inUse = new HashSet<>();

	// this method being called in ObjectPoolPattern
	protected abstract T create();

	public synchronized T checkOut() {
		if (available.isEmpty()) {
			available.add(create());
		}
		T instance = available.iterator().next();
		available.remove(instance);
		inUse.add(instance);
		return instance;
	}

	public synchronized void checkIn(T instance) {
		inUse.remove(instance);
		available.add(instance);
	}

	@Override
	public synchronized String toString() {
		return String.format("Pool available=%d inUse=%d", available.size(), inUse.size());
	}
}

class CounterIncrementPool extends ObjectPool<CounterIncrement> {
	@Override
	protected CounterIncrement create() {
		return new CounterIncrement();
	}
}

public class ObjectPoolPattern  {
	public static void main(String[] args) {
		CounterIncrementPool pool = new CounterIncrementPool();
//		CounterIncrementPool oliphaunt1 = pool.checkOut();
//		CounterIncrementPool oliphaunt2 = pool.checkOut();
//		CounterIncrementPool oliphaunt3 = pool.checkOut();
//	    pool.checkIn(oliphaunt1);
//	    pool.checkIn(oliphaunt2);
//	    CounterIncrementPool oliphaunt4 = pool.checkOut();
//	    CounterIncrementPool oliphaunt5 = pool.checkOut();
	}
	
}

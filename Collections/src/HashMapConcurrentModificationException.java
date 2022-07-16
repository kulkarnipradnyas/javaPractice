import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Consumer;


// put, remove, containsKey, containsValue, get, keySet, values, size
public class HashMapConcurrentModificationException {

	public static void main(String args[]) {
		Map<Integer,String> lm= new HashMap<>();
		lm.put(1, "Mahan");
		lm.put(2, "Vihan");
		Iterator<Entry<Integer,String>> it= lm.entrySet().iterator();
		while(it.hasNext()) {
			Integer key= it.next().getKey();
			// Exception in thread "main" java.util.ConcurrentModificationException
			if(key.equals(1)) {
				//lm.put(3,"assd");
				//lm.remove(2);
			}
			
		}
		//lm.remove(2);
		System.out.println(lm.get(2));	
		if(lm.containsKey(1)) {
			lm.replace(1, "Replaced Mahan");
			System.out.println("this key is present");
		}
		if(lm.containsValue("Vihan")) {
			System.out.println("this value is present");
		}
		
		System.out.print( "size: " + lm.size() + "   \n");
		System.out.print( "values: " + lm.values() +"  \n");
		System.out.print( "Keys: " + lm.keySet() +"  \n");
		
		BiConsumer<Integer,String> cons1=(i,s)-> System.out.println(s + " consumer");
		//java 8
		lm.forEach(cons1);
		lm.merge(5, "5 value added merge", (k, v) -> {return k + v;}); // key not present
		String value = lm.putIfAbsent(3, "new 3 rd if absent");
		System.out.println("map after putIfAbsent = "+lm);
		System.out.println("putIfAbsent returns: "+value);


		Map<Integer,Employee> em= new HashMap<>();
		// same key but different object
		em.put(1, new Employee("PK",1));
		em.put(1, new Employee("DK",1));
		String name= em.get(1).getName();
		System.out.print( "name: " + name );
		
	}

}

import java.util.function.BiConsumer;

 class HashMapCustom<K, V> {
	private Entry<K, V>[] table;
	private int capacity = 16;
	private float loadFactor = 0.75f;

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public HashMapCustom() {
		table = new Entry[capacity];
	}

	public int getHash(K key) {
		return key.hashCode();
	}

	public void put(K newKey, V data) {
		 int hash = newKey.hashCode() % capacity;
		Entry e = table[hash];
		 if(e != null) {
			 
		 }else {
			 
		 }
	}

}

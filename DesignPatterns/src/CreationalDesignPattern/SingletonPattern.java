package CreationalDesignPattern;

public class SingletonPattern {
	private static SingletonPattern singletonObj = null;
	private String data = "Data";

	public SingletonPattern() {

	}

	public SingletonPattern(String d) {
		this.data = d;
	}

	public SingletonPattern getSingletonPatternInstance() {
		// block synchronized use to make it thread safe, instead of making method
		// synchornized we used block
		// this is to overcome overhead, multiple thread not should not wait to resolve
		// this problem blocked synchronization used
		if (singletonObj == null) {
			synchronized (singletonObj) {
				if (singletonObj == null) {
					singletonObj = new SingletonPattern();
				}
			}
		}
		return singletonObj;
	}

}

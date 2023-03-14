
 class ProcessLock {
	public void produce() throws InterruptedException {
			synchronized (this) {
				System.out.println("Running th produce method");
				wait();
				System.out.println("Again in the produce method");
				
			}
	}

	public void consume() throws InterruptedException {
		Thread.sleep(1000);
		synchronized (this) {
			System.out.println("consumer method is executed");
			notify(); // after this, below line executes and then go to produce method to resume
			Thread.sleep(1000);
		}

	}
}

 class ProcessLockExample {
	 public static void main(String[] args) {
		 ProcessLock process=new ProcessLock();
		 Thread t1= new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					process.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		 Thread t2= new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						process.consume();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		 t1.start();
		 t2.start();
		
	}
 }
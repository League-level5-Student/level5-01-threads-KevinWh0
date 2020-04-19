package _03_Threaded_Reverse_Greeting;

public class ThreadedGreeter implements Runnable {
	
	static int threadNumb = 0;

	public ThreadedGreeter(int i) {
		// TODO Auto-generated constructor stub
		threadNumb = i;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//greeter();
		
		if(threadNumb < 51) {
			Thread t = new Thread(() -> this.run());
			System.out.println("Hello from thread " + threadNumb);
			threadNumb ++;

			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

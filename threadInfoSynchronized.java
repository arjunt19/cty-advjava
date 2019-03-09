//this is to run the threads synchronized
public class threadInfoSynchronized implements Runnable{ //implements runnable so it can be run as thread
	private static int x = 0; //static int each thread adds 1 to the same x int
	
	private synchronized void Add1(){ //synchronized method to increment
		x++;
		System.out.println(x);
	}

	public void run() { // run method that calls on increment method
		Add1();
	}

}

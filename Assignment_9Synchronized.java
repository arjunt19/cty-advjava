//Arjun Tammishetti; in order to run thread with and w/o synchronization, two classes are created that use different thread classes
public class Assignment_9Synchronized { //runs with synchronization
	private static int sum = 0; 
	public static void main(String[] args) {
		Thread[] threadsync =  new Thread[50]; //creats array with size 50 to hold 50 different threads
		for (int i = 0; i < 50; i ++) { //for loop that initiates array and then starts thread
			threadsync[i] = new Thread( new threadInfoSynchronized());
			threadsync[i].start();
		}
	}
}

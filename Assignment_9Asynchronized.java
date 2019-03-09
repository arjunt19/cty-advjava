public class Assignment_9Asynchronized {//runs without synchronization
	private static int sum = 0; 
	public static void main(String[] args) {
		Thread[] threadasync =  new Thread[50];
		//for loop and array create 50 threads and start them
		for (int i = 0; i < 50; i ++) { 
			threadasync[i] = new Thread( new threadInfoAsynchronized()); //references asynchronized class
			threadasync[i].start();
		}
	}
}

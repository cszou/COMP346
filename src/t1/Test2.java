package t1;

public class Test2 {
	
	public static void main(String args[]) {
		Thread tr1 = new Thread(new ThreadEx2("alpha"));
		Thread tr2 = new Thread(new ThreadEx2("beta"));
		tr1.start();
		tr2.start();
//		try {
//			tr1.join();
//			tr2.join();
//		}
//		catch (InterruptedException e) {}
		System.out.println("main finished");
	}
}

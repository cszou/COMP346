package t1;

public class SharedArrayGame extends Thread {
	private static final int NI = 5000;
	private static int a[] = new int[2*NI];
	private static int index = 0;
	private int tid;
	private static Object o = new Object();
	public SharedArrayGame(int tid) {
		this.tid = tid;
	}
	public void run() {
		for (int i=0; i<NI; i++) {
			synchronized (o) {
				a[index] = tid;
				index++;
			}
		}
	}
	
	public static void main(String args[]) {
		System.out.println("SharedArrayGame starts");
		SharedArrayGame t1 = new SharedArrayGame(1);
		SharedArrayGame t2 = new SharedArrayGame(2);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		}
		catch(InterruptedException e) {}
		System.out.println("ShareArrayGame done");
		for(int i = 0; i< 2*NI; i++) {
			if(a[i]==1)
				System.out.println("000");
			else if(a[i]==2)
				System.out.println("---");
			else
				System.out.println("EEEEEEEE");
		}
	}
}

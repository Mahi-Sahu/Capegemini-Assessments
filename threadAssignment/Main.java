package threadAssignment;

public class Main {
	public static void main(String[] args) {
		Timer t = new Timer();
		Thread t1 = new Thread(t);
		t1.start();
	}
}

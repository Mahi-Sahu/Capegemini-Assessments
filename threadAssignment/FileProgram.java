package threadAssignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileProgram {
	public static void main(String[] args) {
		FileInputStream f = null;
		try {
			f = new FileInputStream("source.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CopyDataThread cp = new CopyDataThread(f);
		//Thread t1 = new Thread(cp);
		cp.start();
	}
}

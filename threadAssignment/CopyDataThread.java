package threadAssignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
//import java.io.Reader;

public class CopyDataThread extends Thread {
	FileInputStream s;
	public CopyDataThread(FileInputStream d) {
		this.s = d;
	}
	public void copy() throws IOException {
		
		//FileReader fd = new FileReader(s);
		FileOutputStream fw2 = new FileOutputStream("target.txt");
		//FileWriter fw2 = new FileWriter("target.txt");
		
		int data;
		int count = 0;
		
		while((data = s.read()) != -1) {
			if(count < 10) {
			fw2.write((char)data);
			count++;
			}else {
				System.out.println("10 characters are copied");
				count = 0;
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//fd.close();
		fw2.close();
		
	}

	@Override
	public void run() {
		try {
			copy();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

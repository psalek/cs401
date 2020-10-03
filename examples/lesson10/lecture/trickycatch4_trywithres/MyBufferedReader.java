package lesson10.lecture.trickycatch4_trywithres;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class MyBufferedReader extends BufferedReader {

	public MyBufferedReader(Reader in) {
		super(in);
		
	}
	
	@Override
	public void close() throws IOException {
		super.close();
		throw new IOException("Exception in closing BufferedReader.");
	}
	@Override
	public String readLine() throws IOException {
		String valRead = super.readLine();
		throw new IOException("readLine failed");
		//return valRead;
	}

}

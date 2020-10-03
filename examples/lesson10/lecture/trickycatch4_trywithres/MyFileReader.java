package lesson10.lecture.trickycatch4_trywithres;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class MyFileReader extends FileReader {

	public MyFileReader(File file) throws FileNotFoundException {
		super(file);
		
	}
	@Override
	public void close() throws IOException {
		super.close();
		//throw new IOException("Closing MyFileReader threw an exception");
	}

}

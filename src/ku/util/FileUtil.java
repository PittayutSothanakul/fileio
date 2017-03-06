package ku.util;

import java.io.InputStream;
import java.io.OutputStream;
/*
 *   @author Pittayut Sothanakul
 */
public class FileUtil {

	static void copy(InputStream in, OutputStream out) {
		try {
			int count = 0;
			while (count > -1) {
				count = in.read();
				out.write(count);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	static void copy(InputStream in, OutputStream out, int blocksize) {

		try {
			byte[] buffer = new byte[blocksize];
			int count = 0;
			while (count != 1) {
				count = in.read(buffer);
				out.write(count);
			}

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	static void bcopy(InputStream inputStream, OutputStream out) {

	}
}

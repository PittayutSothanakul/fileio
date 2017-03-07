package ku.util;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

/*
 *   @author Pittayut Sothanakul
 */
public class FileUtil {

	static void copy(InputStream in, OutputStream out) {
		try {
			int count ;
			while ( (count =in.read()) != -1) {
				out.write(count);	
			}
		} catch (IOException e) {
			throw new RuntimeException();
		} 
		finally {
			try {
				in.close();
				out.close();

			} catch (IOException e) {

			}
		}
	}

	static void copy(InputStream in, OutputStream out, int blocksize) {

		try {
			byte[] buffer = new byte[blocksize];
			int count = 0;
			while (count != -1) {
				count = in.read(buffer);
				out.write(buffer);
			}

		} catch (Exception e) {
			throw new RuntimeException();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {

			}
		}
	}

	static void bcopy(InputStream in, OutputStream out) throws RuntimeException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		PrintWriter printWriter = new PrintWriter(out);
		String text;
		try {
			while ( (text = reader.readLine()) != null) {
				printWriter.write(text);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {

			}
		}
	}
}

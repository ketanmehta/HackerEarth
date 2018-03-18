import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

/**
 * @author Ketan Mehta
 * @date 16-03-2018
 * @problem_link 
 *               https://www.hackerearth.com/challenge/competitive/airtel-crack-the
 *               -code/algorithm/odd-even-subarrays-72ad69db/
 */

public class OddEvenSubArray {
	static int sumDiffDP[] = new int[10000000];
	static InputReader s=new InputReader(new BufferedInputStream(System.in));
	public static void main(String args[]) throws Exception {
		int n = s.readInt();
		int val = sumDiffDP[0] = s.readStringAndCheckIfOdd();
		for (int i = 1; i < n; ++i) {
			val = sumDiffDP[i] = val + (s.readStringAndCheckIfOdd());
		}
		int ans = 0;
		int a = 0;
		int accessValue = 0;
		for (int i = 0; i < n; ++i) {
			accessValue = i != 0 ? sumDiffDP[i - 1] : 0;
			for (int j = i + 1; j < n; ) {
				a = sumDiffDP[j] - accessValue;
				if (a == 0) {
					++ans;
					j += 2;
				} else {
					j += (a < 0) ? -a : a;
				}
			}
		}
		System.out.print(ans);
	}
	
}

class InputReader {
	 
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public String readString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}
	public int readStringAndCheckIfOdd() {
		int c = read();
		int prev = 0;
		while (isSpaceChar(c))
			c = read();
		do {
			prev = c;
			c = read();
		} while (!isSpaceChar(c));
		return (prev & 1) == 1 ? -1 : 1;
	}

	public boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public String next() {
		return readString();
	}

	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}

class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}

	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

	public void print(Object...objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}

	public void printLine(Object...objects) {
		print(objects);
		writer.println();
	}

	public void close() {
		writer.close();
	}

	public void flush() {
		writer.flush();
	}

	}

class IOUtils {

	public static int[] readIntArray(InputReader in, int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = in.readInt();
		return array;
	}

	}
/*
 * You are given an array A of N positive integer values. A subarray of this
 * array is called Odd-Even subarray if the number of odd integers in this
 * subarray is equal to the number of even integers in this subarray.
 * 
 * Find the number of Odd-Even subarrays for the given array.
 * 
 * Input Format: The input consists of two lines.
 * 
 * First line denotes N - size of array. Second line contains N space separated
 * positive integers denoting the elements of array A.
 * 
 * Output Format: Print a single integer, denoting the number of Odd-Even
 * subarrays for the given array. SAMPLE INPUT 4 1 2 1 2 SAMPLE OUTPUT 4
 */
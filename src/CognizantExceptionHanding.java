/**
 * @author Ketan Mehta
 * @date 16-Dec-2017
 * @problem_link https://www.hackerearth.com/challenge/hiring/cognizant-java-developer-hiring-challenge
 */

public class CognizantExceptionHanding {
	public static void main(String[] args) {
		try {
			throw new MyException(1);
		}
		// Write catch(your code here
		catch (ArithmeticException ae) {
			System.out.println("Invalid division");
		} catch (NumberFormatException nfe) {
			System.out.println("Format mismatch");
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("Array index is invalid");
		} catch (IndexOutOfBoundsException ioobe) {
			System.out.println("Index is invalid");
		} catch (MyException me) {
			System.out.println(me);
		} catch (Exception e) {
			System.out.println("Exception encountered");
		} finally {
			System.out.println("Exception Handling Completed");
		}
	}
}

// Write exception class here
class MyException extends Exception {
	private static final long serialVersionUID = 1L;
	int arg = 0;

	public MyException() {
		super();
	}

	public MyException(int arg) {
		this.arg = arg;
	}

	public String toString() {
		return "MyException[" + arg + "]";
	}
}

/**
 * You are given a piece of Java code. You have to complete the code by writing down the handlers for exceptions thrown by the code. The exceptions the code may throw along with the handler message are listed below:

Division by zero: Print "Invalid division".
String parsed to a numeric variable : Print "Format mismatch".
Accessing an invalid index in string : Print "Index is invalid".
Accessing an invalid index in array : Print "Array index is invalid".

MyException : This is a user defined Exception which you need to create. It takes a parameter 

param. When an exception of this class is encountered, the handler should print "MyException[param]", here 

param is the parameter passed to the exception class.

Exceptions other than mentioned above : Any other exception except the above ones fall in this category. Print "Exception encountered".

Finally, after the exception is handled, print "Exception Handling Completed"./
 */
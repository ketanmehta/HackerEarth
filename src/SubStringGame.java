
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ketan Mehta
 * @date 09-Dec-2017
 * @problem_link UNSOLVED
 */
public class SubStringGame {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		List<String> sList = new ArrayList<String>();

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length() - 1; j++) {
				sList.add(s.substring(i, j + 1));
			}
		}

		int q = sc.nextInt();
		long[] qList = new long[q];
		for (int i = 0; i < q; i++) {
			qList[i] = sc.nextLong();

		}
		int len = sList.size();
		for (long k : qList) {
			if (k > len) {
				System.out.println(-1);
			} else {
				System.out.println(sList.get((int)k - 1));
			}
		}
		sc.close();
	}
}
/*
 * The Substring Game! Let's play the Substring Game.
 * 
 * This game has two characters: Sherlock and Watson. As usual, Watson wants to
 * test the skills of Mr. Sherlock.
 * 
 * Watson gives Sherlock a string (let's denote it by S). Watson calculates all
 * the substrings of S in his favourite order.
 * 
 * According to the Watson's favourite order, all the substrings starting from
 * first character of the string will occur first in the sorted order of their
 * length, followed by all the substrings starting from the second character of
 * the string in the sorted order of their length, and so on.
 * 
 * For example: Suppose the given string is "abc" that is S = abc. Then, all the
 * substrings of S as per Watson's favourite order are:
 * 
 * 1) a
 * 
 * 2) ab
 * 
 * 3) abc
 * 
 * 4) b
 * 
 * 5) bc
 * 
 * 6) c
 * 
 * The game is pretty simple.
 * 
 * Watson will ask Sherlock 'q' questions. In each question, Watson will give
 * Sherlock a number and Sherlock has to speak the substring on that number. If
 * there is no possible substring, then Sherlock has to speak -1.
 * 
 * Note: Sherlock has to follow Watson's favourite order.
 * 
 * Help Sherlock.
 * 
 * See Sample test-case for more understanding.
 * 
 * 
 * Input format:
 * 
 * First line consist of a string 'S', having only the small alphabets (a - z).
 * 
 * Second Line consist of an integer 'q', number of questions Watson ask.
 * 
 * Next line consists of 'q' space-separated numbers.
 * 
 * 
 * Output format:
 * 
 * For all the 'q' questions, output the required answer, in a new line.
 * 
 * 
 * Constraints:
 * 
 * 1 <= |S| <= 10^5
 * 
 * 1 <= q <= 10^3
 * 
 * 1 <= number <= 10^18
 * 
 * Sample Input abc 2 2 9 Sample Output ab -1 Explanation This is the example
 * mentioned in the question.
 * 
 * In 1st case, Watson gives Sherlock a number 2. We have substring "ab" on
 * number 2. So output "ab"(without quotes).
 * 
 * In 2nd case, Watson gives Sherlock a number 9. We don't have any substring on
 * number 9. So output "-1" (without quotes).
 * 
 * 
 * 
 */
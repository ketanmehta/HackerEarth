package skillenza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Ketan Mehta
 * @date 16-Dec-2017
 * @problem_link Not Fully Solved
 */
public class SpecialNumbers {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] tokens = br.readLine().split(" ");
			int start = Integer.parseInt(tokens[0]);
			int end = Integer.parseInt(tokens[1]);
			int count = 0;
			for (int x = start; x <= end; x++) {
				String bRep = Integer.toBinaryString(x);
				if (bRep.replaceAll("10", "").length() == 1 && bRep.endsWith("0")) {
					//System.out.println("from 1 " + x + " binary" + bRep);
					count++;
				} else if (bRep.replaceAll("11", "").length() == 0) {
					//System.out.println("from 2 " + x + " binary" + bRep);
					count++;
				} else{
					String[] toks = bRep.split("0");
					boolean started = false;
					int c = Integer.MIN_VALUE;
					boolean isSpecial = true;
					for(String s : toks) {
						if(s.length() == 0) {
							continue;
						}
						if(!started) {
							started = true;
							c = s.length();
						}
						else {
							if(s.length() <= c) {
								isSpecial = false;
								break;
							}
							else {
								c++;
							}
						}
					}
					if(isSpecial) {
						//System.out.println("from 3 " + x + " binary" + bRep);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}
/*
Special Numbers
A special number is defined as a number where, in binary notation,
a. has only set bits (OR)
b. all set bits are followed by unset bits (OR)
c. the sequence formed by count of the number of set bits separated by any number of unset bits is a contiguous subsequence of the sequence of natural numbers.
2, 3, 11271 and 15667135 are special numbers because their binary represenation is 10, 11, 10110000000111 and 111011110000111110111111 respectively.
2 is a special number because of condition (b).
3 is a special number because of condition (a).
11271 is a special number because its binary representation is 10110000000111 because of condition (c). The sequence of the count of number 
of set bits separated by a unset bits is 1, 2 and 3. This is clearly a continguous subsequence of the natural numbers.
Similarly, 15667135 is a special number. (The sequence is 3,4, 5 and 6.)
So, given two integers n and m where n <= m, find out the number of special numbers between n and m inclusive.
Input Format:
The first line of input contains an integer T where T is the number of test cases. Then T lines follow containing 
two space separated integers n and m where n <= m.
Output Format:
For each test case, output, in different lines, a single integer P where P is the number of special numbers between the range specified.
Constraints:
1 <= T <= 1000
1 <= n <= 10^6
1 <= m <= 10^6
n <= m
Explanation:
1) For first test case 2 10 : Special numbers are 2 3 4 6 7 8 (6 Special numbers)
2) For second test case 11 15 : Special numbers are 11 12 14 15 (4 Special Numbers)
3) FOr third test case 20 30 : Special numbers are 22 23 24 28 30 (5 Special Numbers)
4) Similarly, in the fourth test cases, there are 43 special numbers in the range.
Sample stdin 1

4
2 10
11 15
20 30
2 100
Sample stdout 1

6
4
5
43

*/
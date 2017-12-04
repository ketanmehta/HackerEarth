
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;


/**
 * @author Ketan Mehta
 * @date 
 * @problem_link https://www.hackerearth.com/challenge/hiring/practo-developer-hiring-challenge/
 */

class ReunioneOne {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine().split(" ")[1]);

		StringBuilder sb = new StringBuilder(br.readLine());
		boolean flag = true;
		int maxLength = 0;
		StringBuilder ans = new StringBuilder();
		int start = 0;
		int end = sb.length();
		int twos = 0;
		TreeSet<Integer> indx = new TreeSet<Integer>();
		for (int i = 0; i < q; i++) {
			String[] ip = br.readLine().split(" ");
			int t = Integer.parseInt(ip[0]);
			switch(t) {
			case 1 :
				if(!flag) {
					ans.append(maxLength);
					ans.append("\n");
					break;
				}
				if(twos > 1) {
					start = indx.first();
					end = indx.last();
					twos = 0;
					indx.clear();
				}
				String[] tokens = sb.substring(start,end).replace("00","0").split("0");
				TreeSet<String> set = new TreeSet<String>();
				set.addAll(Arrays.asList(tokens));
				if(!set.isEmpty()) {
					int len = set.last().length();
					if(len > maxLength) {
						maxLength = len;
					}
				}
				ans.append(maxLength);
				ans.append("\n");
				flag = false;
				break;
			case 2 :
				int pos = Integer.parseInt(ip[1]);
				if(sb.charAt(pos - 1) != '1') {
					twos++;
					sb.setCharAt(pos - 1, '1');
					start = pos - 1;
					end = pos;
					int counter = 0;
					while(start > -1 && sb.charAt(start) == '1') {
						start--;
						counter++;
					}
					if(start == -1) {
						start = 0;
					}
					while(end < sb.length() && sb.charAt(end) == '1') {
						end++;
						counter++;
					}
					if(end < sb.length()) {
						end++;
					}
					else {
						end = sb.length();
					}
					indx.add(start);
					indx.add(end);
					flag = true;
				}
				break;
			}
		}
		System.out.println(ans);
	}
}

/*

Reunion of 1's
You are given a string of size n consisting of 0s and/or 1s. You have to
perform total k queries and there are two types of queries possible:
1. "1" (without quotes): Print length of the longest sub-array which
consists of all '1'.
2. "2 X" (without quotes): where X is an integer between 1 to n. In this
query, you will change character at the Xth position to '1' (It is
possible that the character at i-th position was already '1').
Input Format
First line of input contains n and k, where n is the length of the
string, k is the number of queries.
Next line contains a string of 0's and/or 1's of length n.
Each of next k lines contains query of any one type(i.e 1 or 2).
Input Constraints
String contains only 0s and/or 1s.
Each query is of one of the mentioned types.
Output Format
For each query of type 1, print in a new line the maximum size of the
subarray with all 1's
Explanation
Initially there are no 1's in the string, hence the answer is 0.
In second query of type '1' state of string is 00100, hence answer is 1.
In Third query of type '1' state of string is 00101, hence answer is 1.
In Fourth query of type '1' state of string is 00111, hence answer is 3.
Note: Your code should be able to convert the sample input into the sample output. However, this
is not enough to pass the challenge, because the code will be run on multiple test cases.
Therefore, your code must solve this problem statement

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ketan Mehta
 * @date 09-Dec-2017
 * @problem_link https://www.hackerearth.com/challenge/hiring/thoughtworks-women-hiring-challenge-1/
 */
public class BobAndGCD {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		String data[] = null;
		for (int i = 0; i < t; i++) {
			long cost = 0;
			List<Long> numBox = new ArrayList<Long>();
			data = br.readLine().split(" ");
			long K = Long.parseLong(data[0]);
			int N = Integer.parseInt(data[1]);
			data = br.readLine().split(" ");
			
			for (int j = 0; j < N; j++) {
				numBox.add(Long.parseLong(data[j]));
			}
			
			int size = numBox.size();
			
			for (int k = 0; k < size; k++) {
				long num = numBox.get(k);
				
				// No need to traverse just add the missing amount in the number
				if (num <= K) {
					cost += (K - num);
					continue;
				}
				
				long mod = 0;
				
				long add = 0;
				while (true) {
					mod = (num + add) % K;
					if(mod == 0) {
						break;
					}
					else {
						add = add + (K-mod);
					}
				}
				
				mod = 0;
				long minus = num % K;


				cost += Math.min(add, minus);
			}
			System.out.println(cost);

		}
	}
}
/*
 * Bob And GCD Bob has an array A A of size N N. He doesn't like arrays in which
 * the G C D GCD of all elements is not K K. He can perform multiple operations
 * on an array. In each operation, he can either increase or decrease the value
 * of an element by 1 1. You have to tell the minimum operation Bob will take to
 * make G C D GCD of all elements in an array equal to K K ?
 * 
 * GCD here is Greatest Common Divisor.
 * 
 * Input Format
 * 
 * The first line contains T T, the number of test cases.
 * 
 * For Each Testcase : The first line contains 2 integers - K K and N N
 * respectively, separated by a space. The second line contains N N integers,
 * separated by a space, in order of their position in array.
 * 
 * Input Constraints
 * 
 * 1 ≤ T ≤ 10 1≤T≤10 1 ≤ N ≤ 10 6 1≤N≤106 1 ≤ A [ i ] ≤ 10 6 1≤A[i]≤106 1 ≤ K ≤
 * 10 6 1≤K≤106 Output Format
 * 
 * For each test case, print minimum number of operations Bob take in a new
 * line.
 * 
 * Sample Input 1 5 3 4 5 6 Sample Output 2
 * 
 * 
 */
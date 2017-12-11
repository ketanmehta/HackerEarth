import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ketan Mehta
 * @date 8 Dec 2017
 * @problem_link https://www.hackerearth.com/challenge/hiring/sapient-global-markets-java-hiring-challenge-1/
 */

class SpecialArray {
	public static boolean isPrime[] = new boolean[1000007];

	public static void main(String args[]) throws Exception {
		solve();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer.parseInt(br.readLine());
		String[] toks = br.readLine().split(" ");
		List<Integer> primeList = new ArrayList<Integer>();
		List<Integer> nonPrimeList = new ArrayList<Integer>();
		for (String s : toks) {
			int num = Integer.parseInt(s);
			if (isPrime[num]) {
				primeList.add(num);
			} else {
				nonPrimeList.add(num);
			}
		}
		Collections.sort(primeList);
		Collections.sort(nonPrimeList, Collections.reverseOrder());
		for (int p : primeList) {
			System.out.print(p + " ");

		}
		for (int np : nonPrimeList) {
			System.out.print(np + " ");
		}
	}

	public static void solve() {
		int n = isPrime.length;
		for (int i = 0; i < n; i++)
			isPrime[i] = true;
		isPrime[1] = false;
		for (int p = 2; p * p < n; p++) {
			if (isPrime[p] == true) {
				for (int i = p * 2; i < n; i += p)
					isPrime[i] = false;
			}
		}
	}
}
/*
 * Special Array Conversion You are given an array A A. Now you need to convert
 * this array into special array which has the following characteristics. 1. All
 * isPrime numbers come before all non isPrime numbers in the special array even
 * if they are greater 2. All isPrime numbers are sorted in increasing order 3.
 * All non isPrime numbers are sorted in decreasing order
 * 
 * For example let the array A A is 1 , 4 , 3 , 2 , 6 1,4,3,2,6 then the array
 * after special sorting will become 2 , 3 , 6 , 4 , 1 2,3,6,4,1. Note that 1 1
 * is not a isPrime number. Here 2 2 and 3 3 are isPrime so they are sorted in
 * increasing order and 6 , 4 , 1 6,4,1 are non isPrime so they are sorted in
 * decreasing order. Also all the isPrime numbers come before non isPrime
 * 
 * Input First line contains an integer N N as input denoting total elements in
 * the array A A. Next line contains N N space separated integers that denotes
 * the element of array A A.
 * 
 * Output In the output you need to print the array elements separated by space
 * after it is specially sorted.
 * 
 * Constraints 1 ≤ N ≤ 10 5 1≤N≤105 1 ≤ A [ i ] ≤ 10 6 1≤A[i]≤106 Sample Input 5
 * 1 4 3 2 6 Sample Output 2 3 6 4 1 Explanation
 */
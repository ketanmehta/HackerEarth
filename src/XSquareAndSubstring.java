
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * @author Ketan Mehta
 * @date
 */

class XSquareAndSubstring {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String str;
            char[] ip1 = br.readLine().toCharArray();
            char[] ip2 = br.readLine().toCharArray();
            int[] f1 = new int[256];
            int[] f2 = new int[256];

            for (char c : ip1) {
                f1[c]++;
            }
            for (char c : ip2) {
                f2[c]++;
            }
            boolean flag = false;
            for (int x = 0; x < 256; x++) {
                if (f1[x] != 0 && f2[x] != 0) {
                    flag = true;
                    break;
                }
            }
            System.out.println(flag ? "Yes" : "No");


        }
    }
}

/*
Xsquare loves to play with strings a lot. Today, he has two strings S1 and S2 both consisting of lower case alphabets. Xsquare listed all subsequences of string S1 on a paper and all subsequences of string S2 on a separate paper. Xsquare wants to know whether there exists a string which is listed on both the papers.

Xsquare thinks that this task is pretty boring and handed it to you. Please accomplish this task on his behalf.

Input
First line of input contains a single integer T denoting the number of test cases. Each test case consists of two lines. First line of each test case contains a string denoting string S1. Next line of each test case contains a string denoting string S2.

Output
For each test case, Print Yes if both papers contain a common string otherwise Print No.
*/
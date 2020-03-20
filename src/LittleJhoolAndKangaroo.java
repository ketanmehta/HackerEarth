
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * @author Ketan Mehta
 * @date
 */

class LittleJhoolAndKangaroo {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String[] toks = br.readLine().split(" ");
            long a = Long.parseLong(toks[0]);
            long b = Long.parseLong(toks[1]);
            long m = Long.parseLong(toks[2]);
            if (b % m != 0) {
                b = b - (b % m);
            }
            if (a % m != 0) {
                a = a + (m - (a % m));
            }


            long ax = a / m;
            long bx = b / m;

            long ans = bx - ax + 1;


            System.out.println(ans);


        }
    }
}

/*

Little Jhool is a world renowned kangaroo trainer. He's now living in Australia, and is training kangaroos for his research project on mobile soccer. (We don't know the connection, too.) Anyway, for the project to be completed he observes kangaroos for a lot of time - because he wants to figure out the hop count for various kangaroos he's training.

Now, he makes a kangaroo stand at the starting point, and lets him jump to the finishing point - given the hop count of that particular kangaroo, figure out the number of jumps he would take between the starting point to the ending point. Both the starting point and the ending points are inclusive.

Note: He will jump only to those positions which are multiples of M or hop count.

Input:
First line contains number of test cases T. Next T lines contains three integers A, B and M separated by single space. A denoted the starting point, B the finishing point - and M, the hop count - the distance covered by that kangaroo in one jump.

Output:
For each test case print the number of jumps the kangaroo had to make in the range [A, B] inclusive.

Constraints:
1<=T<=100000
1<=A<=B<=1012
1<=M<=1012

SAMPLE INPUT
3
1 10 2
5 10 3
7 9 5

SAMPLE OUTPUT
5
2
0
Explanation
Test Case #1:
There are 5 multiples of 2 that are {2,4,6,8,10} in range [1,10] .

Test Case#2:
There are 2 multiples of 3 that are {6,9} in range [5,10] .

Test Case#3: There are no any multiple of 5 is there in range [7,9].
*/
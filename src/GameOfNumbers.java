import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author Ketan Mehta
 * @date 08-Dec-2017
 * @problem_link https://www.hackerearth.com/challenge/hiring/sapient-global-markets-java-hiring-challenge-1/
 */
public class GameOfNumbers
{
	public static void main(String args[]) throws Exception
	{
		Scanner in=new Scanner(System.in);		
		List<Integer> ipList = new ArrayList<Integer>();
		List<Integer> output = new ArrayList<Integer>();
		
        int N = in.nextInt();
		for (int i = 0; i < N; i++) {
			ipList.add(in.nextInt());
		}
		
		for(int i = 0; i<N; i++)
		{
			int num = 0;
			for(int j = i+1; j < N; j++)
			{
				if(ipList.get(i) < ipList.get(j))
				{
					num = j;
					break;
				}
			}
			if(num != 0 )
			{
				boolean found = false;
				for(int k = num; k < N; k++)
				{
					if(ipList.get(num) > ipList.get(k))
					{
						found = true;
						output.add(ipList.get(k));
						break;
					}
				}
				if(!found)
				{
					output.add(-1);
				}
			}
			else
				output.add(-1);
			
		}
		for(int x : output)
		{
			System.out.print(x + " ");
		}
	}
}

/*

A Game of Numbers
You are given an array 
A
[
]
A[] of 
N
N integers. Now, two functions 
F
(
X
)
F(X) and 
G
(
X
)
G(X) are defined:

F
(
X
)
F(X) : This is the smallest number 
Z
Z such that 
X
<
Z
≤
N
X<Z≤N and 
A
[
X
]
<
A
[
Z
]
A[X]<A[Z]

G
(
X
)
G(X) : This is the smallest number 
Z
Z such that 
X
<
Z
≤
N
X<Z≤N and 
A
[
X
]
>
A
[
Z
]
A[X]>A[Z]

Now, you need to find for each index 
i
i of this array 
G
(
F
(
i
)
)
G(F(i)), where 
1
≤
i
≤
N
1≤i≤N . If such a number does not exist, for a particular index 
i
i, output 
−
1
−1 as its answer. If such a number does exist, output 
A
[
G
(
F
(
i
)
)
]
A[G(F(i))]

Input :

The first line contains a single integer 
N
N denoting the size of array 
A
[
]
A[]. Each of the next 
N
N lines contains a single integer, where the integer on the 
i
t
h
ith line denotes 
A
[
i
]
A[i].

Output :

Print 
N
N space separated integers on a single line, where the 
i
t
h
ith integer denotes 
A
[
G
(
F
(
i
)
)
]
A[G(F(i))] or 
−
1
−1, if 
G
(
F
(
i
)
)
G(F(i)) does not exist.

Constraints:

1
≤
N
≤
30000
1≤N≤30000

0
≤
A
[
i
]
≤
10
18
0≤A[i]≤1018
Sample Input
8
3
7
1
7
8
4
5
2
Sample Output
1 4 4 4 -1 2 -1 -1
Explanation
Next Greater     Next Smaller
3 --> 7                 7 -->1
7 --> 8                 8 -->4
1 --> 7                 7 --> 4
7 --> 8                 8 --> 4
8 --> -1                -1 --> -1
4 --> 5                 5 --> 2
5 --> -1                -1 --> -1
2 --> -1                -1 --> -1

Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.

*/
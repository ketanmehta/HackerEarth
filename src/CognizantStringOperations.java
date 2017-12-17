
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * @author Ketan Mehta
 * @date 16-Dec-2017
 * @problem_link https://www.hackerearth.com/challenge/hiring/cognizant-java-developer-hiring-challenge
 */
public class CognizantStringOperations {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = br.readLine();
		char[] inputArray = inputString.toCharArray();
		int Q = Integer.parseInt(br.readLine());
		
		for(int i=0; i<Q; i++) {
			String[] tokens = br.readLine().split(" ");
			int index = Integer.parseInt(tokens[0]);
			char c = tokens[1].trim().toCharArray()[0];
			inputArray[index - 1] = c;
		}
		inputString = new String(inputArray);
		System.out.println(inputString);

		int noOfQueries = Integer.parseInt(br.readLine());
		for(int i=0; i<noOfQueries; i++) {
			String[] tokens = br.readLine().split(" ");
			int start = Integer.parseInt(tokens[0]) - 1;
			int end = Integer.parseInt(tokens[1]) - 1;
			while(start < end) {
				char temp = inputArray[start];
				inputArray[start] = inputArray[end];
				inputArray[end] = temp;
				start++; end--;
			}
		}
		
		System.out.println(new String(inputArray));
		
		int answer = 0;
		int index = 0;
		for(char c : inputString.toCharArray()) {
			if(c == inputArray[index]) {
				answer++;
			}
			index++;
		}
		System.out.println(answer);
	}
}
/*
 * You are given a string 
S
S.

Q
Q number of operations are performed on string 
S
S.
In each of these 
Q
Q operations, you are given an index 
i
n
d
ind and a character 
c
h
ch. For each operation, you have to update character at index 
i
n
d
ind in string 
S
S to 
c
h
ch, that is, after this operation 
S
[
i
n
d
]
=
c
h
S[ind]=ch.
It is guaranteed that any index is updated atmost once.
We call the final string after performing 
Q
Q number of operations as 
s
t
r
str.

After this, 
M
M number of operations are performed on string 
s
t
r
str.
In each of these 
M
M operations, you are given two indices 
a
a and 
b
b. For each operation, you have to reverse the substring that lies between the indices 
a
a and 
b
b (inclusive). 
We call the final string after performing 
M
M operations as 
f
i
n
fin.

Example: If string is "xyz" and
one of the 
Q
Q operations is 
1
a
1a, then string "xyz" now becomes "ayz" as 
S
[
1
]
=
a
S[1]=a after the operation.
one of the 
M
M operations is 
1
3
13, then "ayz" now becomes "zya" as the substring lying between indices 
1
1 and 
3
3 is reversed.

You have to print string 
s
t
r
str, string 
f
i
n
fin and the number of indices which have same characters at them in both strings 
s
t
r
str and 
f
i
n
fin.
 */
 

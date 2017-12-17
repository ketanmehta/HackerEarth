
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
/**
 * @author Ketan Mehta
 * @date 16-Dec-2017
 * @problem_link https://www.hackerearth.com/challenge/hiring/cognizant-java-developer-hiring-challenge
 */
public class CognizantSchoolPrayer {

	public static void main(String args[]) throws Exception {
		BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(reader.readLine());
		for (int i = 0; i < testCases; i++) {
			int n = Integer.parseInt(reader.readLine());
			TreeSet<Integer> studentQueue = new TreeSet<Integer>();
			long sum = 0;
			String[] toks = reader.readLine().split(" ");
			for(int x=0; x<n; x++) {
				int currentStud = Integer.parseInt(toks[x]);

				Integer rollNo = studentQueue.floor(currentStud);
				if(rollNo == null) {
					--sum;
				}
				else {
					sum += rollNo;
				}
				studentQueue.add(currentStud);
			}
			System.out.println(sum);
		}
	}
}
/**
 * 
 * You are given the task to manage students coming to morning prayer in the school. Students having roll numbers 1 to N are coming in an arbitrary manner and you need to make them stand in a queue such that queue is always in ascending order of roll number.

In order to achieve this task, for every incoming student you need to find a student in the queue he will be standing behind (or in front of the queue if no such student is present in the queue ).

For example, if currently, the queue is 1 2 4 and student with roll number 3 arrives, you will have to locate 2 and make 3 stand behind 2.
For each incoming student, find the roll number of student he will be standing behind ( -1 in case no student with roll less than current exists).

Input Format:
The first line of input will contain 
T
T, number of test cases.
The first line of each test case will contain 
N
N, the number of students.
The second line of each test case will have 
N
N distinct space separated numbers denoting the order in which each student is coming.

Output Format:
Output a single number which is the sum of 
N
N numbers where 
i
t
h
ith number denotes answer for 
i
t
h
ith incoming student.
Answer for each test case should come in a new line./
 */
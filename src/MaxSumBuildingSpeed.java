import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ketan Mehta
 * @date 
 * @problem_link 
 */

class MaxSumBuildingSpeed {

	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.next());
		
		List<Integer> numBox = new ArrayList<Integer>(n * 2);
		for(int i=0; i<n*2; i++) {
			numBox.add(Integer.parseInt(in.next()));
		}
		Collections.sort(numBox);
		long sum = 0;
		for(int i=numBox.size() - 1; i > -1; i=i-2) {
			sum = sum + numBox.get(i-1);
		}
		System.out.println(sum);
		in.close();
	}
}

/*
Maximum Sum of Building Speed
You are the king of Pensville where you have workers.
All workers will be grouped in association of size ,so a total of
associations have to be formed.
The building speed of the worker is .
To make an association, you pick up workers. Let the minimum building
speed between both workers be , then the association has the resultant
building speed .
You have to print the maximum value possible of the sum of building
speeds of associations if you make the associations optimally.
Constraints
Input
First line contains an integer , representing the number of associations
to be made.
Next line contains space separated integers, denoting the building
speeds of workers.
Output
Print the maximum value possible of the sum of building speeds of all the
associations.
C (gcc 5.4.0) Save  
Explanation
If you make an association using the rst
and third worker, and another using the
second and fourth worker, each association will have and resultant building
speed, which has a total of .
Note: Your code should be able to convert the sample input into the sample output. However, this
is not enough to pass the challenge, because the code will be run on multiple test cases.
Therefore, your code must solve this problem statement.


*/

import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Ketan Mehta
 * @date 08-Dec-2017
 * @problem_link https://www.hackerearth.com/challenge/hiring/ubona-developer-hiring-challenge/problems/7720eef1467d489d96244d91268b97dd/#
 */
class Accomodation {
	public static TreeSet<Long> floorCapacity = new TreeSet<Long>();
	public static long mod = 1000000000 + 7l;
    class AmountDenom
    {
        long amount;
        long denom;
         
        public AmountDenom(long amount, long denom)
        {
            this.amount = amount;
            this.denom = denom;
        }
         
        @Override
        public int hashCode()
        {
            return Objects.hash(this.amount, this.denom);
        }
         
        @Override
        public boolean equals(Object obj){
            if (obj instanceof AmountDenom) {
                AmountDenom keyObj = (AmountDenom) obj;
                return (keyObj.amount == this.amount && keyObj.denom == this.denom);
            } else {
                return false;
            }
        }
    }

 // denominations we can use : 20,10,5 and 1
    public long countNumberOfWays(long amount, long denom)
    {
        // if only denominations available is 1 then number of ways to make change = 1
        if (denom == 1)
        {
            return 1;
        }
         
        Long nextDenom = (Long) floorCapacity.lower(denom);
        if(nextDenom == null) {
        	return 0;
        }
         
        // try all possible number of coins of current denomination
        long numberOfCoins = 0, ways = 0;
        while ((numberOfCoins*denom) <= amount)
        {
        	long sum = countNumberOfWays(amount - (numberOfCoins*denom), nextDenom);
            ways = (ways + sum) % mod;
            numberOfCoins++;
        }
         
        return ways;
    }
    
     
    public static void main(String[] args) 
    {
        Accomodation solution = new Accomodation();
        Scanner sc =  new Scanner(System.in);
        long totalFloors = sc.nextLong();
        long noOfPeople = sc.nextLong();
        for(long i=0; i<totalFloors; i++) {
        	floorCapacity.add(sc.nextLong());
        }
        System.out.println(solution.countNumberOfWays(noOfPeople, floorCapacity.last()));
        sc.close();
    }
}

/*

Accommodation
There is a hotel with 
M
M floors. 
i
t
h
ith floor of the hotel has infinite identical rooms, each room can accommodate 
C
[
i
]
C[i] people (Two rooms of same floor are indifferentiable and have same capacity while two rooms of different floors have different capacity).
There is one rule:
Any room on 
i
t
h
ith floor will accommodate exactly 
C
[
i
]
C[i] people (not less or more).

Now 
N
N identical people come for accommodation. You can assign any of them to any room of any floor following the mentioned rule.

Way of assigning:
If we have 
5
5 people and 3 floors. Let's say floor 1 has room capacity 1 and floor 2 has room capacity 2, then:
(1,2,2) is a way of assigning people. This means we assign one person out of those 5 people to any room of floor 1. The remaining 4 people are assigned to two rooms of floor 2, each room accommodating 2 people.
We will consider (1,2,2), (2,1,2), (2,2,1) as the same ways as we can't differentiate between them.

You have to tell number of different ways of accommodating 
N
N people.
Two ways are considered different if one way is not a permutation of other way.

Input Format:
First line consists of two integers 
M
M and 
N
N, denoting number of floors and number of people respectively.
Second line consists of 
M
M space separated integers denoting capacity of floors. 
i
t
h
ith integer denotes capacity of 
i
t
h
ith floor.

Output Format:
Print the number of different ways of accommodating people.
Since the number of ways can be large, print the answer modulo 
10
9
+
7
109+7.

Input Constraints:
1
≤
N
∗
M
≤
10
6
1≤N∗M≤106
1
≤
C
[
i
]
≤
10
6
1≤C[i]≤106
All 
C
[
i
]
C[i] are different.

Sample Input
3 5
1 2 3
Sample Output
5
Explanation
We can assign as follows:
(1,1,1,1,1) : assign each of the 5 people to rooms of first floor.
(1,1,1,2) : assign 3 people to rooms of first floor of, 2 people to room on second floor.
(1,1,3) : assign 2 people to rooms of first floor, 3 people to room of third floor.
(1,2,2) : assign 4 people to rooms of second floor with each room having 2 people, 1 person to room of first floor.
(2,3) : assign 2 people to room of second floor, 3 people to room of third floor.

*/
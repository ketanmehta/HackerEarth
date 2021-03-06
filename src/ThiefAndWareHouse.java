
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Ketan Mehta
 * @date 
 * https://www.hackerearth.com/challenge/hiring/lenskart-java-developer-hiring-challenge/problems/3516ca14b72a431aaa81465b183be0c3/
 */
public class ThiefAndWareHouse {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int w = Integer.parseInt(br.readLine());
			String[] toks = br.readLine().split(" ");
			int max = 0;
			int avg = 0;
			for(int j=0; j<w; j++){
				int n = Integer.parseInt(toks[j]);
				if(n >= avg){
					max = max + n;
				}
				else{
					
				}
				
			}
		}
	}
}
/*
String Game
P
l
a
y
e
r
1
Player1 and 
P
l
a
y
e
r
2
Player2 decided to play a game. The game comprises of a String 
S
S which consist of lowercase English alphabets only and both players take alternative terms.

In each turn, a Player choose a character present in the string and remove all occurrences of the character. For each player to play his turn, there should be at least one character in the string. The Player who is not able to play his turn loses.

Your task is to find the winner of the game, if both the players play optimally and 
P
l
a
y
e
r
1
Player1 plays the first turn.

Input Format : 
The input starts with an integer 
T
T, the number of test cases. 
Each test case contains an String 
S
S on a new line.

All characters are lowercase English alphabets.

Sample Input
1
aba
Sample Output
Player2

 */
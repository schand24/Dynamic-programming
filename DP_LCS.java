import java.lang.*;
import java.util.*;
/*Time comelexity of algorithm is O(M*N) where M and N are lengths of Strings;

method: 
1)create a 2D array "L" of size MXN and initialize with zero;
2)run two for loops each for one string input 
3)compute value of l[i][j] by checking following:
	if(string1[i-1] == string2[j-1])
		L[i][j] = 1 + L[i-1][j-1]
	else
		L[i][j] = Max(L[i-1][j], L[i][j-1])
4)length of common substring will be at the end of L array(i.e L[m][n])
5)to print longest common sub sequence:
	a)take an array lcs of length we got from step 4
	b)start from L[M][N] check:
		if(string1[i] == string2[j])
			lcs[index] = string[i]; 
			decrement index, i, j;
		else
			decrement i if L[i-1][j] > L[i][j-1]
			decrement j if L[i-1][j] < L[i][j-1]

*/
class DP_LCS{

	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		System.out.println(findLCS(s1,s2));
	}
	static int findLCS(String s1,String s2){
		int[][] l = new int[s1.length()+1][s2.length()+1];
		char[] a = s1.toCharArray(); char[] b = s2.toCharArray();
		
		// find length of longest common sub sequence
		for (int i = 1; i<=a.length ;i++ ) {
			for (int j = 1; j<= b.length ;j++ ) {
				if (a[i-1] == b[j-1])
					l[i][j] = 1 + l[i-1][j-1];
				else
					l[i][j] = Math.max(l[i][j-1],l[i-1][j]);
			}
			
		}

		int index = l[s1.length()][s2.length()];
		//initialize lcs array to length of longest sub sequcence
		char[] lcs = new char[index+1];

		int p = s1.length(), q = s2.length();
		//find lcs
		while (p > 0 && q > 0) {
			if(a[p-1] == b[q-1]){
				lcs[index] = a[p-1];
				index--;p--;q--;
			}
				
			else if (l[p-1][q] > l[p][q-1])
				p--;
			else
				q--;
		}
		for (int i = 0;i < lcs.length ;i++ ) {
			System.out.print(lcs[i]);
		}
		// System.out.println();
		// for (int i = 0;i<=a.length ;i++ ) {
		// 	for (int j = 0; j<=b.length ;j++ ) {
		// 		System.out.print(l[i][j]+" ");
		// 	}
		// 	System.out.println();
		// }
		return l[s1.length()][s2.length()];
	}
}
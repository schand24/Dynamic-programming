/*
Also called:: "Edit Distance Algorithm"

Time Complexity: O(m x n)
Auxiliary Space: O(m x n)

*/

class DP_MinOperationsStr1toStr2{

	public static void main(String[] args) {
		String s1 = "saturday";
		String s2 = "sunday";

		System.out.println(findMinOperations(s1,s2));

	}
	static int findMinOperations(String s1, String s2){
		int m = s1.length(); int n = s2.length();
		int[][] l = new int[m+1][n+1];

		for (int i = 0;i <= m ; i++ ) {
			for (int j = 0; j <= n; j++ ) {
				if (i == 0)
					l[i][j] = j;
				else if (j == 0)
					l[i][j] = i;
				else if (s1.charAt(i-1) == s2.charAt(j-1))
					l[i][j] = l[i-1][j-1];
				else
					l[i][j] = 1 + min(l[i][j-1],l[i-1][j],l[i-1][j-1]);

			}
			
		}
		return l[m][n];

	}
	static int min(int a, int b, int c){
		return Math.min(Math.min(a,b),c);
	}
	
}
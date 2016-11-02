// Program to find largest Pallindromic subsequence in a string
/*
	Approach: is find longest common substring in input and rev_input strings given
	Time complexity : O(N*N)
	Space complexity : O(N*N)
*/


class DP_LongestPalindromicSubSequence{

	public static void main(String[] args) {
		String input = "dabcdefacbad";
		//String input = "aa";

		lengthofLonestPlaindrome(input); 
	}
	static void lengthofLonestPlaindrome(String input){
		
		StringBuilder s2 = new StringBuilder(input);
		String s3 = new String(s2.reverse());
		int len = findLength(input,0,input.length()-1);
		System.out.println(findLCS(input,s3));

	}
	static int findLength(String input, int i , int j){

		if(i == j){
			//System.out.print(left+right);
			return 1;
		}

		if(input.charAt(i) == input.charAt(j) && i+1 == j)
			return 2;
			
		if(input.charAt(i) == input.charAt(j)){
			return 2 + findLength(input, i+1, j-1);
		}
			
		else
			return Math.max(findLength(input,i,j-1),findLength(input,i+1,j));
	}
	static int findLCS(String s1, String s2){
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
		
		return l[s1.length()][s2.length()];
	}
	
}
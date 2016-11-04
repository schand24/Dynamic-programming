// find longest pallindromic substring in a given string.


class DP_LongestPalindromicSubString{

	public static void main(String[] args) {
		String input = "forgeeksskeegfor";

		System.out.println(findPalindromicSubstring(input));
	}

	static String findPalindromicSubstring(String s){
		int start = 0, maxLength = 1, low = 0 , high = 0;

		for (int i = 1; i< s.length() ;i++ ) {
			//Even palindromes
			low = i-1;
			high = i;
			while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
				if(high - low + 1 > maxLength){
					maxLength = high - low + 1;
					start = low;
				}
				low--;
				high++;
			}
			//odd palindromes
			low = i-1;
			high = i+1;
			while (low >=0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
				if (high - low + 1 > maxLength){
					maxLength = high - low + 1;
					start = low;
				}
				low--;
				high++;
			}

		}
		String output = "";
		for (int i = start ; i< start+maxLength ;i++ ) {
			output += s.charAt(i);
		}
		return output;

	}
	
}
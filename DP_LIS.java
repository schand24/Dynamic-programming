class DP_LIS{

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int len = arr.length;
		System.out.println("Length of longest increasing sub sequce is :: "+findLis(arr, len));
	}
	static int findLis(int[] arr, int n){
		int[] l = new int[n];int max = 0;

		for (int i = 0; i< n ; i++)
			l[i] = 1;

		for(int i = 0; i < n ; i++)
			for(int j = 0; j < i ; j++)
				if(arr[j] < arr[i] && l[j] + 1 > l[i])
					l[i] = l[j] + 1;

		for (int i = 0; i < n ; i++ )
			if(l[i] > max)
				max = l[i];
		return max;	
	}
}
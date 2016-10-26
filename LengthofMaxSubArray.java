//find length of maximum subarray


class LengthofMaxSubArray{

	public static void main(String[] args) {
		int[] arr = {1,3,2,4,5,6};
		//System.out.println(lenMaxSubArray(arr));
		System.out.println(lenMaxSubSequence(arr));
	}
	public static int lenMaxSubArray(int[] a){
		int i = 1, len = 1, max =0;
		while(i < a.length){
			if(a[i-1] < a[i]){
				len++;
			}
			else{
				if(max < len){
					max = len;
				}
				len = 1;
			}
			i++;
		}
		if(max < len){
			max = len;
		}
		return max;
	}
	public static int lenMaxSubSequence(int[] a){
		int[] l = new int[a.length];
		for(int i = 0; i< a.length; i++){
			l[i] = 1;
		}

		for(int i = 1; i< a.length; i++){
			for(int j = 0; j<i; j++){
				if(a[i] > a[j] && l[i] < l[j]+1){
					l[i] = l[j] + 1;
				}
			}
		}
		int max = l[0];
		for (int j = 1; j< l.length ;j++ ) {
			if(max < l[j]){
				max = l[j];
			}
		}
		return max;
	}
	
}
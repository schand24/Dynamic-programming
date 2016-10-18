class DP_MinCostPath{

	public static void main(String[] args) {
		int[][] cost = {{1,2,3},{4,8,2},{1,5,3}};
		int m =2, n = 2;
		System.out.println(findMinCostPath(cost,m,n));
	}
	static int findMinCostPath(int[][] cost,int m, int n){
		int rows = cost.length, cols = cost[0].length;
		int[][] l = new int[rows][cols];

		l[0][0] = cost[0][0];
		for (int i = 1; i<=m ;i++ ) 
			l[i][0] = cost[i][0] + l[i-1][0];
		for (int j = 1;j <= n ;j++ ) 
			l[0][j] = cost[0][j] + l[0][j-1];

		for (int i = 1;i <= m ;i++ ) {
			for (int j = 1; j<=n ;j++ ) {
				l[i][j] = min(l[i-1][j-1],l[i][j-1],l[i-1][j]) + cost[i][j];
			}
		}
		
		//int minCost = l[m][n];
		//int p = m; int q = n;



		return l[m][n];

	}
	static int min(int a, int b, int c){
		return Math.min(a,Math.min(b,c));
	}
}
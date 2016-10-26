class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class CheckifSquare{


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in());
		int testCases = (int)sc.readLine();
		for (int i = 0; i< testCases ;i++ ) {
			String input = sc.readLine();
			int x1,x2,x3,x4,y1,y2,y3,y4;
			String points = input.split(" ");
			x1 = points[0];y1=points[1];x2 = points[2];y2=points[3];
			x3 = points[4];y3=points[5];x4 = points[6];y4=points[7];
			Point p1 = new Point(x1,y1);Point p2 = new Point(x2,y2);
			Point p3 = new Point(x3,y3);Point p4 = new Point(x4,y4);

			int d2 = findDistance(p1,p2);
			int d3 = findDistance(p1,p3);
			int d4 = findDistance(p1,p4);

			if(d2 == d4 && (d3 == 2 * d2)){
				int d23 = findDistance(p2,p3);
				int d34 = findDistance(p3,p4);
				if( d23 == d34 && d23 = d2)
					return 1;
			}
			else if(d2 == d3 && (d4 == 2 * d2)){
				int d24 = findDistance(p2,p4);
				int d34 = findDistance(p3,p4);
				if( d24 == d34 && d24 = d2)
					return 1;
			}
			else if(d3 == d4 && (d2 == 2 * d3)){
				int d24 = findDistance(p2,p4);
				int d23 = findDistance(p2,p3);
				if( d24 == d23 && d24 = d3)
					return 1;
			}
			else {
				return 0;
			}
		}
	}
	
}
package amazon;

import java.util.Scanner;

public class Cargo {
	private static int[][] ALL;
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String rowAndColumn = sc.nextLine();
		String[] rAndC = rowAndColumn.split(" ");
		int row = Integer.parseInt(rAndC[0]);
		int column = Integer.parseInt(rAndC[1]);
		ALL= new int[row][column];
		for (int i = 0; i < row; i++) {
			String eachRow=sc.nextLine();
			String[] elements=eachRow.split(" ");
			for(int j=0;j<column;j++){
				ALL[i][j]=Integer.parseInt(elements[j]);
			}
		}	
		
		int targetRow=0;
		int targetColumn=0;
		int totalCost=Integer.MAX_VALUE;
		for(int i=0;i<ALL.length;i++){
			for(int j=0;j<ALL[0].length;j++){
				int tempCost=totalDistance(i, j);
				if(tempCost<=totalCost){
					targetRow=i;
					targetColumn=j;
					totalCost=tempCost;
				}
			}
		}
		System.out.println(targetRow+" "+targetColumn);
		
	}
	
	private static int totalDistance(int row,int column){
		int sum=0;
		for(int i=0;i<ALL.length;i++){
			for(int j=0;j<ALL[0].length;j++){
				int unit=ALL[i][j];
				sum+=unit*(Math.abs(i-row)+Math.abs(j-column));
			}
		}
		return sum;
	}

}

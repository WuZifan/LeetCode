package amazon;

public class SumAll {

	private static int Sum(int[] numbers){
		int total=numbers[0];
		if(total==numbers.length-1){
			int sum=0;
			for(int i=1;i<numbers.length;i++){
				sum+=numbers[i];
			}
			return sum;
		}else{
			return total*numbers[1];
		}
	}
	
	public static void main(String[] args) {
		int[] numbers={5,1,2,3,4,5};
		System.out.println(Sum(numbers));
	}

}

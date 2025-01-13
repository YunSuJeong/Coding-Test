public class Main {

	public static void main(String[] args) {
		int arr[] = new int[10036];
		
		// d(n) 구하기
		arr[0] = 1;
		for(int i=1; i<=10000; i++) {
			// 각 자리 수의 합
			int num = i, sum = 0;
			while(true) {
				sum += num % 10;

				if( num / 10 == 0 ) break;
				
				num /= 10;
			}
			arr[i + sum] = 1;
		}
		
		for(int i=0; i<10001; i++) {
			if( arr[i] < 1 ) System.out.println(i);
		}
	}

}

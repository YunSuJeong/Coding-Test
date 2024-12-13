import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];
		int sum = 0;
		for(int i=0; i<5; i++) {
			int n = sc.nextInt();
			arr[i] = n;
			sum += n;
		}
		
		// 1) Selection Sort
		for(int i=4; i>=1; i--) {
			int maxIdx = 0;
			for(int j=0; j<=i; j++) {
				if( arr[j] > arr[maxIdx] ) {
					maxIdx = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[maxIdx];
			arr[maxIdx] = tmp;
		}
		
		System.out.printf("%d %d", sum/5, arr[2]);
	}

}

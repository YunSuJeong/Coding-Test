import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long sum = 0;
		// 2) 약수 포함 횟수로 계산하기
		for(int i=1; i<=N; i++) {
			sum += i * (N/i);
		}
		System.out.println(sum);
	}
	
}

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 약수의 개수가 홀수인 수 = 제곱수!!!
		int cnt = 0;
		for(int i=1; i*i<=N; i++) {
			cnt++;
		}
		System.out.println(cnt);
	}

}

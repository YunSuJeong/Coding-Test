import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int i = 0, x = 0;
		int now = 0, next = 0;
		int cnt = 1;			// 시작점 포함한 개수
		if( N > 1 ) {
			while( true ) {
				// 현재/다음 기준값 구하기
				x += i;
				now = 1 + 6 * x;
				next = 1 + 6 * (x + i + 1);
				i++;
				
				if( N > now && N <= next ) {
					cnt = i + 1;			// 끝점 포함
					break;
				}
 			}
		}
		System.out.println(cnt);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int antX, antY, min;
	public static int[] fib = new int[46];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<=45; i++) {
			if( i <= 2 ) fib[i] = 1;
			else fib[i] = fib[i-1] + fib[i-2];
		}
		
		StringTokenizer rect = new StringTokenizer(br.readLine());
		StringTokenizer ant = new StringTokenizer(br.readLine());
		
		int rectX = Integer.parseInt(rect.nextToken());
		int rectY = Integer.parseInt(rect.nextToken());
		antX = Integer.parseInt(ant.nextToken());
		antY = Integer.parseInt(ant.nextToken());
		
		int N = 1;		// 현재 피보나치 사각형의 순서
		int a = rectX < rectY ? rectX : rectY;
		int b = rectX < rectY ? rectY : rectX;
		for(int i=1; i<=45; i++) {
			if( a == fib[i] && b == fib[i+1] ) {
				N = i;
				break;
			}
		}

		// 1번째 피보나치 사각형인 경우는 무조건 
		if( rectX == 1 && rectY == 1 ) System.out.println(1);
		else {
			min = N;
			antRect(0, 0, rectX, rectY, N);
			System.out.println(min);
		} 
	}
	
	public static void antRect(int x, int y, int a, int b, int n) {
		// 파리가 들어있는 가장 작은 정사각형이 현재 피보나치 사각형에 포함되어있다면 최소 사각형 갱신
		// 파리가 들어있는 가장 작은 정사각형 = 한 변 길이 1인 정사각형
		if( x <= antX && antX + 1 <= x + a && y <= antY && antY + 1 <= y + b ) {
			min = n;
		}
		
		if( n > 1 ) {
			if( a < b ) {
				if( antY >= y+b-fib[n-1] ) antRect(x, y+b-fib[n-1], a, fib[n-1], n-1);
				else antRect(x, y, a, fib[n-1], n-1);
			} else {
				if( antX >= x+a-fib[n-1] ) antRect(x+a-fib[n-1], y, fib[n-1], b, n-1);
				else antRect(x, y, fib[n-1], b, n-1);
			}
		}
		
	}

}

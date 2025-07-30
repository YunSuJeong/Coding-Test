import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(selectMaxGcd(0, arr.length));
	}
	
	public static int selectMaxGcd(int s, int e) {
		if( s + 1 == e ) return arr[s];
		
		int left = arrGcd(s, s+(e-s)/2) + selectMaxGcd(s+(e-s)/2, e);		// 왼쪽 선택하는 경우
		int right = selectMaxGcd(s, s+(e-s)/2) + arrGcd(s+(e-s)/2, e);		// 오른쪽 선택하는 경우
		
		return Math.max(left, right);
	}

	// 선택된 배열의 최대공약수 구하기
	public static int arrGcd(int s, int e) {
		int arrGcd = arr[s];
		for(int i=s; i<e; i++) {
			arrGcd = gcd(arrGcd, arr[i]);
		}
		return arrGcd;
	}
	
	// 최대공약수 구하기 (유클리드 호제법)
	public static int gcd(int a, int b) {
		if( a % b == 0 ) return b;
		else return gcd(b, a%b);
	}
}

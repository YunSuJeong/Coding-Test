import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		hanoi(N, 1, 3, 2);
		
		System.out.println((int)Math.pow(2, N)-1);		// 옮긴 횟수
		System.out.println(sb.toString());
	}

	// hanoi(총 n개 원판, 시작위치, 목적지, (n-1)개 원판의 경유지)
	public static void hanoi(int n, int start, int end, int via) {
		// 이동시켜야 할 원판이 1개면 바로 이동
		if( n == 1 ) {
			sb.append(start+" "+end+"\n");
			return;
		}
		
		hanoi(n-1, start, via, end);
		sb.append(start+" "+end+"\n");
		hanoi(n-1, via, end, start);
	}
}

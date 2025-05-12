import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		StringTokenizer Ai = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(Ai.nextToken());
		}
		
		// 최대끼니 = 제일 짧은 길이로 나눠 먹어야함
		// 남은 조각 길이의 최소 합 = 최대끼니와 같은 개수로 먹을 수 있으면서, 각 끼니에서 나머지를 줄여야함
		int max = 0, minLen = 0;
		for(int i=0; i<N; i++) {
			int cnt = arr[i] / X;			// 이 샌드위치에서 먹을 수 있는 최대 끼니 수	
			int remain = arr[i] % X;		// 가장 짧게 먹었을 때, 남는 조각의 길이

			max += cnt;
			
			if( remain > (Y-X) * cnt ) {
				minLen += remain - (Y-X) * cnt;
			}
		}
		System.out.println(max);
		System.out.println(minLen);
	}

}

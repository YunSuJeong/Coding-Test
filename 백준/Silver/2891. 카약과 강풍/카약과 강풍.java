import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer demage = new StringTokenizer(br.readLine());
		StringTokenizer remain = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		// 각 팀의 카약개수 세팅
		int[] arr = new int[N];
		int cnt = 0;						// 출발하는 팀 수
		for(int i=0; i<N; i++) {
			arr[i] = 1;
		}
		
		for(int i=0; i<S; i++) {
			arr[Integer.parseInt(demage.nextToken())-1] -= 1;
		}
		
		for(int i=0; i<R; i++) {
			arr[Integer.parseInt(remain.nextToken())-1] += 1;
		}
		
		// 빌려주기
		for(int i=0; i<N; i++) {
			if( arr[i] == 0 ) {
				if( i-1 >= 0 && arr[i-1] > 1 ) {
					// 바로 전 팀에게 빌리기
					arr[i-1] -= 1;
					arr[i] += 1;
					cnt++;
				} else if( i+1 < N && arr[i+1] > 1 ) {
					// 바로 뒤 팀에게 빌리기
					arr[i+1] -= 1;
					arr[i] += 1;
					cnt++;
				}
			} else {
				cnt++;
			}
		}
		
		System.out.println(N-cnt);
	}

}

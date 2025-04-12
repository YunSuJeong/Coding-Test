import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		long[] cost = new long[7];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<6; i++) {
			cost[i] = Long.parseLong(st.nextToken());
		}
		cost[6] = Long.parseLong(br.readLine());
		
		// 쓰레기 분리배출 비용 계산
		long sum = 0;
		for(int i=0; i<N; i++) {
			String trash = arr[i];
			long len = trash.length();
			// 해당 trash의 성분 체크
			long[] type = new long[7];				// {P, C, V, S, G, F, O}
			for(int j=0; j<trash.length(); j++) {
				switch ( trash.charAt(j) ) {
				case 'P':
					type[0]++; break;
				case 'C':
					type[1]++; break;
				case 'V':
					type[2]++; break;
				case 'S':
					type[3]++; break;
				case 'G':
					type[4]++; break;
				case 'F':
					type[5]++; break;
				default:
					type[6]++; break;
				}
			}
			
			if( type[6] > 0 ) {
				// 일반 쓰레기 성분이 있을 때
				sum += len * cost[6];
			} else {
				boolean flag = false;
				int idx = 0;
				for(int j=0; j<6; j++) {
					if( type[j] == trash.length() ) {
						flag = true;
						idx = j;
						break;
					}
				}
				
				if( flag ) {
					// 재활용쓰레기로 배출
					sum += Math.min(len * cost[idx], len * cost[6]) ;
				} else {
					// 성분이 2가지 이상이므로 일반쓰레기로 배출
					sum += len * cost[6];
				}
			}
		}
		
		System.out.println(sum);
	}

}

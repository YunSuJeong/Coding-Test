import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			StringTokenizer stu = new StringTokenizer(br.readLine());
			
			int sex = Integer.parseInt(stu.nextToken());
			int num = Integer.parseInt(stu.nextToken());
			
			if( sex == 1 ) {
				for(int j=1; j*num<=N; j++) {
					arr[j*num-1] = arr[j*num-1] == 1 ? 0 : 1;
				}
			} else {
				int j = 1;
				arr[num-1] = arr[num-1] == 1 ? 0 : 1;
				while( true ) {
					if( num - j - 1 < 0 || num + j - 1 >= N ) break;
					
					if( arr[num-j-1] != arr[num+j-1] ) break;
					
					arr[num-j-1] = arr[num-j-1] == 1 ? 0 : 1;
					arr[num+j-1] = arr[num+j-1] == 1 ? 0 : 1;
					j++;
				}
			}
		}
		
		int len = N / 20;
		if( len > 0 ) {
			for(int i=0; i<N/20; i++) {
				for(int j=i*20; j<20*(i+1); j++) {
					sb.append(arr[j]+" ");
				}
				sb.append("\n");
			}
		}
		for(int i=len*20; i<N; i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb.toString());
	}

}

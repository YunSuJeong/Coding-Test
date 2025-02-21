import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[M][4];
		for(int i=0; i<N; i++) {
			String dna = br.readLine();
			for(int j=0; j<M; j++) {
				char c = dna.charAt(j);
				if( c == 'A' ) arr[j][0]++;
				else if( c == 'C' ) arr[j][1]++;
				else if( c == 'G' ) arr[j][2]++;
				else arr[j][3]++;
			}
		}
		
		// Hamming Distance의 합이 가장 작은 DNA
		int cnt = 0;
		for(int i=0; i<M; i++) {
			int max = 0, idx = 0;
			for(int j=0; j<4; j++) {
				if( arr[i][j] > max ) {
					max = arr[i][j];
					idx = j;
				}
			}
			if( idx == 0 ) sb.append("A");
			else if( idx == 1 ) sb.append("C");
			else if( idx == 2 ) sb.append("G");
			else sb.append("T");
			cnt += N-max;
		}
		System.out.println(sb.toString());
		System.out.println(cnt);
	}

}

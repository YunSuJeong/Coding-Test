import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		String DNA = br.readLine();
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st1.nextToken());
		int P = Integer.parseInt(st1.nextToken());
		
		int[] min = new int[4];			// {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수
		int[] arr = new int[4];			// 각 부분문자열의 A, C, G, T의 개수
		
		for(int i=0; i<4; i++) {
			min[i] = Integer.parseInt(st2.nextToken());
		}
		
		// 초기 윈도우 세팅
		int cnt = 0;
		for(int i=0; i<P; i++) {
			char c = DNA.charAt(i);
			if( c == 'A' ) arr[0]++;
			else if( c == 'C' ) arr[1]++;
			else if( c == 'G' ) arr[2]++;
			else if( c == 'T' ) arr[3]++;
		}
		if( arr[0] >= min[0] && arr[1] >= min[1] && arr[2] >= min[2] && arr[3] >= min[3] ) cnt++;
		
		for(int i=0; i<S-P; i++) {
			char remove = DNA.charAt(i);
			char add = DNA.charAt(i+P);
			
			if( remove == 'A' ) arr[0]--;
			else if( remove == 'C' ) arr[1]--;
			else if( remove == 'G' ) arr[2]--;
			else if( remove == 'T' ) arr[3]--;
			
			if( add == 'A' ) arr[0]++;
			else if( add == 'C' ) arr[1]++;
			else if( add == 'G' ) arr[2]++;
			else if( add == 'T' ) arr[3]++;
			
			// 최소 개수 조건 만족하는지 확인
			if( arr[0] >= min[0] && arr[1] >= min[1] && arr[2] >= min[2] && arr[3] >= min[3] ) cnt++;
		}
		System.out.println(cnt);
	}

}

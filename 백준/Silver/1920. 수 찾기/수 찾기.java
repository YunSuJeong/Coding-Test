import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String strA = br.readLine();
		int M = Integer.parseInt(br.readLine());
		String strM = br.readLine();
		
		StringTokenizer stA = new StringTokenizer(strA);
		StringTokenizer stM = new StringTokenizer(strM);
		
		
		// 1. List의 indexf사용 -> 시간초과
//		List<Integer> arrA = new ArrayList<Integer>();
//		
//		for(int i=0; i<N; i++) {
//			arrA.add(Integer.parseInt(stA.nextToken()));
//		}
//
//		for(int i=0; i<M; i++) {
//			if( arrA.indexOf(Integer.parseInt(stM.nextToken())) >= 0 ) sb.append("1\n");
//			else sb.append("0\n");
//		}
		
		// 2. Map 사용
		Set<Integer> A = new HashSet<Integer>();
		for(int i=0; i<N; i++) {
			A.add(Integer.parseInt(stA.nextToken()));
		}
		
		for(int i=0; i<M; i++) {
			if( A.contains(Integer.parseInt(stM.nextToken())) ) sb.append("1\n");
			else sb.append("0\n");
		}
		
		
		System.out.println(sb.toString());
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// 1. 2차원 배열 이용하여 로그 저장 -> 메모리 초과, 시간기준으로 정렬하려면 커스텀 필요
//		int[][] log = new int[100000][3];
		// 2. 시간순으로 자동 정렬되어 저장가능한 treeMap 사용
		TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		for(int i=0; i<K; i++) {
			List<Integer> list = new ArrayList<Integer>();
			StringTokenizer logSt = new StringTokenizer(br.readLine());
			
			int T = Integer.parseInt(logSt.nextToken());
			int S = Integer.parseInt(logSt.nextToken());
			int N = Integer.parseInt(logSt.nextToken());
			
//			log[T-1][0] = T;
//			log[T-1][1] = S;
//			log[T-1][2] = N;
			list.add(S);
			list.add(N);
			map.put(T, list);
		}
		
		int[] arr = new int[X+1];		// 학생이 신청한 자리 좌석 번호
		int[] seat = new int[C+1];		// 좌석 신청 상태
		
		for(Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> values = entry.getValue();
			int seatNo = values.get(0);
			int stuNo = values.get(1);
			
			if( seat[seatNo] <= 0 ) {
				// 이미 좌석을 신청했지만 다른 좌석을 신청한 경우, 기존 좌석 상태 초기화
				if( arr[stuNo] > 0 ) seat[arr[stuNo]] = 0;
				// 신청완료한 좌석번호 저장 및 좌석 상태 변경
				arr[stuNo] = seatNo;
				seat[seatNo] = 1;
			}
		}
		
//		for(int i=0; i<=100000; i++) {
//			int seatNo = log[i][1];
//			int stuNo = log[i][2];
//			if( seat[seatNo] <= 0 ) {
//				// 이미 좌석을 신청했지만 다른 좌석을 신청한 경우, 기존 좌석 상태 초기화
//				if( arr[stuNo] > 0 ) seat[arr[stuNo]] = 0;
//				// 신청완료한 좌석번호 저장 및 좌석 상태 변경
//				arr[stuNo] = seatNo;
//				seat[seatNo] = 1;
//			}
//		}
		
		// 출력
		for(int i=0; i<=X; i++) {
			if( arr[i] > 0 ) sb.append(i+" "+arr[i]+"\n");
		}
		System.out.println(sb.toString());
	}

}

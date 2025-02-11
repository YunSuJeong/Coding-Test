import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static int[][] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		// 행렬 A 
		A = new int[M][N];
		for(int i=0; i<M; i++) {
			StringTokenizer stA = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(stA.nextToken());
			}
		}
	
		// 행렬 B
		int[][] B = new int[M-W+1][N-W+1];
		for(int i=0; i<M-W+1; i++) {
			for(int j=0; j<N-W+1; j++) {
				B[i][j] = median(i, j, W);
			}
		}
		
		// 출력
		for(int[] arr : B) {
			for(int n : arr) {
				System.out.print(n+" ");
			}
			System.out.println();
		}
	}
	
	// 중앙값 구하는 함수
	public static int median(int idx1, int idx2, int w) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=idx1; i<idx1+w; i++) {
			for(int j=idx2; j<idx2+w; j++) {
				list.add(A[i][j]);
			}
		}
		Collections.sort(list);
		
		return list.get(list.size()/2);
	}

}

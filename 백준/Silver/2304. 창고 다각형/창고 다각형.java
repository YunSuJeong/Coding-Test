import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[1001];
		
		int N = Integer.parseInt(br.readLine());
		
		int maxH = 0, leftH = 0, rightH = 0;
		int minL = 10000, maxL = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			arr[L] = H;
			maxH = Math.max(maxH, H);
			
			// 가장 왼쪽/오른쪽 기둥 높이
			if( L < minL ) {
				minL = L;
				leftH = H;
			}
			
			if( L > maxL ) {
				maxL = L;
				rightH = H;
			}
		}
		
		// 합, 왼쪽부터 탐색한 최대높이 기둥의 위치, 오른쪽부터 탐색한 최대높이 기둥의 위치
		int sum = 0, l = 0 , r = 0;
		for(int i=minL; i<=maxL; i++) {
			if( arr[i] > leftH ) leftH = arr[i];

			if( leftH == maxH ) {
				l = i;
				break;
			}
			
			sum += leftH;
		}
		
		for(int i=maxL; i>=minL; i--) {
			if( arr[i] > rightH ) rightH = arr[i];
			
			if( rightH == maxH ) {
				r = i;
				break;
			}
			
			sum += rightH;
		}
		
		if( l == r ) sum += maxH;			// 최대 높이인 기둥이 1개인 경우
		else sum += (r-l+1) * maxH; 		// 최대 높이인 기둥이 여러 개인 경우
		System.out.println(sum);
	}

}

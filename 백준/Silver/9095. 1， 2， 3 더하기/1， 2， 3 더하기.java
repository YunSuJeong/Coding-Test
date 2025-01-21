import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*	1, 2, 3 더하기 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			
			// 1) 10중 for문
//			for(int n1=1; n1<=3; n1++) {
//				if(n1 == N) {
//					cnt++;
//				}
//				for(int n2=1; n2<=3; n2++) {
//					if(n1+n2 == N) {
//						cnt++;
//					}
//					for(int n3=1; n3<=3; n3++) {
//						if(n1+n2+n3 == N) {
//							cnt++;
//						}
//						for(int n4=1; n4<=3; n4++) {
//							if(n1+n2+n3+n4 == N) {
//								cnt++;
//							}
//							for(int n5=1; n5<=3; n5++) {
//								if(n1+n2+n3+n4+n5 == N) {
//									cnt++;
//								}
//								for(int n6=1; n6<=3; n6++) {
//									if(n1+n2+n3+n4+n5+n6 == N) {
//										cnt++;
//									}
//									for(int n7=1; n7<=3; n7++) {
//										if(n1+n2+n3+n4+n5+n6+n7 == N) {
//											cnt++;
//										}
//										for(int n8=1; n8<=3; n8++) {
//											if(n1+n2+n3+n4+n5+n6+n7+n8 == N) {
//												cnt++;
//											}
//											for(int n9=1; n9<=3; n9++) {
//												if(n1+n2+n3+n4+n5+n6+n7+n8+n9 == N) {
//													cnt++;
//												}
//												for(int n10=1; n10<=3; n10++) {
//													if(n1+n2+n3+n4+n5+n6+n7+n8+n9+n10 == N) {
//														cnt++;
//													}
//												}
//											}
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//			System.out.println(cnt);
			
			// 2. DP
			int arr[] = new int[N+1];
			arr[0] = 1;
			for(int j=1; j<=N; j++) {
				if( j < 3 ) arr[j] = j;
				else arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
			}
			System.out.println(arr[N]);
		}
	}

}

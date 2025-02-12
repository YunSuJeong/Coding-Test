import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N, M;
            N = sc.nextInt();
            M = sc.nextInt();
            
            if ( N >= 5 && N <= 15 && M >= 2 && M <= N ) {
                int N_arr[][] = new int[N][N];
                int M_arr[][] = new int[M][M];
                for(int i=0; i<N; i++) {
                    for(int j=0; j<N; j++) {
                        int num = sc.nextInt();
                        if( num <= 30 ) N_arr[i][j] = num;
                    }
                }
                
                int len = N - M + 1;
                int M_sum[] = new int[len*len];
                for(int i=0; i<len; i++) {
                	for(int j=0; j<len; j++) {
                       
                        for(int mi=i; mi<i+M; mi++) {
                        	 for(int mj=j; mj<j+M; mj++) {
                        		M_sum[i*len+j] += N_arr[mi][mj];
                             }
                        }
                    }
                }
                Arrays.sort(M_sum);
                System.out.printf("#%d %d\n", test_case, M_sum[M_sum.length-1]);
            }
            
		}
	}
}
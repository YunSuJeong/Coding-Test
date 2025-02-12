import java.util.Scanner;
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
			int N = sc.nextInt();
            
            if( N >= 1 && N <= 10 ) {
            	int arr[][] = new int[N][N];
                
                for( int i=0; i<N; i++ ) {
                	for( int j=0; j<=i; j++ ) {
                    	if( j == 0 ) {
                            arr[i][j] = 1;
                        } else if( i > 0 && arr[i-1][j] > 0 ) {
                        	arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                        } else {
                        	arr[i][j] = 1;
                        }
                    }
                }
                System.out.println("#"+test_case);
                for(int i=0; i<N; i++) {
                    for(int j=0; j<N; j++) {
                        	if( arr[i][j] > 0 ) System.out.print(arr[i][j]+" ");
                    }
                    System.out.println();
                }
            }
		}
	}
}
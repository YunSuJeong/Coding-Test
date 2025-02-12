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
            int numArr[] = new int[10];
            for( int i=0; i<10; i++) {
                numArr[i] = sc.nextInt();
            }
            Arrays.sort(numArr);
            int sum = 0;
            for( int i=0; i<10; i++) {
                if( i != 0 && i != 9 ) sum += numArr[i];
            }
            System.out.printf("#%d %d\n", test_case, Math.round(sum/8.0));
        }
	}
}
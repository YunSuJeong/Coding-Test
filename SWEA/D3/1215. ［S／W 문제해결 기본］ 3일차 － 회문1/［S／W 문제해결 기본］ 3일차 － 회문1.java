import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner  sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = sc.nextInt();
            String arr[][] = new String[8][8];
            // 8*8 입력받기
            for(int i=0; i<8; i++) {
                String str = sc.next();
                int j=0;
                for(String s : str.split("")) {
                    arr[i][j] = s;
                    j++;
                }
            }
            
           	int word = 0;
            for(int i=0; i<8; i++) {
                for(int j=0; j<8-N+1; j++) {
                	boolean flag_h = true, flag_w = true;
                    for(int w=0; w<N/2; w++) {
                        //System.out.println(i+" "+j+" "+(j+w)+" "+(j+N-1-w)+" "+arr[i][j+w]+" "+arr[i][j+N-1-w]);
                        if( arr[i][j+w].equals(arr[i][j+N-1-w]) ) {
                        	// 가로 회문 췤
                        } else {
                        	flag_h = false;
                        	break;
                        }
                    }
                    for(int w=0; w<N/2; w++) {
	                    if( arr[j+w][i].equals(arr[j+N-1-w][i]) ) {
	                    	// 세로 회문 췤
						} else {
							flag_w = false;
							break;
						}
                    }
                    if( flag_h ) word++;
                    if( flag_w ) word++;
                }
            }
            System.out.printf("#%d %d\n", test_case, word);
		}
	}
}

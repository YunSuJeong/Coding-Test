import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char arr[][] = new char[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		// 최댓값 찾기
		int max = 1;
		for(int i=0; i<N; i++) {
			int row = 1, col = 1;
			for(int j=0; j<N-1; j++) {
				// 가로 비교
				if( arr[i][j] == arr[i][j+1] ) {
					row++;
				} else {
					row = 1;
				}
				max = Math.max(max, row);

				// 세로 비교
				if( arr[j][i] == arr[j+1][i] ) {
					col++;
				} else {
					col = 1;
				}
				max = Math.max(max, col);
			}
			
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				// 1) 오른쪽 문자와 비교하여 교환
				if(arr[i][j] != arr[i][j+1]) {
					char tmp = arr[i][j];
					arr[i][j] = arr[i][j+1];
					arr[i][j+1] = tmp; 
					
					// 교환한 두 열에서 최대 길이 검사
					for(int n=j; n<=j+1; n++) {
						int len = 1;
						for(int m=0; m<N-1; m++) {
							if( arr[m][n] == arr[m+1][n] ) {
								len++;
							} else {
								len = 1;
							}
							max = Math.max(max, len);
						}
					}
					// 변경한 행 내 최대 길이 검사
					int row = 1;
					for(int n=0; n<N-1; n++) {
						if( arr[i][n] == arr[i][n+1] ) {
							row++;
						} else {
							row = 1;
						}
						max = Math.max(max, row);
					}
					
					// 원복
					tmp = arr[i][j];
					arr[i][j] = arr[i][j+1];
					arr[i][j+1] = tmp; 
				}
				
				// 2) 아래쪽 문자와 비교하여 교환
				if( arr[j][i] != arr[j+1][i] ) {
					char tmp = arr[j][i];
					arr[j][i] = arr[j+1][i];
					arr[j+1][i] = tmp; 
					
					// 교환한 두 행에서 최대 길이 검사
					for(int n=j; n<=j+1; n++) {
						int len = 1;
						for(int m=0; m<N-1; m++) {
							if( arr[n][m] == arr[n][m+1] ) {
								len++;
							} else {
								len = 1;
							}
							max = Math.max(max, len);
						}
					}
					// 변경한 열 내 최대 길이 검사
					int col = 1;
					for(int n=0; n<N-1; n++) {
						if( arr[n][i] == arr[n+1][i] ) {
							col++;
						} else {
							col = 1;
						}
						max = Math.max(max, col);
					}
					
					// 원복
					tmp = arr[j][i];
					arr[j][i] = arr[j+1][i];
					arr[j+1][i] = tmp; 
				}
			}
		}
		System.out.println(max);
	}
	
}

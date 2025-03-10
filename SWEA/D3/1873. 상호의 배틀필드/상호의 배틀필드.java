import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer size = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(size.nextToken());
			int W = Integer.parseInt(size.nextToken());
			
			// 맵 세팅
			int x = 0, y = 0, dir = 0;					// 초기 전차 위치, 방향
			String[][] arr = new String[H][W];
			for(int i=0; i<H; i++) {
				String str = br.readLine();
				int j=0;
				for(String s : str.split("") ){
					arr[i][j] = s;
					if( s.equals("^") || s.equals("v") || s.equals("<") || s.equals(">") ) {
						x = i;
						y = j;
						if( s.equals("^") ) dir = 1;
						else if( s.equals("v") ) dir = 2;
						else if( s.equals("<") ) dir = 3;
						else dir = 4;
					}
					j++;
				}
			}
			// 사용자 명령처리
			int N = Integer.parseInt(br.readLine());
			String cmds = br.readLine();
			
			for(String cmd : cmds.split("") ) {
				switch (cmd) {
				case "U":
					dir = 1;
					arr[x][y] = "^";
					if( x-1 >= 0 && arr[x-1][y].equals(".") ) {
						arr[x][y] = ".";
						x--;
						arr[x][y] = "^";
					}
					break;
				case "D":
					dir = 2;
					arr[x][y] = "v";
					if( x+1 < H && arr[x+1][y].equals(".") ) {
						arr[x][y] = ".";
						x++;
						arr[x][y] = "v";
					}
					break;
				case "L":
					dir = 3;
					arr[x][y] = "<";
					if( y-1 >= 0 && arr[x][y-1].equals(".") ) {
						arr[x][y] = ".";
						y--;
						arr[x][y] = "<";
					}
					break;
				case "R":
					dir = 4;
					arr[x][y] = ">";
					if( y+1 < W && arr[x][y+1].equals(".") ) {
						arr[x][y] = ".";
						y++;
						arr[x][y] = ">";
					}
					break;
				case "S":
					if( dir == 1 ) { 
						int tmp = x, cnt = 0;
						for(int i=x; i>=0; i--) {
							if( arr[i][y].equals("#") || cnt > 0 ) break;
							if( arr[i][y].equals("*") && cnt == 0 ) {
								arr[i][y] = ".";
								cnt++;
							} 
							tmp = i;
						}
					} else if( dir == 2 ) {
						int tmp = x, cnt = 0;
						for(int i=x; i<H; i++) {
							if( arr[i][y].equals("#") || cnt > 0) break;
							if( arr[i][y].equals("*") && cnt == 0 ) {
								arr[i][y] = ".";
								cnt++;
							} 
							tmp = i;
						}
					} else if( dir == 3 ) {
						int tmp = y, cnt = 0;
						for(int i=y; i>=0; i--) {
							if( arr[x][i].equals("#") || cnt > 0 ) break;
							if( arr[x][i].equals("*") && cnt == 0 ) {
								arr[x][i] = ".";
								cnt++;
							}
							tmp = i;
						}
					} else {
						int tmp = y, cnt = 0;
						for(int i=y; i<W; i++) {
							if( arr[x][i].equals("#") || cnt > 0 ) break;
							if( arr[x][i].equals("*") && cnt == 0 ) {
								arr[x][i] = ".";
								cnt++;
							}
							tmp = i;
						}
					}
					break;
				default:
					break;
				}
				
			}
			
			// 맵 출력
			System.out.printf("#%d ", tc);
			for(String[] line : arr) {
				for(String s : line) {
					sb.append(s);
				}
				sb.append("\n");
			}
			System.out.print(sb.toString());
			sb.setLength(0);
		}
	}

}

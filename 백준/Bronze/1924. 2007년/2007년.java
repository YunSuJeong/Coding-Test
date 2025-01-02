import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int mon = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		String dw[] = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
		
		// 입력받은 날짜를 일수로만 환산하기
		int total = day;
		for(int i=1; i<mon; i++) {
			if( i==2 ) {
				total += 28;
			} else if( i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12 ) {
				total += 31;
			} else {
				total += 30;
			}
		}

		// 나머지로 요일 구하기
		int remain = total%7 == 0 ? 6 : total%7-1;
		for(int i=0; i<7; i++) {
			if( remain == i ) System.out.println(dw[i]);
		}
	}

}

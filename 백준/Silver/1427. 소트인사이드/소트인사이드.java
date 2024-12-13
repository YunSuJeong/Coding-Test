import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.nextLine();
		
		String arr[] = N.split("");
		
		// 2) 반복문
		while( true ) {
			int flag = 0;
			
			for(int i=0; i<N.length()-1; i++) {
				if( arr[i].compareTo(arr[i+1]) < 0 ) {
					String tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
				}
			}
			for(int i=0; i<N.length()-1; i++) {
				if( arr[i].compareTo(arr[i+1]) >= 0 ) flag++;
			}
			if( flag == N.length()-1 ) break;
		}
        for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		int result[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		// DFS로 구현한 순열
		permutation(arr, result, 0);
	}
	
	public static void permutation(int[] arr, int[] result, int depth) {
		StringBuilder sb = new StringBuilder();
		if( depth == arr.length ) {
			for(int n : result) sb.append(n+" ");
			sb.append("");
			System.out.println(sb.toString());
			return;
		}
		for(int i=0; i<arr.length; i++) {
			if( depth == 0 ) {
				result[depth] = arr[i];
				permutation(arr, result, depth+1);
			} else {
				boolean flag = true;
				for(int j=0; j<depth; j++) {
					if( arr[i] == result[j] ) {
						flag = false;
						break;
					}
				}
				if( flag ) {
					result[depth] = arr[i];
					permutation(arr, result, depth+1);
				}
			}
		}
		
	}

}

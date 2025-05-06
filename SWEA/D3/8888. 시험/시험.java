import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	
	public static class Student {
		int num;
		int cnt;
		int[] score;
		int sum;
		
		public Student(int num, int cnt, int[] score) {
			this.num = num;
			this.cnt = cnt;
			this.score = score;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int Tc = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=Tc; tc++) {
			StringTokenizer st = new  StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			int[] point = new int[T];		// 각 문제 배점
			Student[] arr = new Student[N];
			
			for(int i=1; i<=N; i++) {
				StringTokenizer test = new  StringTokenizer(br.readLine());
				int count = 0;
				int[] s = new int[T];
				for(int j=0; j<T; j++) {
					int yn = Integer.parseInt(test.nextToken());
					s[j] = yn;
					if( yn == 1 ) count++;				// 맞은 문제 수
					if( yn == 0 ) point[j]++;			// 문제 배점 계산
				}
				arr[i-1] = new Student(i, count, s);
			}
			
			// 각 학생 총점 계산
			for(int i=0; i<N; i++) {
				int[] stuScore = arr[i].score;
				int sum = 0;
				for(int j=0; j<T; j++) {
					if( stuScore[j] > 0 ) sum += point[j];
				}
				arr[i].sum = sum;
			}
			
			Arrays.sort(arr, new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					// 1번째 정렬기준 : 점수 높은 순
					if( o1.sum == o2.sum ) {
						// 2번째 정렬기준 : 문제 많이 푼 순
						if( o1.cnt == o2.cnt ) 
							return o1.num - o2.num;		// 3번째 정렬기준 : 번호 작은 순
						else return o2.cnt - o1.cnt;
					}
					return o2.sum - o1.sum;
				}
			});
			
			for(int i=1; i<=N; i++) {
				if( arr[i-1].num == P ) {
					System.out.printf("#%d %d %d\n", tc, arr[i-1].sum, i);
					break;
				}
			}
		}
	}

}

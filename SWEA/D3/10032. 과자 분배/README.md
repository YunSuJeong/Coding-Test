# [D3] 과자 분배 - 10032 

[문제 링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXJZ6_6KCLcDFAU3) 

## 문제 풀이
과자를 가장 많이 받은 사람과 적게 받은 사람의 과자 수 차의 최소값을 구하는 문제이다.  
과자를 모두에게 동일하게 나눠줄 수 있느냐 없느냐를 생각해보면 되는 문제이다.  

▶︎ **과자 차이를 최소로 만드는 방법**  
동일하게 나눠 줄 수 있다 = 동일하게 나눠준다.  
동일하게 나눠 줄 수 없다 = 모두 동일하게 나눠주고 남은 과자를 한 사람당 한개 씩 나눠준다.

따라서 (과자 개수)÷(사람 수)가 나누어 떨어지면 차이는 0, 나누어 떨어지지 않으면 1로 계산하면 된다.

### 성능 요약

메모리: 59,436 KB, 시간: 497 ms, 코드길이: 593 Bytes

### 제출 일자

2025-05-19 14:10



> 출처: SW Expert Academy, https://swexpertacademy.com/main/code/problem/problemList.do

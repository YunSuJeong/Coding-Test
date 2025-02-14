# Coding Test
> This is an auto push repository for Baekjoon Online Judge created with [BaekjoonHub](https://github.com/BaekjoonHub/BaekjoonHub).


## 코딩문제 풀면서 고려해야할 사항
### EOF 조건 관련
> [10173] [니모를 찾아서](https://www.acmicpc.net/problem/10173)  
  입력받은 문자에서 대소문자 상관없이 "nemo"가 포함되어 있었는지 찾는 문제였다.  
  EOF 조건 : 마지막 줄에 "EOI"가 입력된다.  

- 잘못된 설계 : 입력 받은 문자를 toUpperCase()한 후 EOF체크함.  
반례) Eoi, EOi -> 종료조건에 만족하지 않지만 종료됐었음. 
- 결론 : 입력값을 가공하여 처리해야하는지 가공 전에 처리해야할지 생각할 것.

### 실수(double, float) 연산하는 경우
> [27496] [발머의 피크 이론](https://www.acmicpc.net/problem/27496)  
> 혈중 알코올 농도 증가량은 술에 포함된 알코올의 양 A*0.001로 계산한다.

- 반례 : 4시간 차의 혈중 알코올 농도는 0.129여야 맞지만, 실수로 연산한다면 0.1289999...라서 0.129로 처리되지 않는다.  
ex) 200 145 71 58
- 결론 : 실수 연산이 누적되는 경우에 오차가 발생하기 때문에, 오차에 민감한 문제는 정수로만 푸는 것을 추천한다.

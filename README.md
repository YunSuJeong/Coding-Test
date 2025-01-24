# BAEKJOON
This is an auto push repository for Baekjoon Online Judge created with [BaekjoonHub](https://github.com/BaekjoonHub/BaekjoonHub).


## 틀렸습니다.
### EOF 조건 관련
> [10173] [니모를 찾아서](https://www.acmicpc.net/problem/10173)  
  입력받은 문자에서 대소문자 상관없이 "nemo"가 포함되어 있었는지 찾는 문제였다.  
  EOF 조건 : 마지막 줄에 "EOI"가 입력된다.  

- 잘못된 설계 : 입력 받은 문자를 toUpperCase()한 후 EOF체크함.  
반례) Eoi, EOi -> 종료조건에 만족하지 않지만 종료됐었음. 
- 결론 : 입력값을 가공하여 처리해야하는지 가공 전에 처리해야할지 생각할 것.

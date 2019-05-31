# 두 정수 사이의 합

## Question
<br><br>
### **문제 설명**

두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요. <br>
예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
<br><br>
### **제한사항**

* a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
* a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
* a와 b의 대소관계는 정해져있지 않습니다.
<br><br>
### **입출력 예**
|a|b|return|
|---|---|---|
|3|5|12|
|3|3|3|
|5|3|12|
<br><br>
### **입출력 예 설명**
문제의 input, output 을 대입했을때 결과 예시입니다.

<br><br>
## My Solution
``` Java
class Solution {
	public static long solution(int a, int b) {
		long answer = 0;
		int big = 0;
		int small = 0;
		if (a == b) {
			return a;
		} else if (a > b) {
			big = a;
			small = b;
		} else {
			big = b;
			small = a;
		}
		
		for (int i=small; i<big; i++) {
			answer += i;
		}
		return answer;
	}
}
```
<br><br>
## Most Liked Solution
``` Java
class Solution {

    public long solution(int a, int b) {
        return sumAtoB(Math.min(a, b), Math.max(b, a));
    }

    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }
}
```
등차수열의 합을 구하는 공식으로 해결했다. <br>
나도 분명 알고있던 내용인데... 코딩에 적용할때는 왜 생각이 안나는지...
<br><br>
## Elapsed Time (HH:MM)
00:10
**HH:MM**
<br><br>
## Review
간단한 문제
<br><br>
## Reference
프로그래머스 코딩테스트 연습 - https://programmers.co.kr/learn/courses/30/lessons/12912
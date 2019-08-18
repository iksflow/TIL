# 스킬체크 테스트 문제 1번

## Question
### **문제 설명**
array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.  
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.  
### **제한 조건**
* arr은 자연수를 담은 배열입니다.
* 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
* divisor는 자연수입니다.
* array는 길이 1 이상인 배열입니다.
<br><br>
### **입출력 예**
| arr | divisor	| return |
|---|---|---|
| [5, 9, 7, 10] | 5 | [5, 10] |
| [2, 36, 1, 3] | 1 | [1, 2, 3, 36] |
| [3,2,6] | 10 | [-1] |
### **입출력 예 설명**
입출력 예#1  
arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.  

입출력 예#2  
arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.  

입출력 예#3  
3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴합니다.  
## My Solution
``` Java
import java.util.Arrays;
class Solution {
	/* 시험은 최대 10,000 문제로 구성되어있습니다.
	 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
	 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
	 * 1번 수포자 : 12345 패턴 -> 순차적으로 찍는다.
	 * 2번 수포자 : 21232425 패턴 -> 홀수번째 문제는 2번을 찍고 나머지를 순차적으로 돌아가며 찍는다.
	 * 3번 수포자 : 31245 패턴 -> 31245 순서대로 각 2번씩 찍는다.
	 * */
    	public static int[] solution(int[] arr, int divisor) {
		int[] answer = {};
		int count = 0;
		for (int elem : arr) {
			if (elem%divisor == 0) {
				answer = Arrays.copyOf(answer, answer.length + 1);
				answer[count] = elem;
				count++;
			}
		}
		if (answer.length == 0) {
			answer = Arrays.copyOf(answer, answer.length + 1);
			answer[0] = -1;
		} else {
			Arrays.sort(answer);	
		}
		
		return answer;
	}
}
```
<br><br>
## Most Liked Solution
``` Java

```
<br><br>
## Elapsed Time (HH:MM)
**00:25**
<br><br>
## Review
단순한 문제...  
## Reference
* 프로그래머스 코딩테스트 연습 - https://www.welcomekakao.com/skill_checks/28816?challenge_id=899
# 나누어 떨어지는 숫자 배열

## Question

### **문제 설명**

array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.<br/>
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
<br><br>
### **제한사항**
* arr은 자연수를 담은 배열입니다.
* 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
* divisor는 자연수입니다.
* array는 길이 1 이상인 배열입니다.
<br><br>
### **입출력 예**
|arr|divisor|return|
|---|---|---|
|[5, 9, 7, 10]|5|[5, 10]|
|[2, 36, 1, 3]|1|[1, 2, 3, 36]|
|[3,2,6]|10|[-1]|
<br><br>
### **입출력 예 설명**

입출력 예#1
arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.

입출력 예#2
arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.

입출력 예#3
3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴합니다.
<br><br>
## My Solution
``` Java
class Solution {
	/*
	 * arr은 자연수를 담은 배열입니다.
	 * 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
	 * divisor는 자연수입니다.
	 * array는 길이 1 이상인 배열입니다.
	 */
	public static int[] solution(int[] arr, int divisor) {
		int[] answer = {};
		Arrays.sort(arr);
		for (int elem : arr) {
			if (elem % divisor == 0) {
	    		answer  = Arrays.copyOf(answer,  answer.length + 1);
	    		answer[answer.length - 1] = elem;
			}
		}
		if (answer.length == 0) {
			answer  = Arrays.copyOf(answer,  answer.length + 1);
    	answer[answer.length - 1] = -1;
		}
		return answer;
	}
}
```
<br><br>
## Most Liked Solution
``` Java
// 문제가 개편 되었습니다. 이로 인해 함수 구성이 변경되어, 과거의 코드는 동작하지 않을 수 있습니다.
// 새로운 함수 구성을 적용하려면 [코드 초기화] 버튼을 누르세요. 단, [코드 초기화] 버튼을 누르면 작성 중인 코드는 사라집니다.
import java.util.Arrays;

class Divisible {
    public int[] divisible(int[] array, int divisor) {
        //ret에 array에 포함된 정수중, divisor로 나누어 떨어지는 숫자를 순서대로 넣으세요.
        return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
    }
    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        Divisible div = new Divisible();
        int[] array = {5, 9, 7, 10};
        System.out.println( Arrays.toString( div.divisible(array, 5) ));
    }
}
```
나는 잘 모르는 람다식과, Arrays.stream, filter를 통해 풀어나간 방식이다. <br/>
나중에 무슨기능하는 메소드인지 구경해봐야겠다.
<br><br>
## Elapsed Time (HH:MM)
00:05
<br><br>
## Review
문제 자체는 어렵지 않았다. 인자로 받은 int 배열을 정렬하고 나눈다음 answer 배열에 넣어주면 그만이었다. <br/>
단지 조금 걸리는 부분은 배열은 길이 초기화가 안돼서 계속 copyOf를 통해 원본 + 1 해서 길이를 늘려가는 방식이라는거? <br/>
<br><br>
## Reference
프로그래머스 코딩테스트 연습 - https://programmers.co.kr/learn/courses/30/lessons/12910
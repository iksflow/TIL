# 삽입정렬(Insertion Sort)

## Concept
어떤 수의 집합을 오름차순으로 정렬한다고 가정했을 경우, 바로 옆에 있는 값과 비교해서 더 작은값을 앞으로 보내 정렬하는 알고리즘이다.
## Content
{1, 10, 5, 8, 7, 6, 4, 3, 2, 9} 의 수를 정렬한다면, 순회를 10 + 9 + 8 + ... + 2 + 1 번 해야한다.<br>
이 경우 시간복잡도는 O(N^2)이 된다.<br>
while문의 조건을 보면 현재 index와 그 다음 index와 값을 비교해서 이상이 없다면 이전의 값들을 비교하는 로직을 과감하게 생략한다.<br>
그래서 거의 정렬된 상태(j가 j+1 보다 작은경우) 라면 while문 안의 로직을 다 생략해버리기 때문에 속도가 빠르다.

## Summary
시간복잡도는 O(N * N) 이다. <br>
하지만 거의 정렬된 상태라면 매우 빠른 속도를 보장하는 정렬 알고리즘이다. <br>
## Code
``` C++
#include <stdio.h>

int main(void) {
	int i, j, temp;
	int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
	for(i = 0; i < 9; i++) {
		for(j = 0; j < 9; j++) {
			if(array[j] > array[j + 1]) {
				temp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = temp;
			}
		}
		
	}
	for(i = 0; i < 10; i++) {
		printf("%d ", array[i]);	
	}
  
  return 0;
}
```
## Review
* 선택, 버블 이후 좀 난이도가 올라간느낌 ... <br>
* 앞의 배열이 정렬되었다고 '가정' 한다는 부분이 중요해 보인다.
## Question
* Worst Case 찾아보기 - 오름차순 정렬을 하려고 할 때, 정렬이 내림차순으로 되어있는경우. 일일히 다 비교해야하기 때문에 가장 느리다. <br>
정렬하고자 하는 결과값의 완전한 반대모델이 가장 느린 케이스가 된다.
## Reference
* 나동빈님 유튜브 - https://www.youtube.com/watch?v=8ZiSzteFRYc&list=PLRx0vPvlEmdDHxCvAQS1_6XV4deOwfVrz&index=3

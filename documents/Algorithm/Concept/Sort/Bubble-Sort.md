# 버블정렬(Bubble Sort)

## Concept
어떤 수의 집합을 오름차순으로 정렬한다고 가정했을 경우, 가장 작은 수를 앞으로 보내서 정렬하는 알고리즘이다.
## Content
{1, 10, 5, 8, 7, 6, 4, 3, 2, 9} 의 수를 정렬한다면, 순회를 10 + 9 + 8 + ... + 2 + 1 번 해야한다.<br>
등차수열의 합 공식인 N * (N + 1) / 2번 즉 55번이 된다.<br>
이 경우 시간복잡도는 O(N^2)이 된다.
## Summary
시간복잡도가 O(N^2) 이라는 얘기는, 10000건의 데이터를 처리하는데 1억번의 연산이 필요하다는 뜻이다.<br>
많이 비효율적인 알고리즘이다.
## Code
``` C++
#include <stdio.h>

int main(void) {
	int i, j, min, index, tmp;
	int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
	for (i = 0; i < 10; i++) {
		min = 9999;
		for(j = i; j < 10; j++) {
			if(min > array[j]) {
				min = array[j];
				index = j;
			}
		}
		tmp = array[i];
		array[i] = array[index];
		array[index] = tmp;
	}
	
	for (int k =0; k < 10; k++) {
		printf("%d ", array[k]);
	}
	
	return 0;
}
```
## Review
* 지나가면서 배웠던 정렬 알고리즘이었는데 이렇게 정리해보니 머리속에 오래 남을것 같다.
* 빅오 표기법에 대한 개념을 알기쉽게 설명해주셔서 좋았다.
## Question
* 그렇다면 효율적인 정렬 알고리즘은 어떤것일까?
* 선택정렬은 전혀 사용되지 않는것인가?
## Reference
* 나동빈님 유튜브 - https://www.youtube.com/watch?v=8ZiSzteFRYc&list=PLRx0vPvlEmdDHxCvAQS1_6XV4deOwfVrz&index=2
# 삽입정렬(Insertion Sort)

## Concept
어떤 수의 집합을 오름차순으로 정렬한다고 가정했을 경우, 바로 옆에 있는 값과 비교해서 더 작은값을 앞으로 보내 정렬하는 알고리즘이다.
## Content
{1, 10, 5, 8, 7, 6, 4, 3, 2, 9} 의 수를 정렬한다면, 순회를 10 + 9 + 8 + ... + 2 + 1 번 해야한다.<br>
이 경우 시간복잡도는 O(N^2)이 된다.
## Summary
선택정렬과 마찬가지로 비효율적인 정렬 알고리즘.
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
* 선택, 버블 이후 좀 난이도가 올라간느낌 ...
## Question
* Worst Case 찾아보기
## Reference
* 나동빈님 유튜브 - https://www.youtube.com/watch?v=8ZiSzteFRYc&list=PLRx0vPvlEmdDHxCvAQS1_6XV4deOwfVrz&index=3
# 병합정렬(Merge Sort)

## Concept
반으로 나눠서 정렬.
## Content
재귀함수 호출로 구현하는 알고리즘.
## Summary
시간복잡도는 O(N * log N) 이다. <br>
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
* 선택, 버블, 삽입정렬 이후 좀 난이도가 올라간느낌 ... <br>
재귀적인 방법에 개념이 약했는데.. 이후 나올 병합정렬에도 필요한 개념이니 이해하고 넘어가야겠다.
## Question
* Worst Case 찾아보기
## Reference
* 나동빈님 유튜브 - https://www.youtube.com/watch?v=8ZiSzteFRYc&list=PLRx0vPvlEmdDHxCvAQS1_6XV4deOwfVrz&index=5
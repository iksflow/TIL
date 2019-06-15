# 퀵정렬(Insertion Sort)

## Concept
어떤 수의 집합을 오름차순으로 정렬한다고 가정했을 경우, pivot값을 기준으로 분할정복방식을 채택해 잘게 쪼개 정렬하는 알고리즘이다.
## Content
재귀함수 호출로 구현하는 알고리즘.
## Summary
시간복잡도는 O(N * log N) 이다. <br>
## Code
``` C++
#include <stdio.h>
int number = 10;
int data[] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

void show() {
	int i;
	for(i = 0; i < number; i++) {
		printf("%d ", data[i]);
	}
}

void quickSort(int* data, int start, int end) {
	if (start >= end) {	// 원소가 1개인 경우 그대로 두기 
		return;		
	}
	
	int key = start;
	int i = start + 1, j = end, temp;
//	int j = end;
//	int temp;
	
	while(i <= j) { // i와 j가 서로 엇갈릴때까지 반복한다 
		while(i <= end && data[i] <= data[key]) {	// key 값보다 큰 값을 만날 때 까지 
			i++;
		}
		while(j > start && data[j] >= data[key]) {	// key 값보다 작은 값을 만날 때 까지 
			j--;
		}
		
		if(i > j) {
			temp = data[j];
			data[j] = data[key];
			data[key] = temp;
		} else {
			temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
	} 
	
	quickSort(data, start, j - 1);
	quickSort(data, j + 1, end);
	
}

int main(void) {
	quickSort(data, 0 , number - 1);
	show();
	return 0;
}
```
## Review
* 선택, 버블, 삽입정렬 이후 좀 난이도가 올라간느낌 ... <br>
재귀적인 방법에 개념이 약했는데.. 이후 나올 병합정렬에도 필요한 개념이니 이해하고 넘어가야겠다.
## Question
* Worst Case 찾아보기
이미 정렬이 모두 되어있는상황이라면 시간이 가장 오래걸린다.
## Reference
* 나동빈님 유튜브 - https://www.youtube.com/watch?v=8ZiSzteFRYc&list=PLRx0vPvlEmdDHxCvAQS1_6XV4deOwfVrz&index=5

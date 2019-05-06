# 같은 숫자는 싫어 

## Question

<br><br>
### **문제 설명**
배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 배열 arr에서 제거 되고 남은 수들을 return 하는 solution 함수를 완성해 주세요. 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. <br/>
예를들면
* arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
* arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
<br><br>
### **제한사항**
* 배열 arr의 크기 : 1,000,000 이하의 자연수
* 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
<br><br>
### **입출력 예**
|arr|answer|
|---|---|---|
|[1,1,3,3,0,1,1] | [1,3,0,1]|
|[4,4,4,3,3] | [4,3]|
<br><br>
### **입출력 예 설명**
입출력 예 #1,2<br/>
문제의 예시와 같습니다.
<br><br>
## My Solution
``` Java
import java.util.ArrayList;
import java.util.List;

class Solution {
	public static int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> resultArray = new ArrayList<Integer>();
        
        for (int i=0; i < arr.length; i++) {
        	if (i == 0) {
        		resultArray.add(arr[i]);
        	} else {
        		if (arr[i] != arr[i-1]) {
        			resultArray.add(arr[i]);	
            	}	
        	}
        }
        answer = new int[resultArray.size()];
        for (int i=0; i < answer.length; i++) {
        	answer[i] = resultArray.get(i);
        }
        	
        
        return answer;
	}
}
```
<br><br>
## Most Liked Solution
``` Java
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10;
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num;
        }       
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }
        return answer;
    }
}
```
preNum 에 이전값을 저장해두고 비교대상으로 삼는 로직이다. <br/>
왜 이생각을 못했는지... ㅎㅎ<br/>
나는 이전 인덱스와 비교해야한다는 생각에 사로잡혀서 불필요한 조건문을 많이써버렸다.
<br><br>
## Elapsed Time (HH:MM)
00:30
<br><br>
## Review
문제를 제대로 안읽어 시간낭비했다...<br/>
좀 없어지나 했더니 집중 안하니까 다시 안좋은 습관이 나와버렸다.<br/>
주의해야지...
<br><br>
## Reference
프로그래머스 코딩테스트 연습 - https://programmers.co.kr/learn/courses/30/lessons/12906
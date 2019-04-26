# K번째 수 

## Question
<br><br>
### **문제 설명**
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
3. 2에서 나온 배열의 3번째 숫자는 5입니다.

배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
<br><br>
### **제한사항**
* array의 길이는 1 이상 100 이하입니다.
* array의 각 원소는 1 이상 100 이하입니다.
* commands의 길이는 1 이상 50 이하입니다.
* commands의 각 원소는 길이가 3입니다.
<br><br>
### **입출력 예**
|array |	commands | return |
|---|---|---|
|[1, 5, 2, 6, 3, 7, 4]	| [[2, 5, 3], [4, 4, 1], [1, 7, 3]] |	[5, 6, 3] |
<br><br>
### **입출력 예 설명**

* [1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
* [1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
* [1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
<br><br>
## My Solution
``` Java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
class Solution {
	/* array의 길이는 1 이상 100 이하입니다.
	 * -> 최대 100개의 숫자가 들어갈 수 있다.
	 * array의 각 원소는 1 이상 100 이하입니다.
	 * -> 1 ~ 100의 숫자만 들어갈 수 있다. 중복이 되는지는 모르겠다.
	 * commands의 길이는 1 이상 50 이하입니다.
	 * -> 최소 1개에서 최대 50개의 값이 결과값 배열에 담긴다.
	 * commands의 각 원소는 길이가 3입니다.
	 * ->index start, index end, index selected의 규칙을 항상 따른다.
	 * */
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        for (int[] command : commands) {
        	List<Integer> resultList = new ArrayList<Integer>();
        	int startIndex = command[0];
        	int endIndex = command[1];
        	int selectIndex = command[2];
        	int arrayIndex = 0;
        	for(int element : array) {
        		if(startIndex <= arrayIndex + 1 && arrayIndex + 1 <= endIndex) {
        			resultList.add(element);	
        		}
            	arrayIndex++;
            }
        	Collections.sort(resultList);
    		answer  = Arrays.copyOf(answer,  answer.length + 1);
    		answer[answer.length - 1] = resultList.get(selectIndex - 1);
        }
        
        return answer;
    }
}
```
<br><br>
## Most Liked Solution
``` Java
import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
```
answer의 최초 정의부는 건드리면 안되는줄 알았는데 위와같이 처리하면 나처럼 미련하게 배열을 반복적으로 계속 카피해서 length를 건드리지 않아도 된다는 좋은걸 배웠다.<br>
눈여겨 볼 부분은 반복문 안의 Arrays.copyOfRange 라고 생각이 든다.<br>
나는 전혀 모르고있던 메소드인데 찾아보니 copyOfRange(array, from, to) 형식으로 쓴다.<br>
그래서 copyOfRange를 사용할 경우 위 코드대로 간결하게 처리할 수 있다.<br>
그 후 정렬한다음 answer에 selectIndex를 집어넣는것은 동일하다.


<br><br>
## Elapsed Time (HH:MM)
**00:20**
<br><br>
## Review
이번에는 집중해서 먼저 문제에서 요구하는 내용과 제한사항을 파악한뒤에 코딩을 시작했다. <br>
이전보다 눈에 띄게 빨리 풀 수 있었는데, 문제가 쉬운 탓도 있었겠지만 구현해야할 사항을 명확히 해놓고 나니 집중해서 생각할 수 있었던 것 같다. <br>
Most Liked Solution과 My Solution을 비교해보면 언제든지 다룰 수 있는 메소드의 범위차이가 확연히 나는 것 같다.<br>
이러한 차이가 구현하는 방식에 꽤 많은 영향을 주는 것 같다는 생각이 들고, Java에서 제공하는 Util에도 관심을 기울여야 겠다는 교훈을 얻었다.
<br><br>
## Reference
* 프로그래머스 코딩테스트 연습 - https://programmers.co.kr/learn/courses/30/lessons/42748
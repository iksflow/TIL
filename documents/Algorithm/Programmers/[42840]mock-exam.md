# 모의고사 

## Question
### **문제 설명**
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다. <br><br>
1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ... <br>
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ... <br>
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ... <br><br>
1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
<br><br>
### **제한 조건**
시험은 최대 10,000 문제로 구성되어있습니다. <br>
문제의 정답은 1, 2, 3, 4, 5중 하나입니다. <br>
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
<br><br>
### **입출력 예**
|answers | return |
|---|---|
|[1,2,3,4,5] | [1] |
|[1,3,2,4,2] | [1,2,3] |
<br><br>
### **입출력 예 설명**
입출력 예 #1

* 수포자 1은 모든 문제를 맞혔습니다.
* 수포자 2는 모든 문제를 틀렸습니다.
* 수포자 3은 모든 문제를 틀렸습니다.

따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2

* 모든 사람이 2문제씩을 맞췄습니다.
<br><br>
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
    public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] scoreBoard = {0, 0, 0};
        int[] firstStudentPattern = {1, 2, 3, 4, 5};
        int[] secondStudentPattern = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdStudentPattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int index = 0;
        int maxValue = 0;
        
        for(int singleAnswer : answers) {
        	// student 1
        	if (firstStudentPattern[index%5] == singleAnswer) {
        		scoreBoard[0]++;
        	}
        	// student 2
        	if (secondStudentPattern[index%8] == singleAnswer) {
        		scoreBoard[1]++;
        	}
        	// student 3
        	if (thirdStudentPattern[index%10] == singleAnswer) {
        		scoreBoard[2]++;
        	}
        	index++;
        }
        
        for (int i = 0; i < scoreBoard.length; i++) {
        	if (maxValue < scoreBoard[i]) {
        		maxValue = scoreBoard[i];
        		answer  = Arrays.copyOf(answer,  1);
        		answer[answer.length - 1] = i + 1;
        	} else if (maxValue == scoreBoard[i]) {
        		answer  = Arrays.copyOf(answer,  answer.length + 1);
        		answer[answer.length - 1] = i + 1;
        	}
        }
        
        
        Arrays.sort(answer);
        return answer;
    }
}
```
<br><br>
## Most Liked Solution
``` Java
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}
```
<br><br>
## Elapsed Time (HH:MM)
**01:35**
<br><br>
## Review

문제를 풀면서 처음에는 패턴을 파악하는데 시간을 쓰고, 그 다음에는 패턴을 간략화 하는 방법에대해 시간을 많이 썼다. 사실 패턴을 간략화하게 정의하는 부분은 우선 문제를 풀고나서 해결해도 상관없었을텐데 시간을 너무 많이쏟았다. <br>
좋아요가 가장 많은 코드도 그냥 패턴을 한정지어놓은것을 보고 쓸데없는 고민을 했구나 하고 생각했다(..수열도 아닌데 뭐한건지) <br>
진짜 시간을 많이 뺏기는 구간은 여기보다 마지막 조건에서 찾아왔다... <br>
'가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.' 라는 조건에서 최대값을 정렬하는건 하겠는데, 그게 누구의 값인지 어떻게알아? 에서 한참을 고민한것같다.<br>
결국 그냥 전역변수에 index를 저장해놓으면 되는것이었는데... 내가 최대값의 인덱스를 뽑는방법을 못한다는것을 알게되었다. <br>
다른사람의 코드와 비교했을때, 최대값 정렬하는 부분이 조금 다를뿐 전체적인 로직은 비슷하게 생각한것 같다. <br>
기본기의 부족함을 많이 느끼게 해주는 문제였다...
<br><br>
## Reference
* 프로그래머스 코딩테스트 연습 - https://programmers.co.kr/learn/courses/30/lessons/42840
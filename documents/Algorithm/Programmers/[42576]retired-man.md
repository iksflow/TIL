# 42576번 문제 : 완주하지 못한 선수

## Question
<br><br>
### **문제 설명**
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
<br><br>
### **제한사항**
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.
<br><br>
### **입출력 예**
participant | completion | return
|---|---|---|
["leo", "kiki", "eden"] | ["eden", "kiki"] | "leo"
["marina", "josipa", "nikola", "vinko", "filipa"]| ["josipa", "filipa", "marina", "nikola"] | "vinko"
["mislav", "stanko", "mislav", "ana"]| 	["stanko", "ana", "mislav"] | "mislav"
<br><br>
### **입출력 예 설명**
예제 #1<br>
leo는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #2<br>
vinko는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #3<br>
mislav는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
<br><br>
## My Solution
* 1차 시도 (실패)
```Java
import java.util.HashMap;

	/*마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
	 * : 최대 10만개의 데이터를 처리할 수 있는 로직이어야한다.
	 *completion의 길이는 participant의 길이보다 1 작습니다.
	 * 1. 항상 탈락자가 1명 생김. (그러므로 string 리턴이 가능하다) 
	 * 2. 탈락자의 종류: 다른이름의 사람, 동명이인 
	 *참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
	 *:아직 잘 모르겠다.
	 *참가자 중에는 동명이인이 있을 수 있습니다.
	 *:Map의 Key로 체크하는것에 한계가있다.
	 *[Dummy]
	 *1. 모든 참가자는 서로 이름이 다르다.
	 *2. 참가자 중 이름이 같은사람이 1명이다.
	 *3. 참가자 중 이름이 같은사람이 2명 이상이다.
	 *4. 모든 참가자는 서로 이름이 같다.
	 * */

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, String> resultMap= new HashMap<String, String>();
        for (String name : completion) {
        	resultMap.put(name, "unchecked");
        }
        
        for (String name : participant) {
        	if (resultMap.get(name) != null && resultMap.get(name).equals("unchecked")) {
        		resultMap.put(name, "checked");
        	} else {
        		answer = name;
        		break;
        	}
        }
        
        
        return answer;
    }
}
```
* 2차시도 (성공)
```Java
public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, List<String>> completionMap= new HashMap<String, List<String>>();
        
        for (String name : completion) {
        	if (completionMap.get(name) == null) {
        		List<String> compList = new ArrayList<String>();
        		compList.add(name);
            	completionMap.put(name, compList);	
        	} else {
        		completionMap.get(name).add(name);	
        	}
        }
        
        for (String name : participant) {
        	
        	if (completionMap.get(name) != null && completionMap.get(name).size() != 0) {
        		completionMap.get(name).remove(0);
        	} else {
        		answer = name;
        		break;
        	}
        }
        
        
        return answer;
    }
```
<br><br>
## Most Liked Solution
```Java
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}
```
내가 작성한 코드는 Map, List를 사용해서 번잡하게 처리한 반면, HashMap만을 사용해 깔끔하게 처리한 코드다. <br>
지금와서 드는 생각이지만 간단하게 숫자만 저장해도 되는걸 필요 이상의 데이터를 넣은것 같다는 생각이 든다. <br>
getOrDefault 메소드는 이번에 처음 알게되었는데 key에 값이 없으면 설정한 default값을 반환하는 메소드이다.<br>
SQL의 coalesce, 오라클 nvl과 같은 기능이라고 보면 될 것 같다.
<br><br>
## Review
1차 시도로 작성한 코드는 1, 2번 케이스까지는 처리가 가능했다. 하지만 동명이인의 종류가 2가지가 넘어가면 답을 낼수 없는 로직이었다.
```Java
		String [] participant = {"park", "park", "choi", "choi"};
		String [] completion = {"park", "park", "choi"};
```
위와같은 테스트케이스를 적용해보면 답은 choi 가 나와야하는데 park를 return해버리는 로직이기 때문이다. <br>
3, 4번 조건까지 만족하려면 다른방식을 찾아야했다. <br>
그래서 2차시도에는 HashMap Value를 List로 받아서 복수의 인원을 다룰 수 있도록 처리했다.<br>
문제를 푸는데 1시간정도 걸렸는데 Level 1의 쉬운문제에서 한참 고민했다는게 자료구조에대해 공부가 부족하다는걸 실감하게 되었다. <br>
그리고 예전부터 문제를 똑바로 읽지않는 안좋은 버릇이 있었는데 다시 상기하는 기회가 되었다. <br>
먼저 요구사항을 명확히하고 문제에 접근했다면 1차시도와같은 실수는 나오지 않았을텐데 주석으로 조건을 정리해놓고 문제에 접근하니 금방 결론에 도달할 수 있었다. <br>
항상 요구사항 정리는 습관화 하도록 해야겠다.
<br><br>
## Reference 
* 프로그래머스 코딩테스트 연습- https://programmers.co.kr/learn/courses/30/lessons/42576

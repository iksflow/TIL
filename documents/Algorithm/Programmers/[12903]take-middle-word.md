# 가운데 글자 가져오기
## Question
문제 내용 입니다.
<br><br>
### **문제 설명**
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
<br><br>
### **제한사항**
s는 길이가 1 이상, 100이하인 스트링입니다.
<br><br>
### **입출력 예**
|s|return|
|"abcde"|"c"|
|"qwer"|"we"|
<br><br>
## My Solution
``` Java
class Solution {
  public static String solution(String s) {
      String answer = "";
      int length = s.length();
      int startIndex = length%2 == 0 ? length/2 - 1: length/2;  
      int endIndex = length%2 == 0 ? startIndex + 2 : startIndex + 1; 
      answer = s.substring(startIndex, endIndex);
      return answer;
  }
}
```
<br><br>
## Most Liked Solution
``` Java
// 문제가 개편 되었습니다. 이로 인해 함수 구성이 변경되어, 과거의 코드는 동작하지 않을 수 있습니다.
// 새로운 함수 구성을 적용하려면 [코드 초기화] 버튼을 누르세요. 단, [코드 초기화] 버튼을 누르면 작성 중인 코드는 사라집니다.
class StringExercise{
    String getMiddle(String word){

        return word.substring((word.length()-1) / 2, word.length()/2 + 1);    
    }
    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void  main(String[] args){
        StringExercise se = new StringExercise();
        System.out.println(se.getMiddle("power"));
    }
}
```
길이가 홀수 짝수일경우 처리하는 로직이 내가 작성한 코드보다 훨씬 간단하다. <br>
나누기의 특성을 잘 살린 좋은 예시인것같다.
<br><br>
## Elapsed Time (HH:MM)
00:10
<br><br>
## Review
난이도가 쉬운 문제였다. <br>

<br><br>
## Reference
* 프로그래머스 코딩테스트 연습 - https://programmers.co.kr/learn/courses/30/lessons/12903
# Collections.sort() 와 Arrays.sort() 의 차이점

## Content
Collections.sort() 와 Arrays.sort()의 차이점은 무엇일까?<br>
Collections의 sort는 parameter로 Object 타입을 받는 반면, Arrays의 sort는 Array를 받는다.<br>
``` Java
List<String> arrayA = new ArrayList<String>();
int[] arrayB = {}; 
``` 
arrayA의 경우 Collections의 sort로 정렬이 가능하다.<br>
arrayB의 경우 Arrays의 sort로 정렬이 가능하다.<br>
기본적인 결과값은 동일하고, 현재 내가 다루고있는 객체 타입에 따라 구분해서 사용하면 된다.


## Summary
정렬할 대상의 객체 타입에 따라서 Object는 Collections를, Primitive Type의 Array는 Arrays의 sort를 구분해서 사용하면 된다.

## Review
이런 기초적인것도 몰랐다니... 반성하자.<br>
Collections에 대한 이해가 좀 부족한거 아니었을까...?

## Question

## Reference
* Quora - https://www.quora.com/What-is-the-difference-between-Collections-sort-and-Arrays-sort-in-Java

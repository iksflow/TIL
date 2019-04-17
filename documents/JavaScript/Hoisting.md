# 호이스팅 (Hoisting)

## 1. 호이스팅이란?

호이스팅은 변수 및 함수 선언이 물리적으로 작성한 코드의 상단으로 옮겨지는 거로 가르치지만, 실제로는 그렇지 않다. <br/>
변수 및 함수 선언은 컴파일 단계에서 메모리에 저장되지만, 코드에서 입력한 위치와 정확히 일치한 곳에 있다.


## 2. 호이스팅 예제
```JS
// 1. 함수를 먼저 선언하고 그 뒤에 함수 호출을 하는 경우.
function catName(name) {
  console.log("My cat's name is " + name);
}

catName("Tigger");
/*
위 코드의 결과는: "My cat's name is Tigger"
전형적인 함수 선언 후 호출하는 형태이다.
*/

// 2. 함수를 호출한 다음 함수를 선언하는 경우
catName("Chloe");

function catName(name) {
  console.log("My cat's name is " + name);
}
/*
위 코드의 결과는: "My cat's name is Chloe"
함수를 먼저 호출하고나서 선언을 했지만 결과는 정상적으로 나온다.
*/

```
이런 결과가 나오는 이유는 JavaScript에서 컨텍스트 실행이 작동하는 방식 때문이다.<br/>
Hoisting은 다른 데이터 타입 및 변수와도 잘 작동한다. 변수는 선언하기 전에 초기화하여 사용될 수 있다. <br/>
그러나 초기화 없이는 사용할 수 없습니다.
```JS
num = 6;
num + 7;
var num; 
/* num이 선언되지 않더라도 에러를 내지 않는다 */
```

## Summary
* 선언 이전에 호출해도 정상적으로 작동하는것을 호이스팅이라고 한다.

## Review
아무런 생각 없이 저렇게도 작동하는구나하고 써왔던 방식인데 호이스팅이라고 부르는것을 알게되었다.

## Reference
* MDN - https://developer.mozilla.org/ko/docs/Glossary/Hoisting
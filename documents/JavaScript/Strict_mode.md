# Strict mode (엄격모드)

## 1. Strict mode 란?
* 엄격 모드는 에러를 나게해서 JavaScript 가 무시했던 에러를 제거하도록 한다.
* 엄격 모드는 JavaScript 엔진이 최적화 작업을 하는 데에 어렵게 만드는 실수들을 고친다. 
* 엄격 모드는 ECMAScript의 차기 버전들에서 정의 될 문법을 금지한다. 
Strict mode의 반대말은 Standard( or sloppy) mode 라고 부른다.

## 2. Strict mode 적용하기
엄격 모드는 전체 스크립트 또는 각각의 함수에 적용한다. <br/>
이것은 {} 괄호로 묶여진 블럭문에는 적용되지 않는다. <br/>
엄격모드를 전체 스크립트에 적용하기 위해, 정확한 구문 "use strict";(또는 'use strict';) 를 다른 구문 작성 전에 삽입해야한다.

### 2.1 스크립트 Strict mode
```JS
// Whole-script strict mode syntax
"use strict";
var v = "Hi!  I'm a strict mode script!";
```
전체 스크립트를 엄격모드로 사용할 때 선언한다.<br/>
하지만 비-엄격모드 스크립트들과 공존하는 상황에서는 결합되지않아 문제가 생길 수 있으므로 심사숙고 해야한다.

### 2.2 함수 Strict mode
```JS
function strict() {
  // 함수-레벨 strict mode 문법
  'use strict';
  function nested() { return "And so am I!"; }
  return "Hi!  I'm a strict mode function!  " + nested();
}
function notStrict() { return "I'm not strict."; }
```

## Summary
* 비엄격모드에서는 문법적으로 잘못되었어도 실행되던 구문을 엄격모드에서는 에러를 발생시킨다.

## Review
정확한 문법을 지키는 코드를 작성했는지 테스트하기위해 사용해봐도 괜찮을것 같다.

## Reference
* MDN - https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Strict_mode

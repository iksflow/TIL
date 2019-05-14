# 형 변환(Type Coercion) 부제 : ===를 써야하는 이유


## 1. Type Coercion 이란?
자바스크립트는 형이 다른 요소와의 연산, 비교를 할 때 강제적으로 형 변환(Conversion)을 해서 처리한다. <br/>
이를 Type Coercion 이라고 한다.
* 자바스크립트는 왼쪽에서 오른쪽으로 읽기 때문에 형 변환은 비교구문에서 왼쪽의 데이터 타입에 맞춰서 이루어진다.
``` JavaScript
console.log(10 + true);   // 11  true는 1로 변환이 된다
console.log(10 + false);  // 10  false는 0로 변환이 된다
console.log(10 * false);  // 0   10 * 0 이므로...

```
* 더하기(+) 연산자는 Loaded Operator라고 하는데, 예외적으로 String과의 연산에서 문자열로 처리해버린다.
e.g 
``` JavaScript
console.log(123 + "hello");   // 123hello
console.log(10 + 20 + "hello");   // 30hello
console.log(10 - "1");   // 9 빼기 연산에서는 해당이 없다.
```
* "", 0, NaN, undefined, null 은 false로 처리된다.
``` JavaScript
console.log("" == true);   // false    "" 빈문자열은 제로바이트 이기 때문에 0과 같다. 따라서 false.
console.log(0 == true);   // false
console.log(NaN == true);   // false
console.log(undefined == true);   // false
console.log(null == true);   // false
``` 

* ==이 boolean을 만나면 숫자로 변환한다.
``` JavaScript
console.log("1" == 1);   // true
console.log("true" == true);   // false ==을 만나서 "true"는 NaN, true 1로 변환된다. 따라서 false가 된다.
console.log(NaN == 1);  // 위 코드는 이렇게 해석되는것과 같다.
```

## 2. 자바스크립트의 ==, ===의 차이
== 와 === 의 차이는 Type Coercion을 발생시키냐 아니냐의 차이가 있다.

## Summary
Type Coercion의 규칙을 보면 외우기 복잡하고 머리가 아프다. <br/>
코드가 복잡해질수록 이런 이유로 발생하는 버그에 대해서는 정말 찾기가 어려울것이다. <br/>
결론은 == 보다 ===를 사용하면 위와 같은 복잡한 규칙을 피해서 의도한 대로 코딩하기 쉽다.

## Review 
이미 알고있는 내용이지만 다시한번 짚어보니 머리속에 더 내용이 확실히 기억되는 느낌이든다.

## Reference
Nomad Coders - https://www.youtube.com/watch?v=dIIQmSsg0SI

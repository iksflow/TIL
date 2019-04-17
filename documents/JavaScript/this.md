# 자바스크립트의 this

## 1. 전역 컨텍스트

전역 실행 컨텍스트 (어떤 함수의 외부)에서 this는 strict mode이거나 아니여도 전역 객체를 참조한다.

```JS
console.log(this.document === document); // true

// 웹 브라우저에서 전역 객체는 window 객체이다.
console.log(this === window); // true

this.a = 37;
console.log(window.a); // 37
```

## 2. 함수 컨텍스트
* 단순 함수 호출
```JS
function f1(){
  return this;
}

f1() === window; // global object
```
이 경우, this의 값은 호출에 의해 설정되지 않는다. 이 코드는 strict mode가 아니기 때문에, this의 값은 항상 전역 객체에서 기본이 되는 객체여야 한다.

```JS
function f2(){
  "use strict"; // see strict mode
  return this;
}

f2() === undefined;
```
strict mode에서는, this의 값은 실행 컨텍스트 들어갈 때 할당되어 유지된다. 만약 정의 되지 않았다면, undefined가 유지된다. 게다가 null 또는 42 또는 "I am not this" 등  어떤 값이던 설정할 수 있다. <br/>


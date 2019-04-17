# 자바스크립트의 Object

## 1. Object 개체
모든 JavaScript 개체에 공통 기능을 제공한다.

## 2. 생성
객체 생성 방법에는 두 가지가 있다. 

### 2.1 생성자 함수를 통한 객체 생성
```JS
// 1. 생성자 함수를 통한 객체 생성
var obj = new Object(); // empty object
```
### 2.2 객체 이니셜라이저 (리터럴 표기에 의한 객체생성)
```JS
// 2. 객체 이니셜라이저 (리터럴 표기에 의한 객체생성)
var obj = {}; // empty object
```
### 2.2.1 객체 리터럴 표기법 vs JSON
객체 리터럴 표기법은 JavaScript Object Notation (JSON)과 같지 않습니다. 비슷해 보이지만, 차이가 있습니다:

* JSON은 "property": value 구문을 사용한 속성 정의만 허용합니다. 속성명은 큰 따옴표로 묶여야 하고, 정의는 단축(명)일 수 없습니다.
* JSON에서 값은 오직 문자열, 숫자, 배열, true, false, null 또는 다른 (JSON) 객체만 될 수 있습니다.
* 함수 값(위 "메서드" 참조)은 JSON에서 값에 할당될 수 없습니다.
* Date 같은 객체는 JSON.parse() 후에 문자열이 됩니다.
* JSON.parse()는 속성 계산명을 거부하고 오류가 발생됩니다.

## Reference 
* MSDN - https://msdn.microsoft.com/ko-kr/library/kb6te8d3(v=vs.94).aspx
* MDN - https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Object_initializer
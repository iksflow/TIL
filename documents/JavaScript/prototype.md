# 자바스크립트의 프로토 타입

## 1. 프로토타입의 뜻
프로토타입(Proto Type) 은 원형이라는 뜻이다. 자바스크립트에서 객체 원형을 프로토타입 이라고 칭한다.

## 2. 프로토타입을 통한 상속
```JS
function Student() {
    this.grade = 3;
    this.subject = "math";
}

var student1 = new Student();
var student2 = new Student();

console.log(student1.grade);    // 3
console.log(student1.subject);    // math

console.log(student2.grade);    // 3
console.log(student2.subject);    // math
```

## 3. 프로토타입 체인 (Prototype Chain)

```JS
// Ultra는 ultraProp을 가지고있음
function Ultra(){}
Ultra.prototype.ultraProp = true;
 
// Ultra의 생성자를 가지고있음
function Super(){}
Super.prototype = new Ultra();

// Super의 생성자를 가지고있음
function Sub(){}
Sub.prototype = new Super();

// Sub 객체를 가지고있음
var o = new Sub();
console.log(o.ultraProp);   // result : true;

```
* 객체 o는 Sub생성자를 통해 Sub객체를 갖고있다. 
* Sub는 Super의 객체를 프로토타입에 가지고있다.
* Super는 Ultra의 객체를 프로토타입에 가지고있다.
* Super는 Ultra의 ultraProp을 참조해서 값을 가지고온다.
이런 모양을 프로토타입 체인이라고한다. 

## Reference
생활코딩 - https://opentutorials.org/course/743/6573 
MDN - https://developer.mozilla.org/ko/docs/Web/JavaScript/Guide/Inheritance_and_the_prototype_chain (추가로 참고한것)
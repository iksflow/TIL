# 자바스크립트의 반복문

## 1. 자바스크립트의 반복문 종류
* for 문
* do...while 문
* while 문
* 레이블 문
* break 문
* continue 문
* for...in 문
* for...of 문

## 2. 반복문의 사용법

* for 문
```JS
// form
for ([초기문]; [조건문]; [증감문]) {
    문장
}

// example
for (var i = 0; i < 5; i++) {
    console.log("hello");
}

```

* do...while 문
```JS
// form
do {
    문장
}
while (조건문);

// example
var i = 0;
do {
   i++;
} while (i < 5)
```

* while 문
```JS
// form
while (조건문) {

}

// example
var i = 0;
while (i < 5) {
    i++;
}
```

* 레이블 문
```JS
// form
label :
    문장

// example
markLoop:
while (theMark == true) {
    console.log("hello");
}    
```

## Reference
* MDN - https://developer.mozilla.org/ko/docs/Web/JavaScript/Guide/Loops_and_iteration
# 같음 비교

## 1. 추상적(abstract) 같음 비교 ( == )
느슨하게 비교하는 방식이다. 값만 비교하고 자료형은 신경쓰지 않는다.
```JS
var a = "1";    // string
var b = 1;      // number
a == b // true

```

## 2. 엄격한(strict) 같음 비교 ( === )
값과 자료형 또한 같아야만 true를 반환한다.

```JS
var a = "1";    // string
var b = 1;      // number
a === b // false

```


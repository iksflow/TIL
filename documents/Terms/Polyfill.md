# 폴리필(Polyfill)

## 1. 폴리필이란?

폴리필(polyfill)은 웹 개발에서 기능을 지원하지 않는 웹 브라우저 상의 기능을 구현하는 코드를 뜻한다.  
기능을 지원하지 않는 웹 브라우저에서 원하는 기능을 구현할 수 있으나, 폴리필 플러그인 로드 때문에 시간과 트래픽이 늘어나고, 브라우저별 기능을 추가하는 것 때문에 코드가 매우 길어지고, 성능이 많이 저하된다는 단점이 있다.  
예를 들어, IE 11버전에서는 ES6 문법을 지원하지 않지만 폴리필로 동일한 로직의 코드를 넣어서 사용할 수 있게끔 할 수 있다.  

## 2. 폴리필 사용 예시
아래와 같은 코드를 단순히 삽입하기만 하면 된다.  
findIndex라는 함수는 ES6에서 자바스크립트 Array객체의 prototype에 새롭게 추가되었다.  
ES6버전을 지원하지않는 IE에서는 prototype에 findIndex라는 함수가 존재하지 않기때문에 아래의 폴리필코드를 이용해 prototype에 함수를 추가해 주는것으로 사용을 가능하게한다.
그러면 객체 프로퍼티에 폴리필로 작성한 로직이 들어가기 때문에 기존 코드를 그냥 둔채로 제 기능을 하게끔 할 수 있다.  
MDN의 기능페이지에 가보면 Polyfill 구현코드를 작성해놓은것을 확인해 볼 수 있다.

```JavaScript
// https://tc39.github.io/ecma262/#sec-array.prototype.findindex
if (!Array.prototype.findIndex) {
  Object.defineProperty(Array.prototype, 'findIndex', {
    value: function(predicate) {
     // 1. Let O be ? ToObject(this value).
      if (this == null) {
        throw new TypeError('"this" is null or not defined');
      }

      var o = Object(this);

      // 2. Let len be ? ToLength(? Get(O, "length")).
      var len = o.length >>> 0;

      // 3. If IsCallable(predicate) is false, throw a TypeError exception.
      if (typeof predicate !== 'function') {
        throw new TypeError('predicate must be a function');
      }

      // 4. If thisArg was supplied, let T be thisArg; else let T be undefined.
      var thisArg = arguments[1];

      // 5. Let k be 0.
      var k = 0;

      // 6. Repeat, while k < len
      while (k < len) {
        // a. Let Pk be ! ToString(k).
        // b. Let kValue be ? Get(O, Pk).
        // c. Let testResult be ToBoolean(? Call(predicate, T, « kValue, k, O »)).
        // d. If testResult is true, return k.
        var kValue = o[k];
        if (predicate.call(thisArg, kValue, k, o)) {
          return k;
        }
        // e. Increase k by 1.
        k++;
      }

      // 7. Return -1.
      return -1;
    },
    configurable: true,
    writable: true
  });
}
```

## Reference
MDN - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/findIndex

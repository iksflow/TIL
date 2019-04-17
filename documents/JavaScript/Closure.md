# 클로저 (Closure)

## 1. 클로저란 ?
내부함수에서 외부함수의 외부함수의 호출 이후에 지역변수에 접근하는것이 가능한것을 의미함.

## 2. 어휘적 유효범위 (Lexical scoping)
```JS
function init() {
    var name = "Mozilla";   // name은 init에 의해 생성된 지역변수다
    function displayName() {    // displayName() 은 내부 함수이며, 클로저다
        alert(name);    // 부모 함수에서 선언된 변수를 사용한다
    }
    displayName();
}
```
init()은 지역 변수 name과 함수 displayName()을 생성한다. <br/>
displayName()은 init() 안에 정의된 내부 함수이며 init() 함수 본문에서만 사용할 수 있다. displayName()는 자신의 지역 변수가 없다. 
어떻든 내부 함수는 외부 함수에 접근할 권한을 가지고 있기  때문에 displayName()는 부모 함수 init()에서 선언된 변수 name에 접근할 수 있다.

## 3. 클로저 예시
```JS
1. makeFunc
function makeFunc() {
  var name = "Mozilla";
  function displayName() {
    alert(name);
  }
  return displayName;
}

var myFunc = makeFunc();
myFunc();   // result: Mozilla

2. makeAdder
function makeAdder(x) {
  return function(y) {
    return x + y;
  };
}

var add5 = makeAdder(5);
var add10 = makeAdder(10);

/ /같은 함수이지만 서로 가지고있는 지역변수의 값이 다르다.
console.log(add5(2));  // 7
console.log(add10(2)); // 12
```

## 4. 클로저를 이용해서 프라이빗 메소드(private method) 흉내내기
자바와 같은 몇몇 언어들은 메소드를 프라이빗으로 선언할 수 있는 기능을 제공한다. 이는 같은 클래스 내부의 다른 메소드에서만 그 메소드들을 호출할 수 있다는 의미이다.

자바스크립트는 태생적으로는 이런 방법을 제공하지 않지만 클로저를 이용하여 프라이빗 메소드를 흉내는 것이 가능하다. 프라이빗 메소드는 코드에 제한적인 접근만을 허용한다는 점 뿐만 아니라 전역 네임 스페이스를 관리하는 강력한 방법을 제공하여 불필요한 메소드가 공용 인터페이스를 혼란스럽게 만들지 않도록 한다.

아래 코드는 프라이빗 함수와 변수에 접근하는 퍼블릭 함수를 정의하기 위해 클로저를 사용하는 방법을 보여준다. 이렇게 클로저를 사용하는 것을 모듈 패턴이라 한다.
```JS
var counter = (function() {
  var privateCounter = 0;
  function changeBy(val) {
    privateCounter += val;
  }
  return {
    increment: function() {
      changeBy(1);
    },
    decrement: function() {
      changeBy(-1);
    },
    value: function() {
      return privateCounter;
    }
  };   
})();

// 함수를 호출할 때 마다 기억하고있던 변수의 값을 호출해내는것을 확인할 수 있다.
console.log(counter.value()); // logs 0
counter.increment();
counter.increment();
console.log(counter.value()); // logs 2
counter.decrement();
console.log(counter.value()); // logs 1
```

## Summary
* 클로저는 외부함수에 정의된 내부함수가 외부함수의 범위에 있는 지역변수를 저장하고있는 성질을 뜻함.

## Review
* 이것을 이용해 함수를 잘 설계하면 파라미터값의 변경만으로 작동하는 중복없는 함수를 만들어내기 편할 것 같다.

## Reference
* MDN - https://developer.mozilla.org/ko/docs/Web/JavaScript/Guide/Closures
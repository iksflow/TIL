# 콜백함수 (Callback Function)
* 직접 호출하는것이 아닌 호출 당하는 함수.

```JS
var a = [3, 1, 2];
a.sort();
// result a = [ 1, 2, 3 ]



var cbTest = function(callback) {
    callback();
}
var callBackFunction = function() {
    console.log("I am callback function");
}
cbTest(callBackFunction);

// result "I am callback function"
// callBackFunction 은 cbTest 라는 함수를 통해 호출된다.
// 직접적으로 호출해서 사용하는게 아닌 다른 요소로부터 호출당하는 함수를 콜백함수라고 한다.

```

## Reference
* 생활코딩 - https://opentutorials.org/course/2136/11861
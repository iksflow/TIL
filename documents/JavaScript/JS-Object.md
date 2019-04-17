# 자바스크립트 객체

## 자바스크립트에서의 객체
자바스크립트에서의 객체는 다음과같이 표현한다.
```JS

// 1. 생성자를 이용한 객체 생성 방식
function obj( userid, service ) {
    this.userid = userid;
    this.service = service;
    this.getUserid = function() {
        return this.userid;
    }
}

// 2. 리터럴을 이용한 객체 생성 방식
var obj = {};
// 2-1. 객체를 프로퍼티와 함께 생성하는 방식
var obj2 = {
    userid : "kignues",
    service : "GitHub",
    getUserid : function() {
        return this.userid;
    } 
}
```

## Summary
자바스크립트에서는 클래스는 없지만 클래스의 인스턴스 생성과 비슷한 모양으로 객체를 생성한다.

## Review
자바스크립트에서는 클래스가 없다는 사실을 다시한번 상기하게되었다.<br/>
사실 코딩하면서 이런것은 별로 신경쓰지 않았는데 기초개념을 다시 공부하니 잊고 지내던것이 많은것같다..

## Reference
* MSDN - https://msdn.microsoft.com/ko-kr/library/kb6te8d3(v=vs.94).aspx

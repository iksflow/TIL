# map, filter 함수형으로 전환하기

```JS
// 데이터 셋
var users = [
    {id: 1, name: "A", age: "25"},
    {id: 2, name: "B", age: "27"},
    {id: 3, name: "C", age: "34"},
    {id: 4, name: "D", age: "21"}
];

// 명령형 코드
var temp_users = [];

// 1. 30세 이상인 유저 거르기
for( var i=0; i<users.length; i++) {
    if( users[i].age >= 40 ) {
        temp_users.push(users[i]);
    }
}

// 2. 30세 이상인 유저의 이름 구하기

var names = [];
for( var i=0; i < temp_users.length; i++ ) {
    names.push(temp_users[i].name);
}



```




## Summary

## Review


## Reference
* 인프런(유인동 강사님) - https://www.inflearn.com/course-status-2/

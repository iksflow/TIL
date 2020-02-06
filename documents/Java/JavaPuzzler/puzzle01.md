# 1번째 퍼즐 - 홀수 확인

문제 : 다음은 매개변수가 홀수인지 확인하는 메서드입니다. 제대로 작동할까요?

``` Java
public static boolean isOdd(int i) {
   	return i % 2 == 1;
}
```

코드의 의도는 매개변수로 전달된 값이  홀수인지 판단하기 위한것으로 보인다.

어떤 수에 대해서 홀수라고 정의하는 방법은 간단한데, 2로 나누었을때 나머지가 1인 수를 홀수라고 한다. 다르게 말하면 '2로 나누었을 때  나머지가 0이 아닌 수' 라고 말할 수도 있다.

일반적인 경우라면 문제 없이 홀수를 검증해낼 수 있는 함수처럼 보인다.
하지만 항상 예외는 있는법...
함수에 매개변수로 음수값이 전달이 되는경우에는 어떻게 동작할까?
예를 들어 -3 % 2 와 같은 연산이라면 어떤값이 나오게될까?
아래 코드를 실행해서  어떤결과가 나오는지 확인해 보았다.
```Java
public class Main {

    public static void main(String[] args) {
        System.out.println(isOdd(-3));
        System.out.println("-3 % 2 result: " + (-3 % 2));
        System.out.println("3 % -2 result: " + (3 % -2));
        System.out.println("-3 % -2 result: " + (-3 % -2));
        System.out.println("-3 / 2 result: " + (-3 / 2));
        System.out.println("3 / -2 result: " + (3 / -2));
        System.out.println("-3 / -2 result: " + (-3 / -2));
    }
    
    public static boolean isOdd(int i) {
        return i % 2 == 1; 
    }
}
```    
```
[console]
false
-3 % 2 result: -1
3 % -2 result: 1
-3 % -2 result: -1
-3 / 2 result: -1
3 / -2 result: -1
-3 / -2 result: 1
```
위 결과로부터 % 연산자는 연산자의 왼쪽에 위치한 수의 부호를 따라간다는것을 알 수 있다.
따라서 -3은 홀수임에도 isOdd 함수의 검사 조건에서 false가 나오기때문에 홀수가 아니라고 취급이 되어버린다.
혹시나해서 '/' 연산자도 테스트 해보았는데 음수와 양수 사이의 일반적인 연산방법을 따라간다.

그럼 홀수를 검출해내기위해 검사조건을 수정해 보자.
```Java
// wrong case
public static boolean isOdd(int i) {
    return i % 2 == 1; 
}

// 1. 음수인 경우 -1을 리턴하므로, 1, -1을 반환하는지 모두 검사하는 방법.
public static boolean isOdd2(int i) {
    return (i % 2 == 1 || i % 2 == -1); 
}

// 2. 나머지가 0인지 아닌지 검사하는 방법.
public static boolean isOdd3(int i) {
    return i % 2 != 0; 
}
```

딱봐도 1번보단 2번이 간결하게 생겼다.

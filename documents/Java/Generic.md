# 제네릭 (Generic)

## 1. 제네릭을 사용할 때 얻는 이점

* 컴파일 시 강한 타입체크를 할 수 있다.
* 타입 변환을 할 필요가 없다.
``` Java
public class Box {
  Object box;
}

```

## 2. 제네릭 타입(class<T>, interface<T>)
제네릭 타입은 타입을 파라미터로 가지는 클래스와 인터페이스를 말한다.  
표기 방법은 아래 예시처럼 클래스, 인터페이스 이름 뒤에 "<>" 부호가 붙고, 사이에 타입 파라미터가 존재한다.  
``` Java
public class 클래스명<T> { ... }
public interface 클래스명<T> { ... }
```

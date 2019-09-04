# 람다식(Lambda Expression)

## 1. 람다식이란?
람다식은 익명함수 생성을 위해서 사용되는 식이다.  
Java, JS, Python 등 람다표현식을 지원하는 모든 언어에서 사용 가능하며, 객체 지향 언어보다는 함수 지향 언어에 가깝다.  
람다식은 매개변수를 가진 코드블록 모양이지만, 런타임에는 익명 구현 객체를 생성한다.  
```
람다식 -> 매개 변수를 가진 코드 블록 -> 익명 구현 객체
```



## 2. 어떤것이 좋은가?
* 코드가 간결해진다.
* 루프, 탐색하기 용이하다. 특히 필터링 작업이 필요한 경우 유용하다.
## 3. 람다식의 작성 방법
람다식은 함수를 정의하는것 처럼 작성한다.  아래 예시는 Runnable은 함수형 인터페이스이기 때문에 람다식을 통해서 바로 익명객체 생성이 가능한 경우이다.
Runnable 뿐만 아니라 정의된 추상 메소드가 1개뿐인 인터페이스에는 모두 적용이 가능하다.
``` Java
(매개변수) -> {...코드...};
// e.g) 
Runnable runnable = () -> { System.out.println("Hello Lambda"};
```
### 함수형 인터페이스란?
인터페이스의 정의부분에 @FunctionalInterface 라는 어노테이션을 추가 하게되면 함수형 인터페이스를 만들 수 있다.  
실제로 Runnable의 경우에도 어노테이션이 달려있다.  
함수형 어노테이션으로 정의된 인터페이스는 추상 메소드를 하나만 가질 수 있다. 만약 2개이상 정의하게 될 경우 컴파일 에러가 나오게 된다.  
어노테이션을 붙이지 않은 추상 메소드 1개짜리 인터페이스와 동작하는것은 같지만, 내가 의도한 바를 명확히 하려면 어노테이션을 쓰는것이 좋다는 생각이 든다.

``` Java
public interface MyNormalInterface {
	public int sum(int x, int y);
	// 추가로 추상 메소드를 정의해도 컴파일 에러가 나지 않는다. 그러나 람다식 정의부분에서 컴파일 에러가 발생한다.
  	// public int minus(int x, int y);  
}
```
``` Java
@FunctionalInterface
public interface MyFunctionalInterface {
	public int sum(int x, int y);
	// 추가로 추상 메소드를 정의하게되면, 이 메소드는 함수형 인터페이스가 아니다 라는 컴파일 에러가 발생한다.
  	// public int minus(int x, int y);  
}
```
``` Java
public class Example {
	public static void main(String[] args) {
    MyNormalInterface mni = (a, b) -> a + b; 
		MyFunctionalInterface mfi = (a, b) -> a + b;
			
		System.out.println("Normal:: " + mni.sum(1, 3));
		System.out.println("Functional:: " + mfi.sum(1, 3));
	}
}
```
```
Normal:: 4
Functional:: 4
```

## 3. 스트림
List 를 스트림으로 만든 다음 람다 메소드를 사용가능하다.
## 4. 람다식 메소드
* forEach
``` Java

```
* 

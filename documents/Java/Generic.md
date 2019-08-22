# 제네릭 (Generic)

## 1. 제네릭을 사용할 때 얻는 이점

* 컴파일 시 강한 타입체크를 할 수 있다.
* 타입 변환을 할 필요가 없다.

### Non Generic 클래스
제네릭 타입을 사용하지 않는 경우 아래 예시처럼 형변환을 계속해서 해줘야 하는 문제가 있다. (set: Integer -> Object, get: Object -> Integer)  
``` Java
// Generic 미사용
public class Box {
  private Object item;

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}
}

public class GenericPracticeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Box box = new Box();
		Integer item = 6;
		box.setItem(item);
		Integer result = (Integer)box.getItem();
	}

}
```
### Generic 클래스
형변환을 안하게 되니 코드가 훨씬 간결해졌다.
``` Java
public class BoxUsingGeneric<T> {
	private T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
}
public class GenericPracticeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoxUsingGeneric<Integer> box = new BoxUsingGeneric<Integer>();
		Integer item = 6;
		box.setItem(item);
		Integer result = box.getItem();
	}
}

```

## 2. 제네릭 타입(class<T>, interface<T>)
제네릭 타입은 타입을 파라미터로 가지는 클래스와 인터페이스를 말한다.  
표기 방법은 아래 예시처럼 클래스, 인터페이스 이름 뒤에 "<>" 부호가 붙고, 사이에 타입 파라미터가 존재한다.  
``` Java
public class 클래스명<T> { ... }
public interface 클래스명<T> { ... }
```

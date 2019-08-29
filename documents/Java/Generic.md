# 제네릭 (Generic)

## 1. 제네릭을 사용할 때 얻는 이점

* 컴파일 시 강한 타입체크를 할 수 있다.
* 타입 변환을 할 필요가 없다.

### Non-Generic 클래스
제네릭 타입을 사용하지 않는 경우 아래 예시처럼 형변환을 계속해서 해줘야 하는 문제가 있다. (set: Integer -> Object, get: Object -> Integer)  
``` Java
// Box.java
public class Box {
  private Object item;

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}
}

// GenericPracticeMain.java
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
// BoxUsingGeneric.java
public class BoxUsingGeneric<T> {
	private T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
}

// GenericPracticeMain.java
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
	
## 3. 제네릭 메소드
<제네릭타입 파라미터> 리턴타입 메소드명(파라미터) 의 규칙으로 생성한다.  
제네릭타입을 파라미터로 사용하려면 앞의 제네릭타입 파라미터 정의부분(public 바로 뒤)에 사용하려는 제네릭타입이 정의되어 있어야 한다.  
``` Java
public class Util {
	public <T, Q> BoxUsingGeneric<T> boxing(T t, Q q, String type) {
		BoxUsingGeneric<T> box = new BoxUsingGeneric<T>();
		BoxUsingGeneric<Q> box2 = new BoxUsingGeneric<Q>();
		box.setItem(t);
		return box;
	}
}

```
## 4. 제한된 타입파라미터
타입 파라미터를 사용할 때, 특정한 속성의 데이터만 받아야 하는 경우가 있다.  
예를 들면 Integer, Double등의 숫자값만 처리하는 메소드로 만들고 싶은 경우 String은 제한해야한다.  
이런 경우 extends 키워드를 통해 타입파라미터를 제한할 수 있다.  
상위 클래스, 인터페이스 모두 가능하다.
``` Java
public <T extends 상위타입> 리턴타입 메소드(매개변수, ...) { ... }

e.g.) public <T extends Number> int compare(T t1, T t2) { ... }
```
숫자만 받고 싶은 경우 모든 숫자의 상위클래스인 Number를 상위타입으로 지정하면 된다.  
compare 같은 경우 compare("a", "b") 처럼 사용하면 syntax error가 발생한다.  

다만 extends를 사용해서 입력받을 타입파라미터를 제한하는 경우 제약이 걸리는데, 위의 경우 Number를 상위타입으로 지정했기 때문에, Number 클래스에 존재하는 메소드와 멤버변수에만 접근이 가능하다.  
Integer에만 존재하는 compareTo같은 메소드는 호출할 수 없다.

## 5. 와일드카드 타입 (<?>, <? extends 상위타입>, <? super 하위타입>)
제한된 타입파라미터처럼 특정 타입만 받고자 할 때 사용한다. 차이점은 범위를 지정하는것이 가능한 점이다.  
<?> 와일드카드만 사용하는 경우 모든 타입을 허용하겠다는 의미이다.  
extends, super를 사용하는 경우에는 뒤의 타입을 기준으로 제한적 허용을 하겠다는 의미이다.  
extends를 사용하는 경우 기준타입 또는 기준타입을 상속하는 하위 클래스만 허용한다.  
super를 사용하는 경우 기준타입 또는 기준타입의 상위 클래스만 허용한다.  

``` Java
예시코드 삽입
```
## 6. 제네릭 타입의 상속과 구현

제네릭 타입도 상위클래스가 될 수 있다.  
다만, 상속하는 클래스를 명시할 때, 상위클래스의 제네릭 타입을 같이 명시해 줘야 한다.  
명시하지 않더라도 하위클래스 생성에는 문제가 없지만, 값을 할당하려고 할 때 멤버변수의 타입이 정해지지 않은 상태이므로 전부 Object 타입으로 받아버리게 된다.  
그래서 타입안전성 관련한 경고문구가 계속해서 나오게 되고, 값을 저장할 때, 형변환을 해줘야 해서 제네릭을 사용하는 의미가 없어지고, 좋지 않은 코드가 되어버린다.  
* 올바르지 못한 사용법
``` Java
public class Product<T, M> {
	
	private T kind;
	private M model;
	private ArrayList<T> kindList; 
	
	public T getKind() {
		return kind;
	}
	public void setKind(T kind) {
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
	public ArrayList<T> getKindList() {
		return kindList;
	}
	public void setKindList(ArrayList<T> kindList) {
		this.kindList = kindList;
	}
}

public class ChildProduct extends Product{

}

public class ProductExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildProduct cp = new ChildProduct();
		int a = 123;
		double b = 1.56;
		cp.setKindList(new ArrayList<Integer>());
		cp.getKindList().add(a);
		cp.getKindList().add(b);
		Integer temp1 = (Integer)cp.getKindList().get(0);
		Double temp2 = (Double)cp.getKindList().get(1);
	}
}
```

* 올바른 상속 예시
``` Java
public class Product<T, M> {
	
	private T kind;
	private M model;
	
	public T getKind() {
		return kind;
	}
	public void setKind(T kind) {
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
}
```
``` Java
public class ChildProduct<T, M, C> extends Product<T, M>{
	private C company;

	public C getCompany() {
		return company;
	}

	public void setCompany(C company) {
		this.company = company;
	}
}
```


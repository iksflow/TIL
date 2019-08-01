# 스레드(Thread)
코드의 실행 흐름을 의미한다.    

## 1. 프로세스와 스레드?
프로세스(Process): 실행 중인 하나의 애플리케이션(프로그램)을 의미한다.  
스레드(Thread): 애플리케이션 내부의 하나의 실행 흐름을 의미한다.

## 1.1. 멀티태스킹
## 2. 스레드의 생성
스레드를 생성하는 방법에는 2가지가 있다.  
## 2.1. Thread 클래스로 직접 생성
첫번째 방법은 Thread 클래스의 생성자를 통해 생성하는 방법이다.  
Thread 클래스의 생성자는 Runnable인터페이스를 구현한 객체를 매개변수로 받을 수 있는데, Runnable을 구현객체의 run메소드에 스레드가 실행할 코드가 담을 수 있기 때문이다.  
Runnable 매개변수를 전달하지 않더라도 Thread 인스턴스 생성에 문제될 것은 없지만, 실행할 코드가 빠진 모양이 되어버리기 때문에 의미가 없다.  
Runnable 매개변수를 전달하는 방법에는 3가지 방법을 활용할 수 있다. 
앞서 소개한 Runnable 클래스를 활용한 방법과 익명객체를 전달하는 방법 그리고 람다식을 활용해 함수형 표현으로 사용하는 방법이 있다.  
아래 코드를 보면 이해가 쉬울것이다.

### 2.1.1. Thread 생성자에 Runnable인터페이스를 구현한 객체 전달
Runnable 인터페이스를 구현한 클래스를 사용하는 방법이다.  
클래스를 따로 정의해야하는 번거로움이 있지만, 네이밍 룰을 정해놓고 잘 지키고 있는상황이라면, 클래스 이름만으로도 스레드가 무슨 일을 처리할지 예상할 수 있기때문에 가독성 측면에서는 좋을것이다.  
반면에, 다음에 소개될 2개의 방법은 주석으로 설명을 달아놓지 않는이상 작성된 코드를 확인해야 로직에 대한 이해를 할 수 있다.  
``` Java
// Task.class
public class Task implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("I am an instance of Task that implements Runnable Interface.");
		
	}

}

// main
public class RunnableMain {

	public static void main(String[] args) {
		Thread threadOne = new Thread(new Task());
				
		threadOne.start();
	}

}
// console
I am an instance of Task that implements Runnable Interface.
```
### 2.1.2. Thread 생성자에 Runnable 익명객체 전달
위의 예시 처럼 Runnable을 구현한 클래스를 만들어도 괜찮지만, 실제로 전달할 작업이 복잡하지 않은 경우에는 아래처럼 간단하게 익명함수로 전달하는것도 코드를 아끼는 괜찮은 방법이다.  
``` Java
// main
public class RunnableMain {

	public static void main(String[] args) {
		Thread threadTwo = new Thread(new Runnable() {
			public void run() {
				System.out.println("I am anonymous instance.");
			}
		});
		Thread threadThree = new Thread(()->{
			System.out.println("using lamda expression.");
		}); 
		
		threadOne.start();
		threadTwo.start();
		threadThree.start();
	}

}


```
### 2.1.3. 람다식을 활용한 함수형태의 전달
Runnable 인터페이스는 run() 메소드 하나만 가지고있는 형태이기 때문에 함수적 인터페이스이다.  
아래 코드처럼 람다식으로 표현한 함수를 생성자에 전달해서 생성할 수 있다.
``` Java
// main
public class RunnableMain {

	public static void main(String[] args) {
		Thread threadThree = new Thread(()->{
			System.out.println("using lamda expression.");
		}); 
		
		threadThree.start();
	}

}

// console
using lamda expression.
```

두번째 방법은 Thread 클래스를 상속받은 클래스를 생성해서 사용하는 방법이다.  
실행할 코드는 Thread 클래스의 run메소드를 오버라이딩 하고 안에 작성한다.  
인스턴스를 생성하고 start메소드를 통해 run의 코드를 실행한다.  

``` Java
// ThreadA.class
public class ThreadA extends Thread{

	@Override
	public void run() {
		System.out.println("I am threadA");
	}
	
}

// main
public class ThreadAMain {

	public static void main(String[] args) {
		ThreadA thread = new ThreadA();
		thread.start();
	}

}
// result
// I am threadA
```
## 동기화
동기화는 자원의 공유로인해 스레드간에 로직이 꼬이는걸 방지하기 위해 사용한다.  

``` Java
public class StudyMain {

	public static void main(String[] args) {
		Thread thread1 = new WorkerThread();
		Thread thread2 = new Thread() {
			public void run() {
				SynchroTest sync = new SynchroTest();
				sync.syncMethod(this);
			}
		};
		
		thread1.start();
		thread2.start();
	}

}

```

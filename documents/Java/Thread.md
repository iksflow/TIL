# 스레드(Thread)
코드의 실행 흐름을 의미한다.    

## 1. 프로세스와 스레드?
프로세스(Process): 실행 중인 하나의 애플리케이션(프로그램)을 의미한다.  
스레드(Thread): 애플리케이션 내부의 하나의 실행 흐름을 의미한다.

### 1.1. 멀티태스킹


## 2. 스레드의 생성
스레드를 생성하는 방법에는 2가지가 있다.  
### 2.1. Thread 클래스로 직접 생성
첫번째 방법은 Thread 클래스의 생성자를 통해 생성하는 방법이다.  
Thread 클래스의 생성자는 Runnable인터페이스를 구현한 객체를 매개변수로 받을 수 있는데, Runnable을 구현객체의 run메소드에 스레드가 실행할 코드가 담을 수 있기 때문이다.  
Runnable 매개변수를 전달하지 않더라도 Thread 인스턴스 생성에 문제될 것은 없지만, 실행할 코드가 빠진 모양이 되어버리기 때문에 의미가 없다.  
Runnable 매개변수를 전달하는 방법에는 3가지 방법을 활용할 수 있다. 
앞서 소개한 Runnable 클래스를 활용한 방법과 익명객체를 전달하는 방법 그리고 람다식을 활용해 함수형 표현으로 사용하는 방법이 있다.  
아래 코드를 보면 이해가 쉬울것이다.

#### 2.1.1. Thread 생성자에 Runnable인터페이스를 구현한 객체 전달
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
#### 2.1.2. Thread 생성자에 Runnable 익명객체 전달
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
#### 2.1.3. 람다식을 활용한 함수형태의 전달
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

### 2.2. Thread 클래스로 직접 생성
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
### 2.3. Thread의 이름 설정하기(setName, getName)
Thread가 여러개 생기다보면 어떤 스레드가 실행중인지 확인하고 싶을 때가 있다.  
이런 경우 디폴트로 생성해주는 스레드 넘버링 이름을 그대로 사용한다면, 참 피곤한 일이 여럿 발생할지도 모른다.  
setName을 사용하면 내가 스레드에 이름을 설정할 수 있고, getName을 활용하면 내가 설정한 이름을 불러올 수 있다.  
스레드가 작업하는 내용에 따라 네이밍을 직관적으로 해둔다면 유용할 것으로 생각한다.  
아래 코드처럼 익명객체로 Thread를 구현하는 경우 자기 객체를 this를 통해 참조할 수 없다.  
이런 경우에는 Thread의 정적 메소드인 currentThread()를 통해 현재 실행되는 Thread를 참조할 수 있다.
``` Java

public class RunnableMain {

	public static void main(String[] args) {
		Thread BeepThread = new Thread(new Runnable() {
			public void run() {
				for(int i=0; i<5; i++) {
					System.out.printf("%s Compelete\n", Thread.currentThread().getName());		
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread BellThread = new Thread(new Runnable() {
			public void run() {
				
				for(int i=0; i<5; i++) {
					System.out.printf("%s Compelete\n", Thread.currentThread().getName());	
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}				
				
			}
		});
		BeepThread.setName("Beeper");
		BellThread.setName("Bell");
		
		BeepThread.start();
		BellThread.start();
	}

}
```
### 2.4. start() 와 run() 의 차이
start()는 Thread의 메소드이고 run()을 실행하는 역할을 한다.  
run()의 경우 Runnable의 메소드이다.  
너무 당연한 소리같지만 두가지는 차이점이 존재한다.  
우선 동일한 부분은 start(), run() 모두 run() 내부에 정의된 코드를 실행한다는 부분이다.  
다른 부분은 실행하는 주체인 스레드가 차이가 있다는것이다.  
run()을 직접 호출하게되면 실행 주체는 main스레드가 되고, start()를 통해 호출하는 방식은 실행 주체가 정의 start()를 호출하는 스레드가 된다.
아래 예제 코드를 보자.
``` Java
public class RunnableExam implements Runnable{
	public void run() {
		// 실행중인 스레드의 이름을 출력한다.
		System.out.println("running thread name::" + Thread.currentThread().getName());
	}
}

public class DiffOfStartAndRunExample {

	public static void main(String[] args) {
		RunnableExam runExam = new RunnableExam();
		Thread thread1 = new Thread(runExam);
		thread1.setName("Thread One");
		
		thread1.start();
		thread1.run();
	}

}
```
```
<result>
running thread name::main
running thread name::Thread One
```
결과에서 확인할 수 있듯이, 서로 실행하는 주체가 다르다.

## 스레드의 우선순위
멀티스레드는 동시성(Concurrency) 또는 병렬성(Parallelism)으로 실행된다.  
동시성은 하나의 CPU에서 여러개의 스레드를 실행할 때 여러개의 스레드를 조금씩 번갈아가며 실행하는 성질이다.  
처리하는 속도가 워낙 빠르기에 병렬적으로 처리되는것 같아 보이지만, 실제로는 번갈아서 작업중인것이다.  
병렬성은 각각의 CPU에서 스레드를 실행하는 성질이다.  
예를 들어 듀얼코어CPU인 경우에 실행해야할 스레드가 2개 있다면 각각의 코어에서 하나씩 스레드를 맡아서 처리하면 된다.  
그런데 스레드가 3개로 늘어난다면? 적어도 하나의 CPU는 동시성을 띄는 작업을 수행하게 된다.  
예시 처럼 스레드가 CPU의 개수보다 많아지면 자바는 스레드 스케줄링을 통해 스레드 실행을 관리하게 된다.

### 스레드 스케줄링
자바의 스레드 스케줄링은 우선순위(Priority) 방식과 순환 할당(Round-Robin) 방식을 사용한다.  
우선순위 방식은 더 높은 우선순위를 가진 스레드가 많이 실행되도록 계획하는 방식이다.  
순환 할당 방식은 시간 할당량을 정해서 하나의 스레드를 정해진 시간만큼 실행하고 다시 다른 스레드를 실행하는 방식이다.  
순환 할당 방식은 자바 가상머신에 의해 제어되기 때문에 코드로 제어하는것이 불가능하다. 
그렇다면 특정 스레드를 더 우선적으로 처리하고 싶을때는 어떻게 해야할까?  
바로 setPriority() 를 통해 스레드의 우선순위를 정해주면 된다.

``` Java
public class LoopThread extends Thread{
	
	public LoopThread(String name) {
		this.setName(name);
	}
	public void run() {
		for (int i = 0; i < 2000000000; i++) {
		}
		System.out.println(Thread.currentThread().getName());
	}
}


public class SetPriorityExam {

	public static void main(String[] args) {
		
		for (int i = 1; i < 10; i++) {
			Thread thread = new LoopThread("Thread" + i);
			if (i == 9) {
				thread.setPriority(Thread.MAX_PRIORITY);
			} else {
				thread.setPriority(Thread.MIN_PRIORITY);
			}
			thread.start();
		}
	}

}

```
```
<Result>
Thread9
Thread2
Thread1
Thread3
Thread4
Thread5
Thread6
Thread8
Thread7
```
9번 스레드에게 MAX_PRIORITY를 주고 나머지에게는 MIN_PRIORITY를 준 다음 실행한 결과, Thread 9의 실행이 가장 먼저 끝난것을 알 수 있다.

## 3. 동기화
싱글 스레드에서는 자원을 하나의 스레드만 사용하기 때문에 자원의 상태가 다른 요인에 의해 변한다는것은 생각하기 힘들다.  
그러나 멀티 스레드를 사용하는 프로그램에서는 동일한 자원을 공유하는경우 의도치 않은 결과를 출력할 수도 있다.  
동기화는 자원의 공유로인해 스레드간에 로직이 꼬이는걸 방지하기 위해 사용한다.  
자원의 공유를 제어하고 필요한 연산이 끝날때 까지 하나의 스레드가 사용하게끔 묶어둔다.  
synchronized 키워드를 이용해서 동기화 블록, 메소드를 설정할 수 있다.

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
## 스레드의 실행상태
* notify 
스레드를 실행대기상태로 만든다
* notifyall
* yield
### 데몬(Daemon)이란?

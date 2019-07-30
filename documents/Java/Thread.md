# 스레드(Thread)
코드의 실행 흐름을 의미한다.    

## 프로세스와 스레드?
프로세스(Process): 실행 중인 하나의 애플리케이션(프로그램)을 의미한다.  
스레드(Thread): 애플리케이션 내부의 하나의 실행 흐름을 의미한다.

## 멀티태스킹

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

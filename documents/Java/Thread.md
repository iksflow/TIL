# 스레드

# 프로세스와 스레드

# 멀티태스킹

# 동기화
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

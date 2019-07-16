# Oracle DBMS 아키텍처

## 1. Oracle DBMS의 구조
Oracle DBMS는 크게 Instance와 Database로 구성된다.  
Instance와 Database는 다시 아래와 같이 분류된다.
* Instance
  * SGA
  * Background Processes
* Database
  * Data files
  * Control files
  * Redo log files

### Instance  
인스턴스는 사례, 요소, 실재 라는 사전적 의미를 가진다.  
자바에서 클래스를 인스턴스화 시킬 때 비로소 실제 메모리에 할당되어 사용 가능한상태가 되어 작동하는 것을 생각하면 된다.  
Oracle DBMS에서도 마찬가지로 디스크에 저장된 데이터들이 사용이 가능해 지려면 메모리를 할당받아야 하는데, 메모리(SGA)와 프로세스를(Background Process)를 인스턴스라고 한다.  

# 1. 유저프로세스와 서버 프로세스

## 유저프로세스
SQL을 보내는 모든 것들이다. SQL Developer, Toad, Sql 구현한 자바 앱 등등... SQL을 Send 하는것들을 칭한다.

## 서버프로세스
유저프로세스가 보낸 SQL을 처리하는 프로세스이다.
서버프로세스는 SQL을 Parsing, Excute, Fetch 하는 과정을 수행한다.

## 인스턴스


## SGA(System Global Area)
DBMS의 메모리 영역이다.


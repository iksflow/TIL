#1일차 수업내용

## 아키텍쳐와 튜닝의 상관관계
### 수업목표 : 성능 관점의 아키텍쳐 이해
* 아키텍쳐 : 환경
- DBMS 아키텍쳐 : 
- 인덱스 아키텍쳐 : 
* 튜닝


### 튜닝의 효과가 좋은것 - 구조가 Layered Architecture (계층적 아키텍쳐)와 같다.
* Design(설계) - 좋은 설계에서 좋은 SQL이 나올 수 있기 때문.
* Application - SQL을 의미
* Instance
* OS
* Hardware, Network




### 계층
* Design
* Application(SQL)
* Instance
* OS
* H/W, Network

## 성능의 책임은 누구에게?
성능의 책임은 IT 관련자 모두에게 있다. 장비문제, dbms config 문제 등등 여러가지 경우가 있기 때문.<br>
비용 대비 효율적으로 성능을 튜닝하기 가장 좋은것은 SQL이다. <br>
악성 SQL로 인해 성능저하가 발생하는 경우가 7~80%나 되기때문.<br>
*악성 SQL: 처리하는 일에 비해 H/W Resource를 많이 잡아먹는 것들.<br>
H/W Resource는 CPU, Memory, Disk, Network 등을 예로 들수 있다.<br>

## DBMS 아키텍쳐
Oracle DBMS는 크게 Incstance와 Database로 나뉜다.
Instance (H/W resource 에서의 Memory 개념)
1. SGA(Memory) 
DB의 메모리
2. Background process
실행되는 프로그램
Database (H/W resource 에서의 Disk 개념)
1. 구조화된 데이터 집합 (일반적으로 개발 시 알고있는)
2. 물리적인 File들
- 컨트롤파일 : dbms 제어정보
- 데이터파일 : 실제 저장하는 데이터
- 로그파일 : redo log file (복원 데이터)


## Shared SQL Area는 언제 비워질까 ?
: LRU 알고리즘에 의해 오래되고 잘 사용되지 않는 SQL부터 삭제한다. 
Q1)LRU 실행시점은 DBA가 정하는지 ?


## AWR


SELECT COUNT(*)
FROM SCOTT.BONUS_LARGE;


SELECT COUNT(*)
FROM V$SQL 
WHERE SQL_TEXT LIKE '%INSERT%';


SELECT executions,sql_text FROM V$SQL WHERE SQL_TEXT LIKE '%INSERT%'; 


-- OS 프로세스ID로 서버프로세스 주소값을 얻어낸다.
SELECT * FROM V$PROCESS WHERE SPID = 29968; 
SELECT ADDR FROM V$PROCESS WHERE SPID = 29968;  


-- 서버프로세스 주소값으로 SQL_ADDRESS(Shared SQL Area에 올라간 SQL의 메모리주소)를 조회한다  SQL_ID가 해시값인가요 ?


SELECT * FROM V$SESSION WHERE PADDR = '00000000671B5ED8'; 
SELECT SQL_ADDRESS,SQL_ID FROM V$SESSION WHERE PADDR = '00000000671B5ED8';


-- 메모리를 많이 갉아먹는 SQL 실행문을 SQL이 저장된 메모리주소를 찾아 추적하기
SELECT executions,sql_text FROM V$SQL WHERE ADDRESS = '0000000070219CE8';


[메모리 점유율 순위]
Server Process - 
lgwr - redo log 
Java


[실습]
1. 

2. Calc_Bonus_by_stmt_2 : createStatement를 조회된 쿼리의 row만큼 반복해서 객체를 생성함.
3. Calc_Bonus_by_stmt_3 : 


## SELECT 처리과정
DATAFILE01, 02, 03 으로 DATAFILE을 구분한다.
BLOCK도 BLOCK 번호로 각각의 BLOCK을 구분한다.
*BLOCK : DATA FILES의 (바둑판) 한칸을 의미. 크기는 2K~64K 까지 설정가능하고 DEFAULT는 8K이다.




LOGICAL READ: DATA BUFFER CACHE를 읽음.
PHYSICAL READ: DATAFILE을 읽음.


CACHE HIT: 내가 원하는 데이터가 메모리(캐시)에 있을경우
CACHE MISS: 내가 원하는 데이터가 메모리(캐시)에 없을경우. PHYSICAL READ로 간다.


LOGICAL READ -> CACHE HIT! -> FETCH -> RESPONSE
LOGICAL READ -> CACHE MISS -> PHYSICAL READ -> SERVER PROCESS가 DATA BUFFER CACHE로 올림 -> LOGICAL READ -> CACHE HIT -> FETCH -> REPONSE


성능의 측정단위 : BLOCK의 개수


*Q) 
[과제] Transaction Type의 정의에 대해서 알아오기
1. OLTP
2. DSS(Decision Support System)  의사결정지원시스템
3. DTP(Distributed) 분산처리
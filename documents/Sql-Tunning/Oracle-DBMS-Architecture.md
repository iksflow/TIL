# Oracle DBMS 아키텍처

# 1. 유저프로세스와 서버 프로세스

## 유저프로세스
SQL을 보내는 모든 것들이다. SQL Developer, Toad, Sql 구현한 자바 앱 등등... SQL을 Send 하는것들을 칭한다.

## 서버프로세스
유저프로세스가 보낸 SQL을 처리하는 프로세스이다.
서버프로세스는 SQL을 Parsing, Excute, Fetch 하는 과정을 수행한다.

## 인스턴스


## SGA(System Global Area)
DBMS의 메모리 영역이다.


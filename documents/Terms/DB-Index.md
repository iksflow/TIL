# DB Index

## 1. 의미
ORM은 객체지향 패러다임을 사용해 쿼리, 데이터조작을 할수있게끔 만들어주는 기술을 의미한다.

## 2. 예시
* Java : Hibernate
* PHP : Propel, Doctrine
* Python : Django ORM, SQLAlchemy
* C# : NHibernate, Entity Framework

## 3. 장점과 단점

### 장점
* DRY원칙 : 데이터 모델을 한 곳에서 작성하므로, 수정이나 유지보수, 코드 재사용과 같은 부분이 용이하다.
* 데이터베이스 핸들링으로부터 많은 부분이 자동화되어 처리된다.
* ORM은 MVC 코드를 작성하도록 강제하기때문에 조금 더 깔끔한 코드를 만들게끔 해준다.

### 단점
* ORM에 대해서 공부해야만하고, ORM 라이브러리는 가벼운 툴들이 아니다.
* 일반적인 경우에서의 쿼리 성능은 괜찮지만, 항상 큰 프로젝트에서는 SQL마스터의 SQL이 낫다.
* ORM은 DB를 추상화한다. 작업의 뒷편에서 무슨일이 일어나고있는지 알고있다면 괜찮겠지만, for문에서 무거운 작업을 하는것 같은 탐욕적인 문장작성을 할 수 있는 신규 개발자에게는 함정이 될 수가 있다.

## Review
데이터 영속성에 관해 조금 더 이해가 필요하다고 느꼈고, MyBatis가 ORM이라고 들었는데 사실은 SQL Mapper라고 보는것에 부족함을 많이 느꼈다. <br/>
자주 사용하는 용어인 만큼 명확한 개념정리를 시간내서 더 해봐야겠다.

## Reference
* StackOverFlow - https://stackoverflow.com/questions/1279613/what-is-an-orm-and-where-can-i-learn-more-about-it
* HeeJeong Kwon님 블로그 - https://gmlwjd9405.github.io/2018/12/25/difference-jdbc-jpa-mybatis.html
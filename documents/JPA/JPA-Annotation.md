## JPA-Annotation

### 1. JPA에서 사용하는 애너테이션
* @Entity
    - 테이블과 링크될 클래스임을 나타냄
    - 클래스의 CamelCase 네이밍을 Underscore 네이밍으로 변경한 값을 테이블 이름으로 매칭함
    - e.g)MemberAccount.java -> member_account table
* @Id
    - 해당 테이블의 PK 필드
* @GeneratedValue
    - PK생성 규칙
    - 스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 됨.
* @Column
    - 테이블의 컬럼을 나타냄. 생략하는경우 클래스의 필드는 모두 컬럼이 됨
    - 기본값 외에 변경사항이 있는경우 사용
    - e.g) VARCHAR(255) -> (500)으로 변경하는 등의 경우 사용하게됨.




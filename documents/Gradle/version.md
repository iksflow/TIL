# Gradle 7버전을 사용하면서 달라진 부분
* compile -> implementation
build.gradle파일에서 의존성을 정의할 때, dependenciesdp compile을 사용하는경우 Deprecated 라는 로그와 함께 implementation 키워드를 사용할 것을 권장한다.  
compile -> implementation  
testCompile -> testImplementation  
으로 사용하라는 식이다.
* @Query(sql~~) -> @Query(sql~~, nativeQuery = true)
nativeQuery 속성을 정해줘야 오류가 발생하지 않는다.

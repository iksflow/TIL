# React공부 (리액트를 다루는 기술)

리액트를 다루는 기술 책을 읽으며 공부 시작

# 1. 리액트란?
페이스북에서 개발한 프론트엔드 라이브러리이다.  
브라우저에 화면을 보여줄 때 DOM을 구성해 보여주고, 값을 변경할 경우에는 DOM내부 값을 변경시켜서 보여주게 되는데,  
리액트는 변경된 값을 Virtual DOM 이라는 것을 사용해 DOM에서 변경된 값만을 수정하는 식으로 동작한다.

# 2. 왜 리액트를 사용하는가?
리액트는 기존의 DOM 수정방식과 다르게 Virtual DOM을 이용하여 기존의 View를 날려버리고 새로운 View로 갈아 치우는 방식이다.  
따라서, 어느곳의 요소가 바뀌었고 그 요소까지 탐색해 들어가는 로직이 빠지게 되므로 코드가 훨씬 간결해지게 된다.

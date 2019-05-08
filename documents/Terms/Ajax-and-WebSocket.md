# Ajax와 WebSocket

# Ajax
AJAX란 비동기 자바스크립트와 XML (Asynchronous JavaScript And XML)을 말한다. 간단히 말하면, 서버와 통신하기 위해 XMLHttpRequest 객체를 사용하는 것을 말한다. JSON, XML, HTML 그리고 일반 텍스트 형식 등을 포함한 다양한 포맷을 주고 받을 수 있다. AJAX의 강력한 특징은 페이지 전체를 리프레쉬 하지 않고서도 수행 되는 "비동기성"이다. 이러한 비동기성을 통해 사용자의 Event가 있으면 전체 페이지가 아닌 일부분만을 업데이트 할 수 있게 해준다.

AJAX의 주요 두가지 특징은 아래의 작업을 할 수 있게 해줍니다.
* 페이지 새로고침 없이 서버에 요청
* 서버로부터 데이터를 받고 작업을 수행

# WebSocket
The WebSocket API is an advanced technology that makes it possible to open a two-way interactive communication session between the user's browser and a server. With this API, you can send messages to a server and receive event-driven responses without having to poll the server for a reply.
웹소켓은 진보한 기술로, 유저의 브라우저와 서버간의 양방향 상호 커뮤니케이션을 가능하게 만들어준다. 이 API를 통해서 서버에 메세지를 보내고 응답을 위해 서버에 폴링하는 일 없이 이벤트 중심의 응답을 받을 수 있다.

# Ajax와 WebSocket의 차이점

# Question
* Polling
* Long Polling
* Comet

## Reference
* AJAX MDN - https://developer.mozilla.org/ko/docs/Web/Guide/AJAX/Getting_Started
* WebSocket MDN - https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API
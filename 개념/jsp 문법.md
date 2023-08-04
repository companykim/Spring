# 서블릿
- 서블릿은 순수 자바 코드이며, HttpServelt 클래스를 상속하여 서블릿 등록에 필요한 정보를 추가하여야 한다. 또한, 서블릿 컨테이너를 통해야만 실행됨.
- <br>
- HttpServletRequest
   - 주요 메서드
     | 메서드 | 반환 예 | 설명 |
     | :--: | :--: | :--: |
     | getParameter(name) | hong1234 | name 속성으로 전달된 파라미터 값 |
     | getParameterValues(name) | {hong, kang, kim} | 동일한 name 속성으로 전달된 모든 파라미터 값 |
     | getRequestURL() | http://www.xxx.com:8080/shop/list.jsp | URL |
     | getRequestURI() | /shop/list.jsp | URL에서 스키마, 서버 이름, 포트 번호를 제외한 나머지 주소와 파라미터 |
     | getScheme() | http | http, https, FTP와 같은 프로토콜 |
     | getServerName() | www.xxx.com | 서버 이름 |
     | getServerPort() | 8080 | 서버 포트 |
     | getContextPath() | /shop | 콘텍스트 경로 |
     | getMethod() | GET | GET, POST 등의 HTTP 메서드 |
     | isSecure() | false | SSL 보안 여부, https와 같은 보안 채널의 사용 여부(true, false) |
     | getLocal() | ko_KR | 지역 정보 |
     | getProtocol() | HTTP/1.1 | 사용하는 프로토콜, 프로토콜/메이저 버전, 마이너 버전(like 영수증) |
     | getLocalAddr() | 127.0.0.1 | 서버의 로컬 IP 주소 |
     | getRemoteAddr() | 210.102.111.212 | 클라이언트 IP 주소 |
     
- HttpServletResponse
    - 서버에서 클라이언트로 전달하려는 목적을 위한 기능으로 구성된다.<br>
    서블릿은 해당 객체를 이용하여 content type, 응답 코드, 응답 메시지 등을 전송할 수 있다.
      | 메서드 | 설명 |
       | :--: | :--: |
       | sendRedirect(String location) | 클라이언트에 리다이렉트 응답을 보낸 후 특정 URL로 다시 요청하게 함 |
       | getWriter() | 클라이언트로 데이터를 보내기 위한 출력 스트림을 리턴 |
       | setContentType(String type) | 클라이언트에 전달되는 콘텐츠 타입을 지정 |
       | addCookie(Cookie cookie) | 응답에 쿠키를 추가 |
       | addHeader(String name, String value) | 헤더에 name과 value를 추가 |
       | encoreURL(String url) | 클라이언트가 쿠키를 지원하지 않을 때 세션 id를 포함한 특정 URL을 인코딩 |
       | getHeaderNames() | 현재 응답이 헤더에 포함된 name을 얻어옴 |

- 서블릿의 생명 주기
  - 서블릿 초기화: init() 메서드
  - 요청/응답: service() 메서드
  - 서블릿 종료: destory() 메서드
  - 과정
    1. 사용자 URL 요청에 따른 서블릿을 실행한다.
    2. 이때 서블릿 인스턴스가 생성되지 않았다면 인스턴스를 생성한 후 init() 메서드를 호출한다.
    3. 이미 객체가 생성되어 있는 경우라면 각 요청별로 서블릿 컨테이너에서 스레드를 생성해 서블릿의 service() 메서드를 호출한다.
    4. 사용자 요청에 따라 doGet(), doPost() 등의 메서드를 호출한다.
    5. 서블릿 컨테이너의 종료를 포함해 서블릿 변경 등 기존 서블릿을 종료해야 할 때 destory() 메서드를 호출한다.

- JSP의 특징
     - 서블릿에서 데이터 표현의 불편함을 해결하기 위해 나온 템플릿 기술의 하나
     - HTML 페이지에 자바 코드를 직접 사용한다.
     - 서블릿 컨테이너에 의해 관리되는 내장객체의 생명 주기를 이용하여 페이지 간 속성을 관리한다.
     - 커스텀 태그 기술을 사용하여 코드를 태그화(action, JSTL 등)한다.
     - EL을 통해 데이터를 표현한다. 
- JSP의 동작 과정
     1. 'hello.jsp' 소스코드를 작성하고 웹 애플리케이션을 배포한다.
     2. 클라이언트 요청에 컨테이너는 해당.jsp의 클래스 반환 여부를 확인한다.
     3. 변환되지 않았다면 "hello_jsp.java' 파일을 생성하고 .class로 컴파일한다.
     4. jspInit() 메서드를 통해 서블릿을 실행한다.
     5. _jspService() 메서드를 통해 클라이언트 요청을 처리한다.
     6. 컨테이너 종료 혹은 관리 도구에 의해 서블릿 jspDestroy() 호출로 종료된다.
 
- JSP 지시어
     -JSP 컨테이너에 해당 페이지를 어떻게 처리해야 하는지를 전달하는 내용을 담음.
     > <%@ 지시어 속성="값" %>

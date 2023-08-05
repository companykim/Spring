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
     - JSP 컨테이너에 해당 페이지를 어떻게 처리해야 하는지를 전달하는 내용을 담음.
     > <%@ 지시어 속성="값" %>
     - page 지시어
       - 현재 jsp 페이지를 컨테이너에서 처리하는데 필요한 각종 속성을 기술하기 위해 사용
         > <%@ page language="java" contentType="text/html; charset=UTF-8"
                    pageEncoding="UTF-8" import="java.util.*" error.jsp"%>
   - include 지시어(분할정복)
        - 다른 파일을 포함하는 위한 지시어로, 사용된 위치에 특정 파일을 불러온다.
           > <%@ include file="파일 위치" %>
   - taglib 지시어
        - 커스텀 태그를 사용하기 위한 지시어
             > <%@ taglib (url="태그 라이브러리 경로" 혹은 tagdir="태그 파일 경로" )
                prefix="태그 접두어" %>
     
      - 템플릿 데이터
        - JSP의 화면 구성요소
           - 스크립트
                1. <%! %> : 선언 태그
                2. <%= %> : 표현 태그
                3. <% %> : 스크립트릿 태그
  
      - 액션 태그
           | 액션 태그 | 설명 |
           | :--: | :--: |
           | jsp:forward | request와 response 객체를 포함해 다른 페이지로 포워드함 |
           | jsp:include | 다른 페이지의 실행 결과를 포함시킴 |
           | jsp:useBean | 자바 빈즈 객체를 생성하거나 불러옴 |
           | jsp:setProperty | request와 response 객체를 포함해 다른 페이지로 포워드함 |
           | jsp:getProperty | request와 response 객체를 포함해 다른 페이지로 포워드함 |
           | jsp:param | request와 response 객체를 포함해 다른 페이지로 포워드함 |
        
      - 자바 빈
        - 인자가 없는 생성자(기본 생성자)로 구성된다.
        - 파일 혹은 네트워크를 통해 객체를 주고받을 수 있는 직렬화 구조가 가능하다.
        - getter, setter 메서드를 통해 멤버 변수(속성)에 접근한다.
        - POJ0라는 단순한 구조를 가진다.
        - 
      - useBean 액션
        1. useBean을 이용해 만든 객체의 범위는 지정하는 속성인 scope에 주어진 id의 객체가 있는지 확인한다.
        2. 객체가 없다면 새로 객체를 생성하고 해당 scope에 저장한다.
        3. property 속성에는 멤버 변수명 혹은 *을 사용해 전체 변수를 한 번에 지정할 수 있다.
        > <jsp:useBean id="instanceName" scope="page | request | session | application"<br>
                class="packageName.className" type="packageName.className"<br>
                 beanName="packageName.className" >
           </jsp:useBean>
      
      - 커스텀 태그
        - 사용자 정의 태그를 의미한다. 즉, 스크립트릿 사용을 줄이고 태그와 같은 형태로 프로그램 코드를 대체하거나 재활용 가능한 구졸르 통해 태그 라이브로리로 활용하고자 개발된 규격.
        - 최근엔 JSTL을 더 많이 활용함.
          > <%@ taglib tagdir="/WEB-INF/tags" prefix="m" %> <br>
            <m:printData pid="87459989" />
      - EL (표현 언어)
        - 현재 페이지의 자바 객체 혹은 application, session, request, page와 같은 scope object에 저장된 자바 빈 객체를 손쉽게 접근하고 사용 가능하다.
        - 간단한 구문으로 손쉽게 변수/객체를 참조할 수 있다.
        - 데이터가 없거나 null 객체를 참조할 때 에러가 발생하지 않는다.
          > ${저장이름.변수명}
          > <br>
          > <br>
          > (h2)멤버 정보(/h2) <br>
             이름: ${m.name} <br>
          > <br>
          > 이름: <%= m.name %> (br) // 표현식 사용
          > <br>
          > <br>
          > 이름: <jsp:getProperty name="m" property="name" /> (br) // 액션 사용 <br>
          > <br>
          > EL 연산 <br>
          > ${10 + 20} // 사칙연산, 30 <br>
          > ${10 * 20} // 사칙연산, 200 <br>
          > ${true && false} // 사칙연산, false <br>
          > ${10 >= 20} // 사칙연산, false <br>
          > ${user.name = = "홍길동" ? "교수" : "학생"} // 3항 연산, 이름이 홍길동이면 교수 출력 <br>
          > <br>
          > 배열, 맵 데이터 연동 <br>
          > ${myList[0]} // 배열인 경우 <br>
          > ${myMap["name"]} // 맵인 경우 <br>
          > <br>
          > Scope Object 접근 <br>
          > 이름: ${requestScope.m.name} <br>
      - JSTL
        - 서버에서만 해석할 수 있는 구조
        - UI 확인을 위해 서버를 통해야만 함.
          > <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      - core 라이브러리 - 흐름 제어를 제일 많이 사용함.
        | 기능 | 태그 | 사용 예 |
        | :--: | :--: | :--: |
        | 변수 관련 | remove, set | 변수 지정과 삭제 |
        | 흐름 제어 | if, choose, when, otherwise, forEach, forTokens | 조건 처리, 반복, 토큰 피싱 |
        | URL 관리 | import, redirect, url, param | URL 핸들링 |
        | 기타 | catch, out | 에러 처리, 출력 |
         - <c:if> - 자바의 if문과 유사하지만 else는 지원x
           > <c:if test="조건" [var="결과 변수"] [scope="{page|request|session|application}"]> <br>
           >    조건이 참(true)인 경우 출력되는 부분 <br>
           > </c:if>
        - <c:forEach> - 화면에 데이터를 반복해서 출력할 때 주로 사용
          > <c:forEach [var="참조 객체"] [varStatus="상태 정보 변수"] begin="시작" end="종료" <br>
          > [step="반복 단계 증가 값, 1이 기본"]> <br>
          > 반복 출력되는 부분 <br>
          > </c:forEach>
   - Maven 기반 프로젝트
      - maven은 빌드 설정을 'pom.xml' 파일에 작성하는데, xml 구조라 프로젝트에 따라 가독성이 떨어질 수 있다.
      - gradle은 groovy라고 하는 JVM 기반 언어를 통해 프로그램 구조를 설정하기에 maven보다 짧고 간결하다.
   - 리포지터리
     - 빌드 도구를 사용하는 목적은 컴파일/실행 설정과 라이브러리 설정이다.
     - 빌드 도구를 사용하면 꼭 필요한 핵심 라이브러리만 설정 파일에 등록해두면 해당 라이브러리에서 필요로 하는 다른 라이브러리는 자동으로 함께 설치됨.
     - 리포지터리는 이런 라이브러리를 보관하는 일종의 저장소소
      

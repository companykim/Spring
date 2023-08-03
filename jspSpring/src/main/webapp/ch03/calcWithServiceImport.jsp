<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="www.dream.bb.serivce.SCalc" %>
    <!-- C:\JavaWorkSpace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina
    	\localhost\jspSpring\org\apache\jsp\ch03\calcWithServiceImport_jsp.java -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
JSP 결과물

<%= SCalc.calc(request) %>
</body>
</html>
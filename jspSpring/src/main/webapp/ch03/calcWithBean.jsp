<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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
	<jsp:useBean id="myReq" scope="page" 
		class="www.dream.bb.model.CalcReqBean"/>
	<jsp:setProperty name="myReq" property="*"/>
	${ myReq.Calc() }
	<br> ${ myReq.opFt }
	<br> ${ myReq.arr[1] }
	
</body>
</html>
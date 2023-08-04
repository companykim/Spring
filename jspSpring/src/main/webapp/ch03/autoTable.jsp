<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.List, www.dream.framework.display.VODisplayer, www.dream.bb.model.BillVO, www.dream.framework.display.ViewType" %>

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
	
		<table border="1" bordercolor="blue" width="500" align="center">
			<tr align="center" bgcolor="skybule">
	<%  List<String> list = VODisplayer.getCaptionList(BillVO.class, ViewType.List);
		for (String caption : list) { %>
				<th><%= caption %></th>
	<%  } %>
			</tr>

	<%  List<BillVO> listData = BillVO.getData();
		for (BillVO data : listData) { %>
			<tr align="center" bgcolor="skybule">
	<%  List<Object> listFieldData = VODisplayer.getDataList(data, ViewType.List);
	
		for (Object oo : listFieldData) { %>
				<td><%= oo %></td>
	<%  } %>
			</tr>
	<%  } %>
			
		</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="method.Method"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<%
			request.setCharacterEncoding("utf-8");
				String v_id=request.getParameter("id");
				Method method=new Method();
				boolean a=method.queryIdExist(v_id);
				if(a){
					request.getRequestDispatcher("success.jsp").forward(request,response);
					
				}
				else{
					request.getRequestDispatcher("failure.jsp").forward(request,response);
				}
			%>
</body>
</html>
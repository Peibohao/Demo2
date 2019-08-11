<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="method.Method" %>
<%@ page import="java.text.DateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

			<font size=20>验证成功！</font><br/><br/><br/>
		<%
			request.setCharacterEncoding("utf-8");
			String v_id=request.getParameter("id");
			
			Method method=new Method();
			
			 if(method.queryNumById()==0)
				 method.updateTimeById();
				method.updateNumById();
				DateFormat df4 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
				out.println("当前验证次数为："+method.queryNumById()+"次"+"<br/><br/><br/>");
				if(method.queryNumById()>5) {
					out.println("当前验证次数已超过5次，首次认证时间为"+df4.format(method.queryTimeById())+" 请注意购买渠道，谨防假冒伪劣产品！");
					return;
				}
				out.println("首次验证时间为："+df4.format(method.queryTimeById()));
			
		%>
		
		
</body>
</html>
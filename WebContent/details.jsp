<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="entity.Items"%>
<%@ page import="dao.ItemsDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
div {
	float: left;
	margin-left: 30px;
	margin-right: 30px;
	margin-top: 5px;
	margin-bottom: 5px;
}

div dd {
	margin: 0px;
	font-size: 10pt;
}

div dd.dd_name {
	color: blue;
}

div dd.dd_city {
	color: #000;
}
</style>
</head>

<body>
<h1>商品详情</h1>
<hr>
<center>
<table width="750" height="60" cellpadding="0" cellspacing="0"
	border="0">
	<tr>
		<!-- 商品详情 -->
		<% 
             ItemsDAO itemDao = new ItemsDAO();
             Items item = itemDao.getItemsById(Integer.parseInt(request.getParameter("id")));
             if(item!=null)
             {
          %>
		<td width="70%" valign="top">
		<table>
			<tr>
				<td rowspan="4"><img src="images/<%=item.getPicture()%>"
					width="200" height="160" /></td>
			</tr>
			<tr>
				<td><B><%=item.getName() %></B></td>
			</tr>
			<tr>
				<td>产地：<%=item.getCity()%></td>
			</tr>
			<tr>
				<td>价格：<%=item.getPrice() %>￥</td>
			</tr>
		</table>
		</td>
		<% 
            }
          %>
		<% 
             String list = "";
          	 //Get cookies set from client
          	 Cookie[] cookies = request.getCookies();
          	 
          	 //travel cookie set
          	 if(cookies != null && cookies.length > 0){
          		 //for-each try to print the cookie information
          		 for(Cookie c : cookies){
          			 if(c.getName().equals("ListView"))
          			 	list = c.getValue();
          		 }
          	 }
          	 
          	 String[] array = list.split(",");
          	 if(array.length > 1000){
          		 list = "";
          	 }
          	 list += request.getParameter("id") + ",";
          	 
          	 Cookie cookie = new Cookie("ListView",list);
          	 response.addCookie(cookie);
          	 
          %>
		<!-- 浏览过的商品 -->
		<td width="30%" bgcolor="#EEE" align="center"><br>
		<b>您浏览过的商品</b><br>
		<!-- 循环开始 --> <% 
                  ArrayList<Items> itemlist = itemDao.getViewList(list);
                if(itemlist!=null&&itemlist.size()>0 )
                {
                   System.out.println("itemlist.size="+itemlist.size());
                   for(Items i:itemlist)
                   {
                         
             %>
		<div>
		<dl>
			<dt><a href="details.jsp?id=<%=i.getId()%>"><img
				src="images/<%=i.getPicture() %>" width="120" height="90" border="1" /></a>
			</dt>
			<dd class="dd_name"><%=i.getName() %></dd>
			<dd class="dd_city">产地:<%=i.getCity() %>&nbsp;&nbsp;价格:<%=i.getPrice() %>
			￥</dd>
		</dl>
		</div>
		<% 
                   }
                }
             %> <!-- 循环结束 --></td>
	</tr>
</table>
</center>
</body>
</html>

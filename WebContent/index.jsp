<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib.jsp"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>唱片列表</title>
	<link href="css/record.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
	function buy(id){
		var form = document.forms[0];
		form.id.value=id;
		form.submit();
	}
	
	</script>
  </head>
  
  <body>
  <form action="">
  	<input type="hidden" name="type" value="buy"/>
  	<input type="hidden" name="id" value="s"/>
  </form>
  <c:forEach items="${list}" var="r">
	<div class="record">
		<a class="image" href="#">
			<img src="images/${r.image }" alt="图片"/>
		</a>
		<div class="right">
			<span class="fl">${r.name }&nbsp;&nbsp;音乐家:${r.author }&nbsp;&nbsp;(售价:${r.price }元)</span>
			<br />
			<em>简介:${r.intro }</em>
			<br />
			<div class="menu">
				<a href="javascript:buy('${r.id}');">购买</a>
			</div>
		</div>
	</div>
   </c:forEach>
  </body>
</html>

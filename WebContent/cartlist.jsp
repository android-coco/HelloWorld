<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/WEB-INF/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cartlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function updataCount(id){
			var v=$("count"+id);
			var form=document.forms[0];
			form.id.value=id;
			form.count.value=v.value;
			form.submit();
		}
		function $(id){
			return document.getElementById(id);
		}
	</script>
  </head>
  
  <body>
  <form action="RecordCtrl">
  	<input type="hidden" name="type" value="updataCount"/>
  	<input type="hidden" name="id">
  	<input type="hidden" name="count">
  </form>
  <div align="center"><h1>您的购物车信息</h1></div>
  <table align="center" width="760px" border="1" cellspacing="0" bordercolor="#CCC">
  	<tr>
    		<th>编号</th>
    		<th>唱片名</th>
    		<th>作者</th>
    		<th>数量</th>
    		<th>单价</th>
    		<th>小计</th>
    		<th>操作</th>
    	</tr>
    	<c:if test="${fn:length(cart)==0}">
    		<tr>
    			<td colspan="6" align="center"><h3>您还没有购买任何商品！</h3></td>
    		</tr>
    	</c:if>
    	<c:set var="total" value="0"></c:set>
    	<c:forEach items="${cart}" var="entry" varStatus="sta">
    	<tr>
    		<td>${sta.count }</td>
    		<td>${entry.value.recordInfo.name }</td>
    		<td>${entry.value.recordInfo.author }</td>
    		<td width="80">
    			<input id="count${entry.key }" style="width:35px;text-align:center;" type="text" value="${entry.value.count }"/>
    			<a href="javascript:updataCount('${entry.key }');">更新</a>
    		</td>
    		<td><fmt:formatNumber pattern="0.00" value="${entry.value.recordInfo.price }"></fmt:formatNumber></td>
    		
	    	<c:set var="temp" value="${entry.value.count*entry.value.recordInfo.price }"></c:set>
	    	<c:set var="total" value="${total+temp}"></c:set>
    		<td><fmt:formatNumber pattern="0.00" value="${temp}"></fmt:formatNumber></td>
    		<td><input type="button" value="取消" onclick="window.location.href='RecordCtrl?type=removeCart&id=${entry.key }'"></td>
    		</tr>
    	</c:forEach>
    	<tr>
    	<td align="right" colspan="6"><b>合计</b></td>
    	<td> <font color="blue">
    	<fmt:formatNumber pattern="0.00" value="${total }"></fmt:formatNumber>
    	</font></td>
    	</tr>
  </table>
    	<div align="center">
    	<br/>
    	<input type="button" value="继续购买" onclick="window.location.href='RecordCtrl?type=list'"><br/><br/>
    	<input type="button" value="提交订单"onclick="window.location.href='order.jsp'">
    	</div>
  </body>
</html>

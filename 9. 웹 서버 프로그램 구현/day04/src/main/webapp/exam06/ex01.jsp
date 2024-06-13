<%@ page contentType="text/html; charset=UTF-8" %>

<%

pageContext.setAttribute("key1","value1");

%>

<jsp:include page="ex02.jsp" />
//서로 다른 서블릿 생성 => ex01, ex02
<%
String key1 = (String)pageContext.getAttribute("key1");

%>

<div>
ex01-key1: <%=key1%>
</div>
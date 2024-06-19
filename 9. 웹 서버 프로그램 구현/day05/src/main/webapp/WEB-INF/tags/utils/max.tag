<%@ tag body-content="empty" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ attribute name="num1" type="java.lang.Integer" required="true" %>
<%@ attribute name="num2" type="java.lang.Integer" required="true" %>
<%@ variable name-given="maximum" variable-class="java.lang.Integer"
scope="AT_END" %>
베리어블 스코프 가지고 내부에서 연산한 내용을 밖으로 내보낼 수 있다.

<%
int max = num1 > num2 ? num1 : num2;
%>

<c:set var="maximum" value="<%=max%>" />
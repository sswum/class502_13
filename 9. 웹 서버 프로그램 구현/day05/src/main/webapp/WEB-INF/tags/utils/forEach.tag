<%@ tag body-content="scriptless" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ attribute name="var" required="true" rtexprvalue="false" %>
<%@ attribute name="begin" type="java.lang.Integer" required="true" %>
<%@ attribute name="end" type="java.lang.Integer" required="true" %>
<%@ variable name-from-attribute="var" alias="cnt" variable-class="java.lang.Integer"
scope="NESTED" %>
<%
for (int i= begin; i<= end; i++) {  %>
<c:set var="cnt" value="<%=i%>" />
<jsp:doBody />
<% } %>



<%-- 내부에서 반복적으로 표기하는 것을 포이치로 만들기 --%>
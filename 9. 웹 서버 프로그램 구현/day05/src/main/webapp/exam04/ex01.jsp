<%@ page contentType="text/html charset=UTF-8" %>

<%
pageContext.setAttribute("num",10);

%>
//Object라서 형변환 없이 사용 가능


${100 + 200}<br> //간단한 연산식

${num == 10? "숫자 10입니다" : "숫자 10이 아닙니다"}
//삼항+조건 사용
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="board.entities.BoardData" %>
<jsp:useBean id="item" class="board.entities.BoardData" scope="request" />

<jsp:setProperty name="item" property="subject"  />
<jsp:setProperty name="item" property="content"/>
<jsp:setProperty name="item" property="poster"  />

<%--메서드 호출 가능 자바객체기 때문에 요게 EL식으로 간단하게 쓴 것임.
제목 : ${item.getSubject()}<br>
속성명만 입력해도 위에 getSubject와 출력값은 같게 나온다 ! --%>
제목: ${item.subject}<br>
내용: ${item.content}<br>
작성자: ${item.poster}<br>


<%--
제목 : <jsp:getProperty name="item" property="subject" /><br>
내용 : <jsp:getProperty name="item" property="content" /><br>
작성자 : <jsp:getProperty name="item" property="poster" /><br>
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="actionUrl" value="/survey/step3" />

<h2>step2</h2>
<form:form method="post" action="${actionUrl}" autocomplete="off"
modelAttribute="requestSurvey">


    질문1 : <form:input path="q3" /><br>
    질문2 : <form:input path="q4" /><br>
   <button type="submit">제출하기</button>
      </form:form>
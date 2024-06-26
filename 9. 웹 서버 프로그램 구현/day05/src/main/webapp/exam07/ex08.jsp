<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:if test="${!empty param.lang}">
    <fmt:setLocale value="${param.lang}" />

<fmt:setBundle basename="messages.commons" />

<a href="?lang=ko">한국어</a>
<a href="?lang=en">English</a>

    <form>
        <fmt:message key="EMAIL" />
        <input type="text" name="email"><br>

        <fmt:message key="PASSWORD" />
        <input type="password" name="PASSWORD"><br>
        <button type='submit'>
            <fmt:message key="LOGIN" />
        </button>
    </form>

<h1>
    <fmt:message key="LOGIN_MSG">
        <fmt:param>이이름</fmt:param>
        <fmt:param>test@test.org</fmt:param>
    </fmt:message>
</h1>
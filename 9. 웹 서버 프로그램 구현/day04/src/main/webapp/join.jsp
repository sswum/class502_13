<%@ page contentType="text/html; charset=UTF-8" %>
<%

// _jspService() 지역 내부

int num1 = 100;
int num2 = 200;
out.write("result=" + (num1 + num2));

%>

<%-- JSP 주석 ... --%>
<%--
out.write("<br>이름:" + name);
print();
--%>





<%!
//클래스명 바로 아래쪽 -멤버변수(함수정의는 못함)
//위치가 아래여도 위에꺼 접근해서 위에

String name = "이이름";
void print() {
System.out.print(name);
}
%>

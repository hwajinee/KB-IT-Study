<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2025-05-29
  Time: 오후 3:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>방무자수 조회하기 화면</h1>
<%
  // application 객체에서 countValue 값 꺼내기
  // Object 객체이므로, 형변환 필수
  int count = (Integer)application.getAttribute("countValue");
%>

현재까지 총 방문자수 : <%= count%>
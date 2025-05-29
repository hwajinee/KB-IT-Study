<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<body>
<h1>로그인 정보 보기</h1>
<%
  // 세션에서 사용자 아이디 꺼내기 (형변환 해야 함.)
  String id = (String) session.getAttribute("userid");
  if(id == null){
    response.sendRedirect("loginForm.html");
  } else {
    // 세션에서 비밀번호 꺼내기
    String pw = (String) session.getAttribute("password");
    // 사용자 정보 출력
    out.print("사용자 아이디값: " + id + "<br>");
    out.print("사용자 비밀번호값: " + pw + "<br>");
    // 로그아웃 클릭 시, logout.jsp로 링크 이동
    out.print("<a href='logout.jsp'>로그 아웃</a>");
  }
%>
</body>
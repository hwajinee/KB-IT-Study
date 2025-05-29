package org.scoula.ex02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {

        // MIME 타입 설정 (HTML + UTF-8 인코딩 지정)
        response.setContentType("text/html;charset=UTF-8");

        // Java I/O
        PrintWriter out = response.getWriter();

        // html 작성 및 출력
        out.print("<html><body>");
        out.print("ResponseServlet 요청 성공");
        out.print("</body></html>");

    }
}

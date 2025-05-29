package org.scoula.ex02;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="MyServlet", urlPatterns = {"/xxx", "/yyy"})
public class MyServlet extends HttpServlet {
    // GET 방식 요청 처리    
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
        System.out.println("HelloServlet 요청 ");

            // 클라이언트에게 HTML 응답 출력
            PrintWriter out = response.getWriter();
            out.println("<h1>Hello Servlet</h1>");
    }
}


